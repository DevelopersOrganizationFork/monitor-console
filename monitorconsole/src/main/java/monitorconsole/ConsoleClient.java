package monitorconsole;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import monitorconsole.ConsoleRunnable;


public class ConsoleClient {

	private static final long DEFAULT_DELAY = 0L;
	private static final long DEFAULT_INTERVAL = 5L;
	
	public void start() {
		ScheduledExecutorService executor = Executors
				.newSingleThreadScheduledExecutor();
		
		ConsoleRunnable runner = new ConsoleRunnable();
		
		executor.
		scheduleWithFixedDelay(runner, DEFAULT_DELAY, DEFAULT_INTERVAL,TimeUnit.SECONDS);
	}
}

