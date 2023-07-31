package day2;


import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
public class DiffWayToCreatePostRequestBody {

	// Post Request body org.json library
//	@Test(priority=1)
	void TestPostusingjsonLibrary()
	{
		
		JSONObject data = new JSONObject();
		data.put("name", "Scott");
		data.put("Location", "France");
		data.put("Phone", "24689756");
		
		String [] coursearr = {"C#","C++"};
		data.put("courses", coursearr);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("http://localhost:3000/students")
		
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("Location",equalTo("France"))
		.body("Phone",equalTo("24689756"))
		.body("courses[0]",equalTo("C#"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	
	
	//@Test(priority=2)
	//void TestDelete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/14")
		
		.then()
		.statusCode(200);
	}
		
	
	//@Test(priority=1)
	void TestPostusingPOJO()
	{
		
		Pojo_PostRequest data = new Pojo_PostRequest();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("24689756");
		
		String [] coursearr = {"C#","C++"};
		data.setCourses(coursearr);
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.post("http://localhost:3000/students")
		
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("Location",equalTo("France"))
		.body("Phone",equalTo("24689756"))
		.body("courses[0]",equalTo("C#"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	
	
	//@Test(priority=2)
	//void TestDelete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/15")
		
		.then()
		.statusCode(200);
	}
	
	
	// Post request body Using External json File
	@Test(priority=1)
	void TestPostusingExternaljsonFile() throws FileNotFoundException
	{
		
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		
		.when()
		.post("http://localhost:3000/students")
		
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("Location",equalTo("France"))
		.body("Phone",equalTo("123456789"))
		.body("courses[0]",equalTo("C#"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	
	
	@Test(priority=2)
	void TestDelete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/15")
		
		.then()
		.statusCode(200);
	}
	
	
}
