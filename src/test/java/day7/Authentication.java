package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {

	// @Test(priority=1)
	 void testBasicAuthentication()
	 {
		 
		 given()
		 .auth().basic("postman", "password")
		 
		 .when()
         .get("https://postman-echo.com/basic-auth")
         
         .then()
         .statusCode(200)
         .body("authenticated",equalTo(true))
         .log().all();
	 }
	 
	// @Test(priority=2)
	 void testDigestAuthentication()
	 {
		 
		 given()
		 .auth().basic("postman", "password")
		 
		 .when()
         .get("https://postman-echo.com/basic-auth")
         
         .then()
         .statusCode(200)
         .body("authenticated",equalTo(true))
         .log().all();
	 }
	 
	// @Test(priority=3)
	 void testPreemptiveAuthentication()
	 {
		 
		 given()
		 .auth().preemptive().basic("postman", "password")
		 
		 .when()
         .get("https://postman-echo.com/basic-auth")
         
         .then()
         .statusCode(200)
         .body("authenticated",equalTo(true))
         .log().all();
	 }
	 
	 
	// @Test(priority=4)
	 void testBearertokenAuthentication()
	 {
		 
		 String Bearertoken = "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"; 
		 given()
		 .headers("Authorization","Bearer "+Bearertoken)
		 
		 .when()
		 .get("https://api.github.com/user/repos")
		 
		 .then()
		 .statusCode(200)
		 .log().all();
	 }
	 
	 
	// @Test(priority=5)
	 void testOAuth2Authentication()
	 {
		  
		 given()
		 .auth().oauth2("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")
		 
		 .when()
		 .get("https://api.github.com/user/repos")
		 
		 .then()
		 .statusCode(200)
		 .log().all();
		 
	 }
	 
	 
	 @Test(priority=6)
	 void testAPIKeyAuthentication()
	 {  
		 //Method1
	/*	 
		 given()
		 .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		 
		 .when()
		 .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		 
		 .then()
		 .statusCode(200)
		 .log().all();
		 
		*/ 
		 
		 //Method2
		 given()
		 .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		 .pathParam("mypath", "data/2.5/forecast/daily")
		 .queryParam("q", "Delhi")
		 .queryParam("units", "metric")
		 .queryParam("cnt", "7")
		 
		 .when()
		 .get("https://api.openweathermap.org/{mypath}")
		 
		 .then()
		 .statusCode(200)
		 .log().all();
		 
		 
	 }
}
