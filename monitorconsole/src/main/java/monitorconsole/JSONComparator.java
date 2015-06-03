package monitorconsole; 
import java.util.*;
import org.json.*;

public class JSONComparator implements Comparator<JSONObject>
{
	private String sortType;
	
	public JSONComparator(String sortType) {
		this.sortType = sortType;
	}
	
    public int compare(JSONObject a, JSONObject b) {
        int valA = a.getInt("measurementValue");
        int valB = b.getInt("measurementValue");

        int result = 0;
        
        if(valA > valB)
           result = -1;
        if(valA < valB)
           result = 1;
        
        return sortType.equals("descending") ? result : -result;
    }
}