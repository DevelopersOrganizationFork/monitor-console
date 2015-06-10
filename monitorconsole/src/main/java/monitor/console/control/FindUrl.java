/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.console.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author akis
 */
public class FindUrl {

    Properties prop = new Properties();
    private String propFieleName ="config.properties";
    private String hostName = null;
    private String portNumber = null;
    private String restServiceName = null;

    
    public FindUrl(String host, String port, String service) throws IOException {

        InputStream inputStream = new FileInputStream(propFieleName);

        if (inputStream != null) {
            prop.load(inputStream);
            hostName = prop.getProperty(host);
            portNumber = prop.getProperty(port);
            restServiceName = prop.getProperty(service);
        } else {
            throw new FileNotFoundException("Property file " + propFieleName + " not found");
        }

    }

    public String getHostName() {
        return hostName;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public String getRestServiceName() {
        return restServiceName;
    }

}
