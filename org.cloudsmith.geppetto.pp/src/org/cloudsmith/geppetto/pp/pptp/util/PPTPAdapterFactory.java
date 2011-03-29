/**
 * Copyright (c) 2011 Cloudsmith Inc. and other contributors, as listed below.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Cloudsmith
 * 
 */
package org.cloudsmith.geppetto.pp.pptp.util;

import org.cloudsmith.geppetto.pp.pptp.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.cloudsmith.geppetto.pp.pptp.PPTPPackage
 * @generated
 */
public class PPTPAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PPTPPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PPTPAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = PPTPPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if(object == modelPackage) {
			return true;
		}
		if(object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PPTPSwitch<Adapter> modelSwitch = new PPTPSwitch<Adapter>() {
		@Override
		public Adapter casePuppetTarget(PuppetTarget object) {
			return createPuppetTargetAdapter();
		}

		@Override
		public Adapter caseTargetEntry(TargetEntry object) {
			return createTargetEntryAdapter();
		}

		@Override
		public Adapter casePuppetDistribution(PuppetDistribution object) {
			return createPuppetDistributionAdapter();
		}

		@Override
		public Adapter caseRubyDirectory(RubyDirectory object) {
			return createRubyDirectoryAdapter();
		}

		@Override
		public Adapter casePredefined(Predefined object) {
			return createPredefinedAdapter();
		}

		@Override
		public Adapter caseFunction(Function object) {
			return createFunctionAdapter();
		}

		@Override
		public Adapter caseType(Type object) {
			return createTypeAdapter();
		}

		@Override
		public Adapter caseIDocumented(IDocumented object) {
			return createIDocumentedAdapter();
		}

		@Override
		public Adapter caseINamed(INamed object) {
			return createINamedAdapter();
		}

		@Override
		public Adapter caseTargetElement(TargetElement object) {
			return createTargetElementAdapter();
		}

		@Override
		public Adapter caseProperty(Property object) {
			return createPropertyAdapter();
		}

		@Override
		public Adapter caseParameter(Parameter object) {
			return createParameterAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.PuppetTarget <em>Puppet Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.PuppetTarget
	 * @generated
	 */
	public Adapter createPuppetTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.TargetEntry <em>Target Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.TargetEntry
	 * @generated
	 */
	public Adapter createTargetEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.PuppetDistribution <em>Puppet Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.PuppetDistribution
	 * @generated
	 */
	public Adapter createPuppetDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.RubyDirectory <em>Ruby Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.RubyDirectory
	 * @generated
	 */
	public Adapter createRubyDirectoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.Predefined <em>Predefined</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.Predefined
	 * @generated
	 */
	public Adapter createPredefinedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.IDocumented <em>IDocumented</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.IDocumented
	 * @generated
	 */
	public Adapter createIDocumentedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.INamed <em>INamed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.INamed
	 * @generated
	 */
	public Adapter createINamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.TargetElement <em>Target Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.TargetElement
	 * @generated
	 */
	public Adapter createTargetElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.cloudsmith.geppetto.pp.pptp.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.cloudsmith.geppetto.pp.pptp.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PPTPAdapterFactory
