package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HeadersDemo {

	   @Test
	   void testHeaders()
	   {
		   
		 Response res =  given()
		   
		   .when()
		   .get("http://www.google.com/");
		 
		 	  // String Headervalue = res.getHeader("Content-Type");
		      // System.out.println("the value of Header"+ Headervalue );
		   
		    Headers myheaders  = res.getHeaders();
		    
		    for(Header hd : myheaders)
		    {
		    	System.out.println(hd.getName()+"   "+hd.getValue());
		    }
		 
	   }
}
