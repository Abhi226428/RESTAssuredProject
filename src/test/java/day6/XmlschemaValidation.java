package day6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class XmlschemaValidation {
   
	@Test
	void xmlschemavalidation()
	{
		
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesDtdInClasspath("traveler.xsd"));
		
			
	}
		
}
