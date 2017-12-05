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
 * Description: Test  class for the controller_item_lot_category_setup_test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 07, 2017 
 * Modified on: 
 * Version:
 */
public class ControllerItemLotCategorySetupTest {


	@Test
	public void testCreate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("lotAttribute1", "e");
		json.put("lotAttribute2", "d");
		json.put("lotAttribute3", "c");
		json.put("lotAttribute4", "b");
		json.put("lotAttribute5", "a");
		json.put("lotItemCategoryId", "abcdefg");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/itemlot/create").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("lotAttribute4", "b");
		json.put("lotAttribute5", "a");
		json.put("lotItemCategoryId", "sdb");
		json.put("lotItemCategoryIndex",1);
	
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/itemlot/update").andReturn();
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
				.put("http://localhost:8086/itemlot/getall").andReturn();
		assert response.statusCode() == 200;
	}
	
	

	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/itemlot/getall").andReturn();
		assert response.statusCode() == 200;
	}

}


	

