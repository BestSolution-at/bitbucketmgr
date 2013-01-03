package at.bestsolution.githubmgr.ui.controller;

import at.bestsolution.efxclipse.runtime.di.CachingContextFunction;

public class ProjectOverviewControllerFactory extends CachingContextFunction {

	public ProjectOverviewControllerFactory() {
		super(E4ProjectOverviewController.class);
	}

}
