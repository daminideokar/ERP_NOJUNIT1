import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;

/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright © 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */
public class ControllerItemClassAccountTableSetUpTest {
	
	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("itemClassId", "id");

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/itemAccountTableSetUp/create").andReturn();
		assert response.statusCode() == 200;

	}

	@Test
	public void testUpdate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("itemClassId", "id");
		json.put("inventoryClassSetUpCurrencyIndex", 1);
		json.put("modifyByUserId","bsd");

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/itemAccountTableSetUp/update").andReturn();
		assert response.statusCode() == 200;

	}
}
