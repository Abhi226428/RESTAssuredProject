package day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
    
	
	@Test
	void test_UpdateUser(ITestContext context)
	{
		
		 
		 Faker faker = new Faker();
		 
		 JSONObject data = new JSONObject();
		 
		data.put("name", faker.name().fullName());
		data.put("gender", "Female");
		data.put("Email", faker.internet().emailAddress());
		data.put("status", "active");
		
	String bearerToken = "24fc3b130e1ea0c0f67e1e8b6ba745dc6829a7aca54070834cdde79274df3f7e";
	
	int id = (Integer) context.getAttribute("user_id");
	
	  given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.pathParam("id", id)
		.body(data.toString())
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
	
	    .then()
	    .statusCode(200)
	    .log().all();
	
	}
}
