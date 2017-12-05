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

/**
 * Description: class for the controller_inventory_control_set_up 
 * Name of Project: BTI 
 * Created on: Nov 09, 2017 
 * Modified on: 
 * @author GoodTech
 * Version:
 */
public class ControllerInventoryControlSetUpTest {

	
	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("dimensionDescription","id");
		json.put("userCategoryName1","RICHARD");
		json.put("userCategoryName2","MONIKA");
		json.put("userCategoryName3","RIYAL");
		json.put("userCategoryName4","PSK");
		json.put("userCategoryName5","UMER");
		json.put("userCategoryName6","BILL");
		json.put("quantityDecimals",1);
		json.put("currencyDecimal", 1);
		

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/inventory/create").andReturn();
		assert response.statusCode() == 200;

	}
	
	@Test
	public void testUpdate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("keySetupId",1);
		json.put( "dimensionDescription","id");
		json.put("modifyByUserID","bsd");
		json.put("userCategoryName1","BILL");
		json.put("userCategoryName2","PSK");
		json.put("userCategoryName3","SDB");
		json.put("userCategoryName4","RIYAL");
		json.put("userCategoryName5","APD");
		json.put("userCategoryName6","DSK");
		json.put("quantityDecimals",2);
		json.put("currencyDecimal", 3);

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.put("http://localhost:8086/inventory/update").andReturn();
		assert response.statusCode() == 200;

	}
	@Test
	public void testGetAllWithPagination() throws Exception {
		JSONObject json = new JSONObject();
		json.put("pageNumber", 0);
		json.put("pageSize", 10);

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/inventory/getall").andReturn();
		assert response.statusCode() == 200;
	}
	
	

	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/inventory/getall").andReturn();
		assert response.statusCode() == 200;
	}
}
