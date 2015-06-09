package monitor.console.data;
import java.util.*;
import org.json.*;

public class JSONManager {

	private Random generator;

	private String frontSpacer;
	private String hostNameTitle;
	private String hostIpTitle;
	private String measurementTitle;
	private String outputData;
	
	private JSONObject jsonObject;
	private JSONArray jsonArray;
	private JSONArray sortedJsonArray;
	private List<JSONObject> jsonObjectList;
	
	//private Document doc;
	
	public JSONManager() {
		generator = new Random();
		
		frontSpacer = String.format("%2s", "");
		hostNameTitle = String.format("%-20s", "Host name");
		hostIpTitle = String.format("%-20s", "Host IP");
		measurementTitle = String.format("%-10s", "Measurement");
	}
	
	public void fetchData(String currentMeasurementType) {
		
		if(currentMeasurementType.equals("CPU"))
			jsonObject = new JSONObject(JSONmock.cpu[generator.nextInt(3)]);
			//doc = Jsoup.connect("http://localhost/topten/CPU").get();
		else if(currentMeasurementType.equals("Memory"))
			jsonObject = new JSONObject(JSONmock.mem[generator.nextInt(3)]);
			//doc = Jsoup.connect("http://localhost/topten/MEMORY").get();
		else if(currentMeasurementType.equals("Network Up"))
			jsonObject = new JSONObject(JSONmock.up[generator.nextInt(3)]);
			//doc = Jsoup.connect("http://localhost/topten/NETWORKUP").get();
		else if(currentMeasurementType.equals("Network Down"))
			jsonObject = new JSONObject(JSONmock.down[generator.nextInt(3)]);
			//doc = Jsoup.connect("http://localhost/topten/NETWORKDOWN").get();
		
		jsonArray = jsonObject.getJSONArray("measurements");
	    
	    jsonObjectList = new ArrayList<JSONObject>();
	    for (int i = 0; i < jsonArray.length(); ++i) {
	    	jsonObjectList.add(jsonArray.getJSONObject(i));
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
		      
			String hostName = String.format("%-20s", singleMeasurement.getString("hostName"));
			String hostIp = String.format("%-20s", singleMeasurement.getString("hostIp"));
			String measurement = String.format("%4s", ""+singleMeasurement.getInt("measurementValue")+"%");
			
			outputData += frontSpacer + hostName + hostIp + measurement + "\n";
	    }
	}
	
	public String getOutputData() {
	    return outputData;
	}
}