package monitorconsole; 
import java.util.*;
import org.json.*;

public class JSONComparator implements Comparator<JSONObject>
{
	private String sortType;
	private String sortKey;
	
	public JSONComparator(String sortType, String sortKey) {
		this.sortType = sortType;
		this.sortKey = sortKey;
	}
	
    public int compare(JSONObject a, JSONObject b) {
    	
    	int intA, intB, result = 0;
    	String valA, valB;
        
    	if(sortKey.equals("measurementValue"))
    	{
    		intA = a.getInt(sortKey);
    		intB = b.getInt(sortKey);
    		
    	    if(intA > intB)
    	    	result = 1;
    		if(intA < intB)
    			result = -1;
    		return sortType.equals("descending") ? -result : result;
    	}
    	else
    	{
            String s1 = a.getString(sortKey);
            String s2 = b.getString(sortKey);

            int thisMarker = 0;
            int thatMarker = 0;
            int s1Length = s1.length();
            int s2Length = s2.length();

            while (thisMarker < s1Length && thatMarker < s2Length)
            {
                String thisChunk = getChunk(s1, s1Length, thisMarker);
                thisMarker += thisChunk.length();

                String thatChunk = getChunk(s2, s2Length, thatMarker);
                thatMarker += thatChunk.length();

                result = 0;
                if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0)))
                {
                    int thisChunkLength = thisChunk.length();
                    result = thisChunkLength - thatChunk.length();
                    
                    if (result == 0)
                    {
                        for (int i = 0; i < thisChunkLength; i++)
                        {
                            result = thisChunk.charAt(i) - thatChunk.charAt(i);
                            if (result != 0)
                                return sortType.equals("descending") ? -result : result;
                        }
                    }
                } 
                else
                    result = thisChunk.compareTo(thatChunk);

                if (result != 0)
                    return sortType.equals("descending") ? -result : result;
            }

            return sortType.equals("descending") ? -(s1Length - s2Length) : (s1Length - s2Length);
    	}
    }
    
    private final boolean isDigit(char ch) {
        return ch >= 48 && ch <= 57;
    }

    private final String getChunk(String s, int slength, int marker)
    {
        StringBuilder chunk = new StringBuilder();
        char c = s.charAt(marker);
        chunk.append(c);
        marker++;
        
        if (isDigit(c))
        {
            while (marker < slength)
            {
                c = s.charAt(marker);
                if (!isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        }
        else
        {
            while (marker < slength)
            {
                c = s.charAt(marker);
                if (isDigit(c))
                    break;
                chunk.append(c);
                marker++;
            }
        }
        return chunk.toString();
    }
}