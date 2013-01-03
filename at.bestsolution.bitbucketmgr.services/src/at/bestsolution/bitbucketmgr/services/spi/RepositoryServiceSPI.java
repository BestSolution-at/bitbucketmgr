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
package at.bestsolution.bitbucketmgr.services.spi;

import java.util.List;

import at.bestsolution.bitbucketmgr.services.RepositoryService;
import at.bestsolution.bitbucketmgr.services.model.Contributor;
import at.bestsolution.bitbucketmgr.services.model.Repository;

public interface RepositoryServiceSPI extends RepositoryService {
	public List<Contributor> findContributors(Repository repo);
}
