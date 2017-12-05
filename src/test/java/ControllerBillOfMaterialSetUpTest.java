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
 * Description: Test  class for Bill of Material SetUp Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 8,2017
 * Modified on: 
 * Version:
 */
public class ControllerBillOfMaterialSetUpTest {
	@Test
	public void testCreate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("nextDocumentNumber","400");
		json.put("documentDate", "1");
		json.put("userDefinedField1", "prachi");
		json.put("userDefinedField2", "snehal");
		json.put("userDefinedField3", "priyanka1");
		json.put("userDefinedField4", "sonali");
		json.put("allowOverrideonQuantityShortage", "true");
		json.put("allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers", "true");
		json.put("rowIdIndexing", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/billOfMaterial/create").andReturn();
		System.out.println("######"+ response.statusCode() );
		assert response.statusCode() == 200;
		
		
	}
	
	
	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("nextDocumentNumber", "2");
		json.put("modifDt", "1234567890123");
		json.put("id", "1");
		json.put("documentDate", "1");
		json.put("userDefinedField1", "prachi12345");
		json.put("userDefinedField2", "snehal");
		json.put("userDefinedField3", "priyanka");
		json.put("userDefinedField4", "sonali");
		json.put("allowOverrideonQuantityShortage", "true");
		json.put("allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers", "false");
	
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/billOfMaterial/update").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		JSONObject json = new JSONObject();
		json.put("nextDocumentNumber", "2");

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/billOfMaterial/delete").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testGetByNextDocumentNumber() throws Exception{
		JSONObject json = new JSONObject();
		json.put("nextDocumentNumber", "2");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/billOfMaterial/getByNextDocumentNumber").andReturn();
		assert response.statusCode() == 200;
	}

}
