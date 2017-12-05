import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;

public class ControllerSiteBinsSetupTest {
	
	@Test
	public void testCreate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("locationCode", "unidirection");
		json.put("locationBinName", "JERDHA");
		json.put("faxNumber", "9876543210");
		json.put("locationBinSequence", "1234");
		json.put("phoneNumber", "1234567891");
		json.put("rowIdIndexing", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/siteBinsSetup/save").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	

	@Test
	public void testUpdate() throws Exception{
		JSONObject json = new JSONObject();
		json.put("locationCode", "unidirection");
		json.put("locationBinName", "mode");
		json.put("faxNumber", "9876543210");
		json.put("locationBinSequence", "1234");
		json.put("phoneNumber", "9657185038");
		json.put("siteBinInd", "1");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.put("http://localhost:8086/siteBinsSetup/update").andReturn();
		assert response.statusCode() == 200;
		
	}
	
	@Test
	public void testGetAll() throws Exception {
		Response response = given().header("Content-Type", "application/json")
				.get("http://localhost:8086/siteBinsSetup/getall").andReturn();
		assert response.statusCode() == 200;
	}
	
	@Test
	public void testGetByLocationBinName() throws Exception{
		JSONObject json = new JSONObject();
		json.put("locationBinName", "mode");
		
		String jsonString = json.toJSONString();
		Response response = given().header("Content-Type", "application/json")
				.body(jsonString).when()
				.post("http://localhost:8086/siteBinsSetup/get").andReturn();
		assert response.statusCode() == 200;
	}
	


}
