package at.bestsolution.githubmgr.ui.controller;

import javax.inject.Inject;

import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import at.bestsolution.githubmgr.model.githubmgr.Project;
import at.bestsolution.githubmgr.ui.projectoverview.ProjectOverviewController;

@SuppressWarnings("restriction")
public class E4ProjectOverviewController extends ProjectOverviewController {
	@Inject
	private ECommandService commandService;
	
	@Inject
	private MApplication application;
	
	@Inject
	private MWindow window;
	
	@Inject
	private EPartService partService;
	
	@Inject
	private EModelService modelService;
	
	@Override
	public void openProject(Project project) {
		MPerspectiveStack s = (MPerspectiveStack) window.getChildren().get(0);
		for( MPerspective p : s.getChildren() ) {
			if( p.getTransientData().get("project") == project ) {
				partService.switchPerspective(p);
				break;
			}
		}
		
		MPerspective p = (MPerspective) modelService.cloneSnippet(application, "at.bestsolution.githubmgr.app.perspective.project.template", window);
		s.getChildren().add(p);
		partService.switchPerspective(p);
	}
	
}
