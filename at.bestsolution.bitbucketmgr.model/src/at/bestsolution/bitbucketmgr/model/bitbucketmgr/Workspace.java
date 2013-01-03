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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace#getProjectList <em>Project List</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.BitbucketmgrPackage#getWorkspace()
 * @model
 * @generated
 */
public interface Workspace extends EObject {
	/**
	 * Returns the value of the '<em><b>Project List</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project List</em>' containment reference list.
	 * @see at.bestsolution.bitbucketmgr.model.bitbucketmgr.BitbucketmgrPackage#getWorkspace_ProjectList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Project> getProjectList();

} // Workspace
