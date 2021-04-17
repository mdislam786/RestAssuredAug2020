package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUT_Or_Update_A_Product {

	SoftAssert sofAssert = new SoftAssert();
	GET_Or_Read_A_Product readAprod = new GET_Or_Read_A_Product();

	@Test
	public void update_A_Product() {

//		https://techfios.com/api-prod/api/product/update.php
		HashMap payload = new HashMap();
		payload.put("id", "1203");
		payload.put("name", "Samsung S21");
		payload.put("description", "Pretty amazing phone");
		payload.put("price", "799");
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");
		Response response = 
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
					.header("Authorization","Bearer Token LKJFKJLK544BLJLKBM4")
					.body(payload)
				.when()
					.put("/update.php")
				.then()
					.extract().response();

		String responseBody = response.getBody().asString();
		System.out.println("Update Response Body:  " + responseBody);
		
//		Parsing responseBody to Json:
		JsonPath js = new JsonPath(responseBody);
//		
		String message = js.getString("message");
		
		sofAssert.assertEquals(message, "Product was updated.","Not matching the assertions!!!");
		
		
//		readAprod.read_A_Product("1203");
		

		sofAssert.assertAll();
		
		
		
		
		
		
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
