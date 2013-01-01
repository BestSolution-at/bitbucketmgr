package at.bestsolution.githubmgr.core.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;

import at.bestsolution.githubmgr.core.EventConstants;
import at.bestsolution.githubmgr.core.services.WorkspaceModelProvider;
import at.bestsolution.githubmgr.model.githubmgr.GithubmgrFactory;
import at.bestsolution.githubmgr.model.githubmgr.Project;
import at.bestsolution.githubmgr.model.githubmgr.Workspace;

@SuppressWarnings("restriction")
public class CreateProject {
	@Inject
	@Optional
	private IEventBroker broker;
	
	@Execute
	public void createProject(WorkspaceModelProvider modelProvider, @Named("projectName") String projectName) {
		Project p = GithubmgrFactory.eINSTANCE.createProject();
		p.setName(projectName);
		//TODO Use progress service
		Workspace ws = modelProvider.getWorkspace(new NullProgressMonitor());
		ws.getProjectList().add(p);
		if( broker != null ) {
			broker.send(EventConstants.PROJECT_TOPIC_NEW, p);
		}
	}
}
