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
 * Description: Test  class for Item Class SetUp Test .
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 11, 2017
 * Modified on: 
 * Version:
 */
public class ControllerItemClassSetupTest {
	
	@Test
	public void testCreate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("itemClassId", "SK");
		json.put("itemClassDescription","desc");
		json.put("itemClassDescriptionArabic","arabic");
		json.put("itemGenericDescription","generic");
		json.put("itemGenericDescriptionArabic","genericarabic");
		json.put("itemType", 10);
		json.put("track", 100);
		json.put("valuationMethod",12);
		json.put("warningFeature",1);
		json.put("allowBackOrders",0);
		json.put("revalueInventoryForCostVariance",0);
		json.put("tolerancePercentage",80.12);
		json.put("quantityDecimals",1);
		json.put("currencyDecimals",2);
		json.put("priceMethod",3);
		json.put("taxScheduleIdForSales","SDF");
		json.put("taxScheduleIdForPurchase","FDS");
		json.put("warningNumberOfDays",15);
		json.put("userCategoryName1","style");
		json.put("userCategoryName2","style");
		json.put("userCategoryName3","style");
		json.put("userCategoryName4","style");
		json.put("userCategoryName5","style");
		json.put("userCategoryName6","style");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/itemClassSetup/save").andReturn();
		assert response.statusCode() == 200;

	}
	
	@Test
	public void testUpdate() throws Exception {
		JSONObject json = new JSONObject();
		json.put("itemClassIndex", 1);
		json.put("itemClassId", "SK");
		json.put("itemClassDescription","description");
		json.put("itemClassDescriptionArabic","arabicdescription");
		json.put("itemGenericDescription","generic");
		json.put("itemGenericDescriptionArabic","genericarabic");
		json.put("itemType", 10);
		json.put("track", 100);
		json.put("valuationMethod",12);
		json.put("warningFeature",1);
		json.put("allowBackOrders",0);
		json.put("revalueInventoryForCostVariance",0);
		json.put("tolerancePercentage",80.12);
		json.put("quantityDecimals",1);
		json.put("currencyDecimals",2);
		json.put("priceMethod",3);
		json.put("taxScheduleIdForSales","SDF");
		json.put("taxScheduleIdForPurchase","FDS");
		json.put("warningNumberOfDays",15);
		json.put("userCategoryName1","style");
		json.put("userCategoryName2","style");
		json.put("userCategoryName3","style");
		json.put("userCategoryName4","style");
		json.put("userCategoryName5","style");
		json.put("userCategoryName6","style");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.post("http://localhost:8086/itemClassSetup/save").andReturn();
		assert response.statusCode() == 200;

	}
	
	@Test
	public void testGet() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/itemClassSetup/get").andReturn();
		assert response.statusCode() == 200;
	}
	
	@Test
	public void testGetAllWithOutPagination() throws Exception {
		JSONObject json = new JSONObject();
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json").body(jsonString).when()
				.put("http://localhost:8086/itemClassSetup/get").andReturn();
		assert response.statusCode() == 200;
	}
	

}
