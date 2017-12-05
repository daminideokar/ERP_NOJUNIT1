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
 * Description: Test  class for Unit Of Measure Schedule SetUp Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 14,2017
 * Modified on: 
 * Version:
 */
public class ControllerUnitOfMeasureScheduleSetUpTest {
	
	/**
	 * Create company
	 * @throws Exception
	 */
	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("baseUnitOfMeasure", "priyaaa");
		json.put("createDate", "1234567890123");
		json.put("decimalPlacesQty", "2");
		json.put("unitOfMeasureDescription", "descrip");
		json.put("unitOfMeasureDescriptionArabic", "descriparabic");
		json.put("unitOfMeasureId", "id13");
		json.put("dexRowId", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				
				.body(jsonString).when()
				.post("http://localhost:8086/unitOfMeasureScheduleSetUp/create").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("baseUnitOfMeasure", "abc");
		json.put("createDate", "1234567890123");
		json.put("unitOfMeasureIndex", "1");
		json.put("decimalPlacesQty", "2");
		json.put("unitOfMeasureDescription", "descrip");
		json.put("unitOfMeasureDescriptionArabic", "descriparabic");
		json.put("dexRowId", "1");
	
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/unitOfMeasureScheduleSetUp/update").andReturn();
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
				.put("http://localhost:8086/unitOfMeasureScheduleSetUp/getall").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/unitOfMeasureScheduleSetUp/getall").andReturn();
		assert response.statusCode() == 200;
	}

	@Test
	public void testGetByUnitOfMeasureId() throws Exception{
		JSONObject json = new JSONObject();
		json.put("unitOfMeasureId", "id1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/unitOfMeasureScheduleSetUp/getByUnitOfMeasureId").andReturn();
		assert response.statusCode() == 200;
	}

	
}
