package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class HttpRequest {
	
	int id;

	@Test(priority=1)
	void ListUser()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
		
		}
	
	@Test(priority=2)
	void createUser()
	{
		
		HashMap data = new HashMap();
		data.put("name","Abhishek");
		data.put("job","Trainee");
		
		id=given()
		.contentType("Application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		//.then()
		//.statusCode(201)
		//.log().all();
	}
		@Test(priority=3,dependsOnMethods={"createUser"})
		void UpdateUser()
		{
			
			HashMap data = new HashMap();
			data.put("name","Mohan");
			data.put("job","Teacher");
			
			given()
			.contentType("Application/json")
			.body(data)
			
			.when()
			.put("https://reqres.in/api/users/2"+id)
			
			
			.then()
			.statusCode(200)
			.log().all();
	}
		
		@Test(priority=4)
		void deleteUser()
		{
			given()
			
			.when()
			.delete("https://reqres.in/api/users/2"+id)
			
			.then()
			.statusCode(204)
			.log().all();
		}
}
