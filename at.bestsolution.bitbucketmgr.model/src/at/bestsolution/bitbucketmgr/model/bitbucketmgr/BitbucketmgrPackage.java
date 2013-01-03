/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.bitbucketmgr.model.bitbucketmgr;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.BitbucketmgrFactory
 * @model kind="package"
 * @generated
 */
public interface BitbucketmgrPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bitbucketmgr";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.bestsolution.at/bitbucketmgr";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bitbucketmgr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BitbucketmgrPackage eINSTANCE = at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.BitbucketmgrPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.WorkspaceImpl <em>Workspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.WorkspaceImpl
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.BitbucketmgrPackageImpl#getWorkspace()
	 * @generated
	 */
	int WORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Project List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__PROJECT_LIST = 0;

	/**
	 * The number of structural features of the '<em>Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.ProjectImpl
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.BitbucketmgrPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Repository List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__REPOSITORY_LIST = 1;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ICON = 2;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.RepositoryImpl
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.BitbucketmgrPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace
	 * @generated
	 */
	EClass getWorkspace();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace#getProjectList <em>Project List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Project List</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace#getProjectList()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_ProjectList();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project#getRepositoryList <em>Repository List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Repository List</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project#getRepositoryList()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_RepositoryList();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project#getIcon()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Icon();

	/**
	 * Returns the meta object for class '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Repository#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Repository#getOwner()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Owner();

	/**
	 * Returns the meta object for the attribute '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Repository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.Repository#getName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BitbucketmgrFactory getBitbucketmgrFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.WorkspaceImpl <em>Workspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.WorkspaceImpl
		 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.BitbucketmgrPackageImpl#getWorkspace()
		 * @generated
		 */
		EClass WORKSPACE = eINSTANCE.getWorkspace();

		/**
		 * The meta object literal for the '<em><b>Project List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE__PROJECT_LIST = eINSTANCE.getWorkspace_ProjectList();

		/**
		 * The meta object literal for the '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.ProjectImpl
		 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.BitbucketmgrPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Repository List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__REPOSITORY_LIST = eINSTANCE.getProject_RepositoryList();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__ICON = eINSTANCE.getProject_Icon();

		/**
		 * The meta object literal for the '{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.RepositoryImpl
		 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.impl.BitbucketmgrPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__OWNER = eINSTANCE.getRepository_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__NAME = eINSTANCE.getRepository_Name();

	}

} //BitbucketmgrPackage
