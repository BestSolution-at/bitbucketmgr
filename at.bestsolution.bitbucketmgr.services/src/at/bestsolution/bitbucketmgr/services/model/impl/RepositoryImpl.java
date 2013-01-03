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
package at.bestsolution.githubmgr.services.model.impl;

import java.util.Collections;
import java.util.List;

import at.bestsolution.githubmgr.services.model.Contributor;
import at.bestsolution.githubmgr.services.model.Repository;
import at.bestsolution.githubmgr.services.spi.RepositoryServiceSPI;

public class RepositoryImpl implements Repository {
	private RepositoryServiceSPI service;
	
	private String name;
	
	private List<Contributor> contributors;
	
	public RepositoryImpl(RepositoryServiceSPI service) {
		this.service = service;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Contributor> getContributors() {
		if( contributors == null ) {
			contributors = service.findContributors(this);
		}
		return Collections.unmodifiableList(contributors);
	}
}
