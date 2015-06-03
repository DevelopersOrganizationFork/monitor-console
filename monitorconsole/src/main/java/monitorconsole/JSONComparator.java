package monitorconsole; 
import java.util.*;
import org.json.*;

public class JSONComparator implements Comparator<JSONObject>
{
    public int compare(JSONObject a, JSONObject b)
    {
        int valA = a.getInt("measurementValue");
        int valB = b.getInt("measurementValue");

        if(valA > valB)
            return -1;
        if(valA < valB)
            return 1;
        return 0;    
    }
}