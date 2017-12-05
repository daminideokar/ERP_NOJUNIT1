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
 * Description: Test  class for Price Group SetUp Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 7,2017
 * Modified on: 
 * Version:
 */
public class ControllerPriceGroupSetupTest {

	@Test
	public void testCreate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("priceGroupId", "uniq1234ab");
		json.put("priceGroupDescription", "1234567890123");
		json.put("priceGroupDescriptionArabic", "1234567890123");
		json.put("rowIdIndexing", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/priceGroupSetup/create").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("priceGroupId", "sona");
		json.put("priceGroupDescription", "1234567890123");
		json.put("priceGroupDescriptionArabic", "1234567890123");
		json.put("priceGroupIndex", "1");
		
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/priceGroupSetup/update").andReturn();
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
				.put("http://localhost:8086/priceGroupSetup/getall").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/priceGroupSetup/getall").andReturn();
		assert response.statusCode() == 200;
	}

	
	
	
}
