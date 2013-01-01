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
package at.bestsolution.githubmgr.core.services.impl;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import at.bestsolution.efxclipse.runtime.core.log.Logger;
import at.bestsolution.efxclipse.runtime.core.log.LoggerFactory;
import at.bestsolution.githubmgr.core.services.WorkspaceModelProvider;
import at.bestsolution.githubmgr.model.githubmgr.GithubmgrFactory;
import at.bestsolution.githubmgr.model.githubmgr.Workspace;

public class XMIWorkspaceModelProvider implements WorkspaceModelProvider {
	
	private Resource r;
	
	private Logger logger;
	
	public void setLoggerFactory(LoggerFactory factory) {
		this.logger = factory.createLogger(getClass().getName());
	}
	
	public void unsetLoggerFactory(LoggerFactory factory) {
		this.logger = null;
	}
	
	@Override
	public Workspace getWorkspace(IProgressMonitor monitor) {
		if( r != null ) {
			return (Workspace) r.getContents().get(0);
		}
		
		BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		Filter filter = null;
		try {
			filter = context.createFilter(Location.INSTANCE_FILTER);
		} catch (InvalidSyntaxException e) {
			// ignore this.  It should never happen as we have tested the above format.
		}
		
		ServiceTracker<Location,Location> instanceLocation = new ServiceTracker<Location,Location>(context, filter, null);
		instanceLocation.open();
		File f;
		try {
			f = new File(instanceLocation.getService().getURL().toURI());
			f = new File(f, ".metadata/workspace.xmi");
		} catch (URISyntaxException e) {
			logger.error("Unable to determin workspace.xmi location", e);
			return null;
		}
		instanceLocation.close();
		
		URI uri = URI.createFileURI(f.getAbsolutePath());
		ResourceSet resourceSet = new ResourceSetImpl(); 
		if( f.exists() ) {
			r = resourceSet.getResource(uri, true);
		} else {
			r = resourceSet.createResource(uri);
			Workspace w = GithubmgrFactory.eINSTANCE.createWorkspace();
			r.getContents().add(w);
		}
		
		return (Workspace) r.getContents().get(0);
	}

	@Override
	public IStatus persist(IProgressMonitor monitor) {
		if( r != null ) {
			try {
				r.save(null);
				return Status.OK_STATUS;
			} catch (IOException e) {
				logger.error("Unable to save resource.", e);
				return new Status(IStatus.ERROR, "at.bestsolution.githubmgr.core.services", "Unable to save resource.");
			}
		}
		return Status.OK_STATUS;
	}
}
