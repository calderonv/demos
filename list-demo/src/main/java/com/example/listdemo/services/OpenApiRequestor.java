package com.example.listdemo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class OpenApiRequestor {


	public ListResult makeJeapordyRequest(String baseUrl) throws UnsupportedOperationException, IOException {
		System.out.println("Starting...");

		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(baseUrl);

		List<JeopardyCategory> items = new ArrayList<JeopardyCategory>();

		HttpResponse response = client.execute(request);

		String result = getStringFromStream(response.getEntity().getContent());			
		JSONArray jsonArr = new JSONArray(result);
		
		System.out.println(jsonArr);

		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject jsonItem = jsonArr.getJSONObject(i);
			System.out.println(jsonItem);
			
			items.add(new JeopardyCategory(jsonItem.getInt("id"), jsonItem.getString("title")));
		}

		ListResult list = new ListResult();
		Collections.sort(items);
		list.setItems(items);

		return list;
	}
	
	private static String getStringFromStream(InputStream is) {

	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}

}
