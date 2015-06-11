package monitor.console.data;
import java.util.*;
import java.io.*;
import org.json.*;
import java.net.*;

public class JSONManager {

	private String frontSpacer;
	private String hostNameTitle;
	private String hostIpTitle;
	private String measurementTitle;
	private String outputData;
	private String currentMeasurementType;
	
	private JSONObject jsonObject;
	private JSONArray jsonArray;
	private JSONArray sortedJsonArray;
	private List<JSONObject> jsonObjectList;
	
	public JSONManager() {
		frontSpacer = String.format("%2s", "");
		hostNameTitle = String.format("%-30s", "Host name");
		hostIpTitle = String.format("%-20s", "Host IP");
		measurementTitle = String.format("%-10s", "Measurement");
	}
	
	public void fetchData(String currentMeasurementType) throws IOException {
		
		this.currentMeasurementType = currentMeasurementType.replaceAll(" ", "").toUpperCase();
		
		URL url = new URL("http://localhost:18080/monitor-back/hosts/topten");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String inputLine = in.readLine();
		inputLine = "{\"measurements\":" + inputLine + "}";
		in.close();
		
		jsonObject = new JSONObject(inputLine);
		JSONArray arr = jsonObject.getJSONArray("measurements"); 
		jsonObjectList = new ArrayList<JSONObject>();
	     
	    for (int i = 0; i < arr.length(); ++i) {
		    	
	    	String hostName = arr.getJSONObject(i).getString("name");
			String hostIp = arr.getJSONObject(i).getString("ip");
			String hostId = arr.getJSONObject(i).getString("id");
			
			URL url2 = new URL("http://localhost:18080/monitor-back/hosts/" + hostId +"/measurements/" + this.currentMeasurementType);
	        BufferedReader in2 = new BufferedReader(new InputStreamReader(url2.openStream()));

	        String inputLine2 = in2.readLine();
	        inputLine2 = "{\"data\":" + inputLine2 + "}";
	        in2.close();
	        
	        JSONObject tmp = new JSONObject(inputLine2);
		    JSONArray arr2 = tmp.getJSONArray("data"); 
			double measurement = arr2.getJSONObject(0).getDouble("value");
			
			JSONObject obj1 = new JSONObject();
		    obj1.put("hostName",hostName);
		    obj1.put("hostIp",hostIp);
		    obj1.put("measurementValue",measurement);
		    System.out.println(obj1);
			jsonObjectList.add(obj1);
	    }
	}
	
	public void sortData(String sortType, String sortKey) {
		
		Collections.sort(jsonObjectList, new JSONComparator(sortType, sortKey));
    	
	    sortedJsonArray = new JSONArray();
	    for (Object o : jsonObjectList){
	    	sortedJsonArray.put(o);
	    }
	}
	
	public void prepareOutputData() {
		
		outputData = frontSpacer + hostNameTitle + hostIpTitle  + measurementTitle + "\n\n";
	    
	    for (int i=0; i<sortedJsonArray.length(); ++i) {
			final JSONObject singleMeasurement = sortedJsonArray.getJSONObject(i);
		      
			String hostName = String.format("%-30s", singleMeasurement.getString("hostName"));
			String hostIp = String.format("%-20s", singleMeasurement.getString("hostIp"));
			String measurement = null;
			
			if(currentMeasurementType.equals("CPU") || currentMeasurementType.equals("MEMORY"))
				measurement = String.format("%7s", String.format("%6.2f",singleMeasurement.getDouble("measurementValue")*100)+"%");
			else
				measurement = String.format("%9s", String.format("%8.2f",singleMeasurement.getDouble("measurementValue")/1024)+" kb");
			
			outputData += frontSpacer + hostName + hostIp + measurement + "\n";
	    }
	}
	
	public String getOutputData() {
	    return outputData;
	}
}