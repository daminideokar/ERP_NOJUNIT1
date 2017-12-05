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
 * Description: Test  class for AccountType SetUp Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 12,2017
 * Modified on: 
 * Version:
 */
public class ControllerAccountTypeSetUpTest {
	
	@Test
	public void testCreate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("accountType", "abc");
		json.put("rowIdIndexing", "1");
		
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/accountTypeSetUp/create").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	
	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("accountType", "abc");
		json.put("accountTypeCode", "1");
	
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/accountTypeSetUp/update").andReturn();
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
				.put("http://localhost:8086/accountTypeSetUp/getall").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/accountTypeSetUp/getall").andReturn();
		assert response.statusCode() == 200;
	}

}
