
import org.junit.Test;

import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;

import static com.jayway.restassured.RestAssured.given;

public class ControllerSiteSetupTest {
	
	@Test
	public void testCreate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("locationId", "unidirection");
		json.put("locationDescription", "description is");
		json.put("locationDescriptionArabic", "arabic");
		json.put("locationAddress", "Kothrud");
		json.put("city", "Pune");
		json.put("country", "India");
		json.put("phoneNumber", "1234567891");
		json.put("rowIdIndexing", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/siteSetup/create").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	

	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("locationDescription", "description is");
		json.put("locationDescriptionArabic", "arabic");
		json.put("locationAddress", "Kothrud");
		json.put("city", "Pune");
		json.put("country", "India");
		json.put("phoneNumber", "1234567891");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/siteSetup/update").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	@Test
	public void testGetAll() throws Exception {
		Response response = given().header("Content-Type", "application/json")
				.get("http://localhost:8086/siteSetup/getall").andReturn();
		assert response.statusCode() == 200;
	}


	@Test
	public void testGetByLocationCode() throws Exception{
		JSONObject json = new JSONObject();
		json.put("locationId", "abc");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/siteSetup/getBylocationcode").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testGetByTaxScheduleIdForPurchase() throws Exception{
		JSONObject json = new JSONObject();
		json.put("taxSchdId", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/siteSetup/getByTaxScheduleIdForPurchase").andReturn();
		assert response.statusCode() == 200;
	}
	
	
	@Test
	public void testGetByTaxScheduleIdForSale() throws Exception{
		JSONObject json = new JSONObject();
		json.put("taxSchdId", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/siteSetup/getByTaxScheduleIdForSale").andReturn();
		assert response.statusCode() == 200;
	}
}
