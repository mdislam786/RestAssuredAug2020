package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_Or_Create_A_Product {

	SoftAssert sofAssert = new SoftAssert();

	@Test
	public void create_A_Product() {

//		https://techfios.com/api-prod/api/product/create.php
		HashMap payload = new HashMap();
		payload.put("name", "HP Laptop Elite Pro");
		payload.put("description", "Super fast laptop");
		payload.put("price", "1199");
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
					.body(payload)
				.when()
					.post("/create.php")
				.then()
					.extract().response();

		String responseBody = response.getBody().asString();
		System.out.println("responseBody:  " + responseBody);
		
//		Parsing responseBody to Json:
		JsonPath js = new JsonPath(responseBody);
//		
		String message = js.getString("message");
		
//		sofAssert.assertEquals(message, "Product was created","Not matching the assertions!!!");
		
//		String productname = js.getString("name");
//		String productDescription = js.getString("description");
		
		

//		Assert.assertEquals(productname, "Hp Laptop Elite Pro");
//		Assert.assertEquals(productDescription, "Super fast laptop");
		
		
//		System.out.println(productId);
		
//		sofAssert.assertAll();
		
		
		
		
		
		
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
