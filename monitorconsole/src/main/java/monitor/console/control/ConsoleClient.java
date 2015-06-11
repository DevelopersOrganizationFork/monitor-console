package monitor.console.control;

import monitor.console.view.ConsoleUI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class ConsoleClient {

	private static final long DEFAULT_DELAY = 0L;
	private static final long DEFAULT_INTERVAL = 5L;
	private ConsoleUI ui;
	
	public void start() {
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
	 	ui = new ConsoleUI();
	 	ui.setVisible(true);
	 	
	 	try {
	 		ConsoleRunnable runner = new ConsoleRunnable(ui);
	 	    executor.scheduleWithFixedDelay(runner, DEFAULT_DELAY, DEFAULT_INTERVAL,TimeUnit.SECONDS);	
	 	}
	 	catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}