package com.day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class HeaderDemo {
	
	//@Test
	void testHeader() {
		
		given()
		
		.when()
		     .get("https://www.google.com/")
		
		.then()
		     .header("Content-Type","text/html; charset=ISO-8859-1")
             .header("Content-Encoding","gzip");
	}
	  @Test
     void getHeaders() {
		
	Response res=given()
		
		.when()
		     .get("https://www.google.com/");
	           
	           String header_value = res.getHeader("Content-Type");
	           System.out.println(header_value);
		
		
	}
	

}
