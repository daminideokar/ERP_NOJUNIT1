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
 * Description: Test  class for Unit Of Measure Schedule SetUp Details Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 15,2017
 * Modified on: 
 * Version:
 */
public class ControllerUnitOfMeasureScheduleSetUpDetailsTest {
	/**
	 * Create company
	 * @throws Exception
	 */
	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("baseUnitOfMeasure", "priyaaa1");
		json.put("equivalentUnitOfMeasure", "equivalant");
		json.put("rowIdIndexing", "1");
		json.put("equivalentUnitOfMeasureQty", "2");
		json.put("moreDescriptionForUOfMInDetailLevel", "descrip");
		json.put("qtyInBaseUnitOfMeasure", "descriparabic");
		json.put("unitOfMeasureSequence", "id3");
		json.put("unitOfMeasureId", "id12");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				
				.body(jsonString).when()
				.post("http://localhost:8086/unitOfMeasureScheduleSetUpDetails/create").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("baseUnitOfMeasure", "priyaaa");
		json.put("equivalentUnitOfMeasure", "equivalant");
	
		json.put("equivalentUnitOfMeasureQty", "2");
		json.put("moreDescriptionForUOfMInDetailLevel", "descrip");
		json.put("qtyInBaseUnitOfMeasure", "descriparabic");
		json.put("unitOfMeasureSequence", "id3");
		json.put("index", "1");
		
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/unitOfMeasureScheduleSetUpDetails/update").andReturn();
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
				.put("http://localhost:8086/unitOfMeasureScheduleSetUpDetails/getall").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/unitOfMeasureScheduleSetUpDetails/getall").andReturn();
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
