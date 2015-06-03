package monitorconsole;
import java.util.*;
public class ConsoleRunnable implements Runnable {
	
	private static int counter = 0;
	private ConsoleUI ui;
	private Random generator;
	private String frontSpacer;
	private String hostNameTitle;
	private String hostIpTitle;
	private String measurementTitle;
	private String outputData;
	 
	public ConsoleRunnable(ConsoleUI ui) {
		this.ui = ui;
		
		generator = new Random();
		frontSpacer = String.format("%2s", "");
		hostNameTitle = String.format("%-20s", "Host name");
		hostIpTitle = String.format("%-20s", "Host IP");
		measurementTitle = String.format("%-10s", "Measurement");
		initOutputHeader();
	}
	
	private void initOutputHeader()
	{
		outputData = frontSpacer + hostNameTitle + hostIpTitle  + measurementTitle + "\n\n";
	}
	
	public void run() {
					
		counter++;
		
		for(int i=1; i<=10; i++) {
			String hostName = String.format("%-20s", "host"+i);
			String hostIp = String.format("%-20s", ""+counter);
			String measurement = String.format("%4s", ""+generator.nextInt(100)+"%");
			
			outputData += frontSpacer + hostName + hostIp + measurement + "\n";
		}
			
		ui.print(outputData);
		initOutputHeader();
	}
}