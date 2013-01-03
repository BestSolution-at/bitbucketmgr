package at.bestsolution.bitbucketmgr.core.services;

public interface ProgressService {
	public <O,R> void execute(boolean fork, CallbackTask<O, R> task);
	public <O,R> R blocking(boolean fork, Task<O, R> task);
	
	public interface Task<O,R> {
		public R run(O object);
	}
	
	public interface CallbackTask<O,R> extends Task<O, R> {
		public void finished(R rv);
		public void failure(Throwable t);
	}
}
