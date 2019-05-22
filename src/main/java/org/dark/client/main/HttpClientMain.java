 package org.dark.client.main;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientMain {

	public static void main(String[] args) {
		String url = "http://localhost:8080/normalHello";
		HttpGet httpGet = null;
		CloseableHttpClient httpClient = null;
		HttpResponse response = null;
		
		try {
			//以下是模擬正常情況下能看到的結果。這部分沒有什麼特殊需要注意的重點內容。
			httpGet = new HttpGet(url);
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			System.out.println(response.getEntity());
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
