package com.day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingxmlResponse {
	// @Test
	void testXmlResponse() {
		// Approach 1
		/*
		 * given()
		 * 
		 * .when() .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		 * 
		 * 
		 * .then() .statusCode(200) .header("Content-Type",
		 * "application/xml; charset=utf-8") .header("Server", "Microsoft-IIS/10.0")
		 * .body("TravelerinformationResponse.page", equalTo("1"))
		 * .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",
		 * equalTo("Developer"));
		 */
		// Approach 2

		Response res = given()

				.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");

		String page_no = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(page_no, "1");

		String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(name, "Developer");

	}
     @Test
	void testxmlResponseBody() {
		Response res = given()

				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		  XmlPath xmlobj= new XmlPath(res.asString());
		  //verify total number of traverls
		  List <String> travellers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		 // System.out.println(travellers.size());
		  Assert.assertEquals(travellers.size(),10);
		  
		  //Verifying travellers present in response
		  
		  List <String> travellers_name=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		  boolean st=false;
		    for(String traveller:travellers_name)
		    {
		    	if(traveller.equals("vano"));
		    	{
		    	st=true;
		    	break;
		    	}
		    	
		    }
		    Assert.assertEquals(st,true);
		
		
	}

}








