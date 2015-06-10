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
import monitor.console.view.NewAccount.StatusInfo;
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

    private StatusInfo resp = null;

    public HTTPRequest(String login, byte[] password, FindUrl url) throws UnsupportedEncodingException, IOException {

        HttpClient client = new DefaultHttpClient();
        System.out.println(url.getHostName() + ":" + url.getPortNumber() + "/" + url.getRestServiceName());
        HttpPost post = new HttpPost(url.getHostName() + ":" + url.getPortNumber() + "/" + url.getRestServiceName());
        StringEntity input = new StringEntity("{\'login\':" + "\'" + login + "\',\'password\':\'" + Arrays.toString(password) + "\'}");
        input.setContentType("application/json");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String tmp = "";
        while (( tmp = rd.readLine()) != null) {
            resp = StatusInfo.valueOf(tmp);
            System.out.println(resp);
        }

    }

    public StatusInfo getResp() {
        return resp;
    }

}
