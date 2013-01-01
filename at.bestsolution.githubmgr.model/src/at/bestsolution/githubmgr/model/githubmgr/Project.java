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
package at.bestsolution.githubmgr.model.githubmgr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link at.bestsolution.githubmgr.model.githubmgr.Project#getName <em>Name</em>}</li>
 *   <li>{@link at.bestsolution.githubmgr.model.githubmgr.Project#getRepositoryList <em>Repository List</em>}</li>
 *   <li>{@link at.bestsolution.githubmgr.model.githubmgr.Project#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.bestsolution.githubmgr.model.githubmgr.GithubmgrPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see at.bestsolution.githubmgr.model.githubmgr.GithubmgrPackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.bestsolution.githubmgr.model.githubmgr.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Repository List</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.githubmgr.model.githubmgr.Repository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository List</em>' containment reference list.
	 * @see at.bestsolution.githubmgr.model.githubmgr.GithubmgrPackage#getProject_RepositoryList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepositoryList();

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(byte[])
	 * @see at.bestsolution.githubmgr.model.githubmgr.GithubmgrPackage#getProject_Icon()
	 * @model
	 * @generated
	 */
	byte[] getIcon();

	/**
	 * Sets the value of the '{@link at.bestsolution.githubmgr.model.githubmgr.Project#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(byte[] value);

} // Project
