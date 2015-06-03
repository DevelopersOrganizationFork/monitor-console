package monitorconsole;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonActionListener implements ActionListener {
	
	private ConsoleUI ui;
	
	
	public RadioButtonActionListener(ConsoleUI ui) {
		this.ui = ui;
	}

	public void actionPerformed(ActionEvent actionEvent) {
    	
		String actionValue = actionEvent.getActionCommand();
		
		if(actionValue.equals("CPU") || actionValue.equals("Memory") || actionValue.equals("Network Up") || actionValue.equals("Network Down"))
			ui.setcurrentMeasurementType(actionValue);
		else if (actionValue.equals("ascending") || actionValue.equals("descending"))
			ui.setcurrentSortType(actionValue);
		else if(actionValue.equals("hostName") || actionValue.equals("hostIp") || actionValue.equals("measurementValue"))
			ui.setcurrentSortKey(actionValue);
    }
}
