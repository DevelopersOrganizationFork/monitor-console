package monitorconsole;
import java.util.*;
import org.json.*;

public class ConsoleRunnable implements Runnable {
	
	private static int counter = 0;
	private ConsoleUI ui;
	private Random generator;
	private String frontSpacer;
	private String hostNameTitle;
	private String hostIpTitle;
	private String measurementTitle;
	private String outputData;
	private JSONObject obj;
	 
	public ConsoleRunnable(ConsoleUI ui) {
		this.ui = ui;
		
		generator = new Random();
		frontSpacer = String.format("%2s", "");
		hostNameTitle = String.format("%-20s", "Host name");
		hostIpTitle = String.format("%-20s", "Host IP");
		measurementTitle = String.format("%-10s", "Measurement");
		
		initOutputHeader();
	}
	
	private void initOutputHeader() {
		outputData = frontSpacer + hostNameTitle + hostIpTitle  + measurementTitle + "\n\n";
	}
	
	public void run() {
					
		counter++;
		String currentMeasurementType = ui.getCurrentMeasurementType();
		
		if(currentMeasurementType.equals("CPU"))
			obj = new JSONObject(JSONmock.cpu[generator.nextInt(3)]);
		else if(currentMeasurementType.equals("Memory"))
			obj = new JSONObject(JSONmock.mem[generator.nextInt(3)]);
		else if(currentMeasurementType.equals("Network Up"))
			obj = new JSONObject(JSONmock.up[generator.nextInt(3)]);
		else if(currentMeasurementType.equals("Network Down"))
			obj = new JSONObject(JSONmock.down[generator.nextInt(3)]);
				
	    final JSONArray jsonArray = obj.getJSONArray("measurements");
	    
	    List<JSONObject> jsonValues = new ArrayList<JSONObject>();
	    for (int i = 0; i < jsonArray.length(); ++i) {
	    	jsonValues.add(jsonArray.getJSONObject(i));
	    }
	    
	    Collections.sort(jsonValues, new JSONComparator(ui.getCurrentSortType()));
	    	
	    JSONArray  res = new JSONArray();
	    for (Object o : jsonValues){
	      res.put(o);
	    }
	   
	    for (int i = 0; i < res.length(); ++i) {
	    	final JSONObject singleMeasurement = res.getJSONObject(i);
		      
		      String hostName = String.format("%-20s", singleMeasurement.getString("hostName"));
		      String hostIp = String.format("%-20s", singleMeasurement.getString("hostIp"));
		      String measurement = String.format("%4s", ""+singleMeasurement.getInt("measurementValue")+"%");
			
			outputData += frontSpacer + hostName + hostIp + measurement + "\n";
	    }
			
		ui.print(outputData);
		initOutputHeader();
	}
}