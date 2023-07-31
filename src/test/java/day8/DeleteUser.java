package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
    
	@Test
	void test_DeleteUser(ITestContext context)
	{
		
		String bearerToken = "24fc3b130e1ea0c0f67e1e8b6ba745dc6829a7aca54070834cdde79274df3f7e";
		
		int id = (Integer) context.getAttribute("user_id");
		
		 given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
			
			.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
			
			.then()
			.statusCode(204)
			.log().all();
	}
}
