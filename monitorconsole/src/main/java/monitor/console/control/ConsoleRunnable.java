package monitor.console.control;
import monitor.console.data.JSONManager;
import monitor.console.view.ConsoleUI;
import org.json.*;

public class ConsoleRunnable implements Runnable {
	
	private ConsoleUI ui;
	private JSONManager jsonManager;
	 
	public ConsoleRunnable(ConsoleUI ui) {
		this.ui = ui;
		jsonManager = new JSONManager();
	}
	
	public void run() {
					
		jsonManager.fetchData(ui.getCurrentMeasurementType());
		jsonManager.sortData(ui.getCurrentSortType(), ui.getCurrentSortKey());
		jsonManager.prepareOutputData();
		ui.print(jsonManager.getOutputData());
	}
}