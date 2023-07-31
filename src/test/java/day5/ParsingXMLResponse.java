package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXMLResponse {
    
	    @Test
	    void textXMLresponse()
	    {
	    	
	 /*   given()
	    	
	    .when()
	    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
	    	
	    .then()
	    .statusCode(200)
	    .header("Content-Type", "application/xml; charset=utf-8")
	    .body("TravelerinformationResponse.page", equalTo("1"))
	    .body("TravelerinformationResponse.travelers.Travelerinformation[1].name", equalTo("AS"));
	    
	    	*/
	    Response res = given()
	    	
		  .when()
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		    
		    
		  Assert.assertEquals(res.getStatusCode(), 200);
		  Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		  String pageno = res.xmlPath().get("TravelerinformationResponse.page").toString();
		  Assert.assertEquals(pageno, "1");
		  String name =  res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
		  Assert.assertEquals(name, "AS");
	    }   	
	    	
		   @Test
		   void textXMLresponseBody()
		    {
		    	
		   Response res = given()
		    	
		    .when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		   
		   XmlPath xmlobj = new XmlPath(res.asString());
		  List<String> travellers_names = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		  
		  boolean status = false;
		  for(String travellername : travellers_names)
		  {
			//  System.out.println(travellername);  Print All Name
			  
			  if(travellername.equals("AS"))
			  {
				  status = true;
				  break;
			  }
		  }
		  Assert.assertEquals(status, true);
		   
	    }
}
