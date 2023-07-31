package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class LoggingInDemo {

	   @Test
	   void testLog()
	   {
		   
		   given()
		   
		   .when()
		   .get("https://reqres.in/api/users?page=2")
		   
		   .then()
		   .log().all();      //.....print Complete response  
		  // .log().headers();    //.....print Header part only
		  // .log().body();       //......print response body
		  // .log().cookies();     //......print cookies
	   }
}
