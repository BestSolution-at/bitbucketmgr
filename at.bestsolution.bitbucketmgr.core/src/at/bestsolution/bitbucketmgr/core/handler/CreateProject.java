package at.bestsolution.bitbucketmgr.core.handler;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;

import at.bestsolution.bitbucketmgr.core.EventConstants;
import at.bestsolution.bitbucketmgr.core.services.WorkspaceModelProvider;
import at.bestsolution.bitbucketmgr.model.bitbucketmgr.BitbucketmgrFactory;
import at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project;
import at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace;

@SuppressWarnings("restriction")
public class CreateProject {
	@Inject
	@Optional
	private IEventBroker broker;
	
	@Execute
	public void createProject(WorkspaceModelProvider modelProvider, @Named("projectName") String projectName) {
		Project p = BitbucketmgrFactory.eINSTANCE.createProject();
		p.setName(projectName);
		//TODO Use progress service
		Workspace ws = modelProvider.getWorkspace(new NullProgressMonitor());
		ws.getProjectList().add(p);
		modelProvider.persist(new NullProgressMonitor());
		if( broker != null ) {
			broker.send(EventConstants.PROJECT_TOPIC_NEW, p);
		}
	}
}
