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

import net.minidev.json.JSONObject;
import com.jayway.restassured.response.Response;

/**
 * Description: Test  class for Stock Calender SetUp  Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: 
 * Modified on: 
 * Version:
 */
public class ControlllerStockCalenderSetupTest {
	
	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("numberOfShifts",1);
		json.put("hoursOfShifts",9);
		json.put("startTimeOfShift","10:00 AM");
		json.put("downWorkDay",4);

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/stockCalenderSetup/save").andReturn();
		assert response.statusCode() == 200;

	}

}
