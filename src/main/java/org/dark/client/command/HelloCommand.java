package org.dark.client.command;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloCommand extends HystrixCommand<String> {

	public HelloCommand() {
		//這個super是必須的，其中的內容可以暫不必深究
		super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
	}

	//以線程的形式實現的功能。
	@Override
	protected String run() throws Exception {
		String url = "http://localhost:8080/normalHello";
		HttpGet httpGet = null;
		CloseableHttpClient httpClient = null;
		HttpResponse response = null;
		String returnStr = null;
		
		try {
			//以下是模擬正常情況下能看到的結果。這部分沒有什麼特殊需要注意的重點內容。
			httpGet = new HttpGet(url);
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			returnStr = EntityUtils.toString(response.getEntity());
			System.out.println(response.getEntity());
			System.out.println(returnStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}

}
