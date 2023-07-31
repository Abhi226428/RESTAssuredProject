package day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
    
	@Test
	void test_getUser(ITestContext context)
	{
		
		int id = (Integer) context.getAttribute("user_id");
		
		String bearerToken = "24fc3b130e1ea0c0f67e1e8b6ba745dc6829a7aca54070834cdde79274df3f7e";
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id",id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
}
