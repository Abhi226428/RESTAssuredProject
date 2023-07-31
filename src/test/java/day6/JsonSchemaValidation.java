package day6;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation {
    
	
	@Test
	void jsonSchemavalidation()
	{
		
		given()
		
		.when()
		.get("http://localhost:3000/store")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StorejsonSchema.json"));
	}
	
}
