/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.console.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author akis
 */

public class HTTPRequest {

    private boolean userExist = false;
    private String resp = null;
    public HTTPRequest(String login, byte[] password) throws UnsupportedEncodingException, IOException {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://localhost:18080/monitor-back/rest/");
        StringEntity input = new StringEntity("{\'login\':"+"\'"+login+"\',\'password\':\'"+Arrays.toString(password)+"\'}");
        input.setContentType("application/json");
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        
        while ((resp = rd.readLine()) != null) {
            System.out.println(resp);
        }
        if(resp != null){
            userExist = true;
        }
    }
    public boolean getUserExist(){
        return userExist;
    }
    public String getResp(){
        return resp;
    }
    
}
