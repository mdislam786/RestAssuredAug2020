package testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_Or_Read_A_Product {

	SoftAssert sofAssert = new SoftAssert();

	@Test
	public void read_A_Product() {
		

//		https://techfios.com/api-prod/api/product/read_one.php?id=1209
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json;")
					.queryParam("id", "1203")
				.when()
					.get("/read_one.php")
				.then()
					.extract().response();

		String responseBody = response.getBody().asString();
		System.out.println("Response Body:  " + responseBody);
		
//		String responseContentType = response.header("Content-Type");
//		System.out.println(responseHeader);
//		sofAssert.assertEquals(responseHeader, "application/jso");
//		sofAssert.assertEquals(responseContentType, "application/json", "Header missmatch");
		
//		Parsing responseBody to Json:
		JsonPath js = new JsonPath(responseBody);
		String token= js.getString("access_token");
		String productId = js.getString("id");
//		System.out.println(productId);
		String productname = js.getString("name");
		String productDescription = js.getString("description");
		
		
		sofAssert.assertEquals(productId, "1204","Product id Missmatch");
//		Assert.assertEquals(productId, "1204");
		sofAssert.assertEquals(productname, "Samsung S20","ProductName Missmatch!!!");
		sofAssert.assertEquals(productDescription, "Pretty amazing phone","productDescription Missmatch!!!");
		
		sofAssert.assertAll();
		
		
//		System.out.println(productId);
		
		
		
		
		
		
//		js.prettyPrint();
//		System.out.println(js);
		
		

//		int statusCode = response.getStatusCode();
//		System.out.println("Status Code: " + statusCode);
//		Assert.assertEquals(statusCode, 200);
//		sofAssert.assertEquals(statusCode, 201, statusCode +"statusCode in not matching with" + "201" ) ;
//		sofAssert.assertEquals(statusCode, 201, "Not matching");

//		String responseBody =	response.getBody().prettyPrint();

//		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("Response Time: " + responseTime);
//		if(responseTime<=1000) {
//			System.out.println("Response time is within the range");
//		}else {
//			System.out.println("Not acceptable!!");
//		}

	}
	
	
	

}
