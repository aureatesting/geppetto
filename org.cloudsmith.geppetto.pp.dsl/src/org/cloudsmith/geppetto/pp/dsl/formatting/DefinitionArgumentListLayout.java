/**
 * Copyright (c) 2012 Cloudsmith Inc. and other contributors, as listed below.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cloudsmith
 * 
 */
package org.cloudsmith.geppetto.pp.dsl.formatting;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.cloudsmith.geppetto.pp.DefinitionArgument;
import org.cloudsmith.geppetto.pp.DefinitionArgumentList;
import org.cloudsmith.geppetto.pp.dsl.services.PPGrammarAccess;
import org.cloudsmith.geppetto.pp.dsl.services.PPGrammarAccess.DefinitionArgumentListElements;
import org.cloudsmith.xtext.dommodel.DomModelUtils;
import org.cloudsmith.xtext.dommodel.IDomNode;
import org.cloudsmith.xtext.dommodel.formatter.DelegatingLayoutContext;
import org.cloudsmith.xtext.dommodel.formatter.DomNodeLayoutFeeder;
import org.cloudsmith.xtext.dommodel.formatter.ILayoutManager.ILayoutContext;
import org.cloudsmith.xtext.dommodel.formatter.css.Alignment;
import org.cloudsmith.xtext.dommodel.formatter.css.IStyleFactory;
import org.cloudsmith.xtext.dommodel.formatter.css.StyleSet;
import org.cloudsmith.xtext.formatting.utils.IntegerCluster;
import org.cloudsmith.xtext.textflow.ITextFlow;
import org.cloudsmith.xtext.textflow.MeasuredTextFlow;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * <p>
 * Performs semantic layout on a DefinitionArgumentList in combination with text-fit check.
 * </p>
 * <p>
 * if the DefinitionArgumentList list does not fit on the same line:
 * <ul>
 * <li>break after '(' and indent</li>
 * <li>break after each item on ',' (and break on end comma)</li>
 * <li>align '=' using clustered width padding</li>
 * <li>dedent on ')'</li>
 * </ul>
 * The styling is assigned to the nodes directly to override all other rule based styling.
 */
public class DefinitionArgumentListLayout {
	@Inject
	IStyleFactory styles;

	@Inject
	PPGrammarAccess grammarAccess;

	@Inject
	DomNodeLayoutFeeder feeder;

	protected final Predicate<IDomNode> caseColonPredicate = new Predicate<IDomNode>() {

		@Override
		public boolean apply(IDomNode input) {
			return input.getGrammarElement() == grammarAccess.getCaseAccess().getColonKeyword_2();
		}

	};

	private void assignAlignmentAndWidths(Map<IDomNode, Integer> operatorNodes, IntegerCluster cluster) {
		for(Entry<IDomNode, Integer> entry : operatorNodes.entrySet()) {
			int w = entry.getValue();
			entry.getKey().getStyles().add(
				StyleSet.withStyles(styles.align(Alignment.right), styles.width(1 + cluster.clusterMax(w) - w)));
		}

	}

	protected boolean fitsOnSameLine(DefinitionArgumentList o, StyleSet styleSet, IDomNode node, ITextFlow flow,
			ILayoutContext context) {
		DelegatingLayoutContext dlc = new DelegatingLayoutContext(context);
		MeasuredTextFlow continuedFlow = new MeasuredTextFlow((MeasuredTextFlow) flow);
		int h0 = continuedFlow.getHeight();
		for(IDomNode n : node.getChildren()) {
			feeder.sequence(n, continuedFlow, dlc);
		}
		int h1 = continuedFlow.getHeight();
		// if output causes break (height increases), or at edge (the '{' will not fit).
		return h1 <= h0 && continuedFlow.getWidthOfLastLine() < continuedFlow.getPreferredMaxWidth();
	}

	protected boolean format(DefinitionArgumentList o, StyleSet styleSet, IDomNode node, ITextFlow flow,
			ILayoutContext context) {

		if(!fitsOnSameLine(o, styleSet, node, flow, context))
			markup(o, styleSet, node, flow, context); // that was easy
		return false;
	}

	protected void markup(DefinitionArgumentList o, StyleSet styleSet, IDomNode node, ITextFlow flow,
			ILayoutContext context) {

		Iterator<IDomNode> itor = node.treeIterator();
		Map<IDomNode, Integer> operatorNodes = Maps.newHashMap();
		IntegerCluster cluster = new IntegerCluster(20);

		// With a little help From the grammar:
		// DefinitionArgumentList returns pp::DefinitionArgumentList : {pp::DefinitionArgumentList}
		// '('
		// (arguments += DefinitionArgument (',' arguments += DefinitionArgument)*)? ','?
		// ')'
		// ;
		//
		// DefinitionArgument returns pp::DefinitionArgument
		// : argName = UNION_VARIABLE_OR_NAME ((op = '=' | op = '=>') value = AssignmentExpression)?
		// ;
		final DefinitionArgumentListElements access = grammarAccess.getDefinitionArgumentListAccess();
		while(itor.hasNext()) {
			IDomNode n = itor.next();
			EObject ge = n.getGrammarElement();
			if(ge == access.getLeftParenthesisKeyword_1()) {
				IDomNode nextLeaf = DomModelUtils.nextLeaf(n);
				if(DomModelUtils.isWhitespace(nextLeaf))
					nextLeaf.getStyles().add(StyleSet.withStyles(styles.oneLineBreak(), styles.indent()));
			}
			else if(ge == access.getRightParenthesisKeyword_4()) {
				IDomNode prevLeaf = DomModelUtils.previousLeaf(n);
				if(DomModelUtils.isWhitespace(prevLeaf))
					prevLeaf.getStyles().add(StyleSet.withStyles(styles.dedent()));
			}
			else if(ge == access.getCommaKeyword_2_1_0()) {
				IDomNode nextLeaf = DomModelUtils.nextLeaf(n);
				if(DomModelUtils.isWhitespace(nextLeaf))
					nextLeaf.getStyles().add(StyleSet.withStyles(styles.oneLineBreak()));
			}
			// Break on endcomma does not look good - here is how it would be done though...
			// else if(ge == grammarAccess.getDefinitionArgumentListAccess().getEndCommaParserRuleCall_3()) {
			// IDomNode spaceAfterEndComma = DomModelUtils.nextLeaf(DomModelUtils.firstTokenWithText(n));
			// if(DomModelUtils.isWhitespace(spaceAfterEndComma))
			// spaceAfterEndComma.getStyles().add(StyleSet.withStyles(styles.oneLineBreak()));
			//
			// }
			else if(ge == grammarAccess.getDefinitionArgumentAccess().getOpEqualsSignGreaterThanSignKeyword_1_0_1_0() ||
					ge == grammarAccess.getDefinitionArgumentAccess().getOpEqualsSignKeyword_1_0_0_0()) {
				EObject semantic = n.getParent().getSemanticObject();
				if(semantic != null && semantic instanceof DefinitionArgument) {
					DefinitionArgument da = (DefinitionArgument) semantic;
					int length = da.getArgName() == null
							? 0
							: da.getArgName().length();
					operatorNodes.put(n, length);
					cluster.add(length);
				}
			}
		}
		assignAlignmentAndWidths(operatorNodes, cluster);
	}

}
