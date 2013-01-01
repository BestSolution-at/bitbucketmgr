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
package at.bestsolution.githubmgr.services;

import org.eclipse.core.runtime.IProgressMonitor;

import at.bestsolution.githubmgr.services.model.Repository;

public interface RepositoryService {
	public Repository create(IProgressMonitor monitor, String name, boolean isPrivate);
	public Repository findRepository(IProgressMonitor monitor, String owner, String name);
}
