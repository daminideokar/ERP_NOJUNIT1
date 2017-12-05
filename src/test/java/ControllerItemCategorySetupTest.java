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
 * Description: Test  class for Item Category SetUp Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 9, 2017
 * Modified on: 
 * Version:
 */
public class ControllerItemCategorySetupTest {

	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("itemCategory", "style");
		json.put("itemCategoryValueDescriptionArabic", "descriptionarabic");
		json.put("itemCategoryValueDescription", "description");
		json.put("itemCategoryValue", "value");

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/itemCategorySetup/save").andReturn();
		assert response.statusCode() == 200;

	}
	@Test
	public void testUpdate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("itemCategoryIndex", 1);
		json.put("itemCategory", "style");
		json.put("itemCategoryValueDescriptionArabic", "descriptionarabic");
		json.put("itemCategoryValueDescription", "description");
		json.put("itemCategoryValue", "value");

		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/itemCategorySetup/save").andReturn();
		assert response.statusCode() == 200;

	}
	
	@Test
	public void testGet() throws Exception {
		JSONObject json = new JSONObject();
		json.put("itemCategory","style");
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/itemCategorySetup/getbycategory").andReturn();
		assert response.statusCode() == 200;

	}
	
	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.put("http://localhost:8086/itemCategorySetup/getbycategory").andReturn();
		assert response.statusCode() == 200;
	}
}
