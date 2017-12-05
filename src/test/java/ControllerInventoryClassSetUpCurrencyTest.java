
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
import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;

/**
 * Description: Test class for the ControllerInventoryClassSetUpCurrencyTest.
 * Name of Project: BTI
 * @author Goodtech 
 * Created on: Nov 16, 2017
 * Modified on:
 * Version:
 */
public class ControllerInventoryClassSetUpCurrencyTest {
	
	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("currencyId", "cd");
		json.put("itemClassId", "id");
		json.put("currencyDecimal", 3);

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/inventoryclassetup/create").andReturn();
		assert response.statusCode() == 200;

	}

	@Test
	public void testUpdate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("currencyDecimal", 12);
		json.put("inventoryClassSetUpCurrencyIndex", 1);

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/classSetUpCurrencySetUp/update").andReturn();
		assert response.statusCode() == 200;

	}
}
