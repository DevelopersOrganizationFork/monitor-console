package monitorconsole;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleClient {

	private static final long DEFAULT_DELAY = 0L;
	private static final long DEFAULT_INTERVAL = 5L;
	private ConsoleUI ex;
	
	public void start() {
		ScheduledExecutorService executor = Executors
				.newSingleThreadScheduledExecutor();
		
	 	ex = new ConsoleUI();
	 	ex.setVisible(true);
	 	
		
		ConsoleRunnable runner = new ConsoleRunnable(ex);
		
		executor.
		scheduleWithFixedDelay(runner, DEFAULT_DELAY, DEFAULT_INTERVAL,TimeUnit.SECONDS);	
	}
}