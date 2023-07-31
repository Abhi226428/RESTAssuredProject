package day5;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
	
	@Test(priority=1)
	void singlefileUpload()
	{    
		
		File myfile = new File("G:\\PAVAN SIR\\RestAssured Api\\class 20\\Day15.txt");

		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		
		
		.when()
		.post("http://localhost:8080/uploadFile/")
		
		.then()
		.statusCode(200)
		.body("fileName",equalTo("Day15.txt"))
		.log().all();

	}
	
	
//	@Test
	void MultiplefileUpload()
	{    
		
		File myfile1 = new File("G:\\PAVAN SIR\\RestAssured Api\\class 20\\Day15.txt");
		File myfile2 = new File("G:\\PAVAN SIR\\RestAssured Api\\class 19\\Day14.txt");
		given()
		.multiPart("files",myfile1)
		.multiPart("files",myfile2)
		.contentType("multipart/form-data")
		
		
		.when()
		.post("http://localhost:8080/uploadMultipleFiles/")
		
		.then()
		.statusCode(200)
		.body("[0].fileName",equalTo("Day15.txt"))
		.body("[1].fileName",equalTo("Day14.txt"))
		.log().all();
		
		
	}
	
	@Test(priority=2)
	void filedownload()
	{
		given()
		
		.when()
		.get("http://localhost:8080/downloadFile/Day15.txt")
		
		.then()
		.statusCode(200)
		.log().body();
	}
}
