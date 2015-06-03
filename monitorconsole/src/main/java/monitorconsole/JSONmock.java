package monitorconsole;

public class JSONmock {

	final static String[] cpu = {
	"{\"measurementType\":\"CPU\",\"measurements\":[{\"hostName\":\"zeus1\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":21},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":11},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":41},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":51},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":22},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":71},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":77},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":79},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":90},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":9}]}",
	"{\"measurementType\":\"CPU\",\"measurements\":[{\"hostName\":\"zeus1\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":1},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":2},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":3},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":4},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":4},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":3},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":5},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":17},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":7},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":4}]}",
	"{\"measurementType\":\"CPU\",\"measurements\":[{\"hostName\":\"zeus1\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":100},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":93},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":12},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":8},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":4},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":3},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":6},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":88},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":70},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":97}]}"
	};
	
	final static String[] mem = {
		"{\"measurementType\":\"MEMORY\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":15},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":15},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":15},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":15},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":15},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":15},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":15},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":15},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":15},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":15}]}",
		"{\"measurementType\":\"MEMORY\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":16},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":16},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":16},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":16},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":16},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":16},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":16},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":16},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":16},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":16}]}",
		"{\"measurementType\":\"MEMORY\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":17},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":17},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":17},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":17},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":17},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":17},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":17},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":17},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":17},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":17}]}"
	};
	
	final static String[] up = {
		"{\"measurementType\":\"NETWORKUP\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":55},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":55},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":55},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":55},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":55},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":55},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":55},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":55},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":55},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":55}]}",
		"{\"measurementType\":\"NETWORKUP\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":56},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":56},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":56},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":56},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":56},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":56},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":56},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":56},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":56},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":56}]}",
		"{\"measurementType\":\"NETWORKUP\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":57},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":57},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":57},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":57},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":57},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":57},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":57},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":57},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":57},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":57}]}"
	};
	
	final static String[] down = {
		"{\"measurementType\":\"NETWORKDOWN\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":75},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":75},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":75},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":75},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":75},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":75},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":75},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":75},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":75},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":75}]}",
		"{\"measurementType\":\"NETWORKDOWN\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":76},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":76},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":76},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":76},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":76},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":76},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":76},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":76},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":76},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":76}]}",
		"{\"measurementType\":\"NETWORKDOWN\",\"measurements\":[{\"hostName\":\"zeus\",\"hostIp\":\"127.0.0.1\",\"measurementValue\":77},{\"hostName\":\"zeus2\",\"hostIp\":\"127.0.0.2\",\"measurementValue\":77},{\"hostName\":\"zeus3\",\"hostIp\":\"127.0.0.3\",\"measurementValue\":77},{\"hostName\":\"zeus4\",\"hostIp\":\"127.0.0.4\",\"measurementValue\":77},{\"hostName\":\"zeus5\",\"hostIp\":\"127.0.0.5\",\"measurementValue\":77},{\"hostName\":\"zeus6\",\"hostIp\":\"127.0.0.6\",\"measurementValue\":77},{\"hostName\":\"zeus7\",\"hostIp\":\"127.0.0.7\",\"measurementValue\":77},{\"hostName\":\"zeus8\",\"hostIp\":\"127.0.0.8\",\"measurementValue\":77},{\"hostName\":\"zeus9\",\"hostIp\":\"127.0.0.9\",\"measurementValue\":77},{\"hostName\":\"zeus10\",\"hostIp\":\"127.0.0.10\",\"measurementValue\":77}]}"
	};
}

/*
example measurement string

"{
    \"measurementType\": \"CPU\",
    \"measurements\": [
        {
            \"hostName\": \"zeus\",
            \"hostIp\": \"127.0.0.1\",
            \"measurementValue\": 21
        },
        {
            \"hostName\": \"zeus2\",
            \"hostIp\": \"127.0.0.2\",
            \"measurementValue\": 11
        },
        {
            \"hostName\": \"zeus3\",
            \"hostIp\": \"127.0.0.3\",
            \"measurementValue\": 41
        },
        {
            \"hostName\": \"zeus4\",
            \"hostIp\": \"127.0.0.4\",
            \"measurementValue\": 51
        },
        {
            \"hostName\": \"zeus5\",
            \"hostIp\": \"127.0.0.5\",
            \"measurementValue\": 22
        },
        {
            \"hostName\": \"zeus6\",
            \"hostIp\": \"127.0.0.6\",
            \"measurementValue\": 71
        },
        {
            \"hostName\": \"zeus7\",
            \"hostIp\": \"127.0.0.7\",
            \"measurementValue\": 77
        },
        {
            \"hostName\": \"zeus8\",
            \"hostIp\": \"127.0.0.8\",
            \"measurementValue\": 79
        },
        {
            \"hostName\": \"zeus9\",
            \"hostIp\": \"127.0.0.9\",
            \"measurementValue\": 90
        },
        {
            \"hostName\": \"zeus10\",
            \"hostIp\": \"127.0.0.10\",
            \"measurementValue\": 9
        }
    ]
}"
 
*/
