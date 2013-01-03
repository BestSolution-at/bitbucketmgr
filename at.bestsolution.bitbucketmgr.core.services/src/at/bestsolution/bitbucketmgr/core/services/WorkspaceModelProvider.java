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
package at.bestsolution.bitbucketmgr.core.services;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace;

public interface WorkspaceModelProvider {
	public Workspace getWorkspace(IProgressMonitor monitor);
	public IStatus persist(IProgressMonitor monitor);
}
