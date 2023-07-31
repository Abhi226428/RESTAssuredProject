package day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
     
	 @Test
	 void test_createUser(ITestContext context)
	 {
		  
		 Faker faker = new Faker();
		 
		 JSONObject data = new JSONObject();
		 
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("Email", faker.internet().emailAddress());
		data.put("status", "Inactive");
		
	String bearerToken = "24fc3b130e1ea0c0f67e1e8b6ba745dc6829a7aca54070834cdde79274df3f7e";
		
	int id = given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
	
	System.out.println("Generated id is "+id);
	
    context.setAttribute("user_id", id);
		
		
		
		
		 
	 }
}
