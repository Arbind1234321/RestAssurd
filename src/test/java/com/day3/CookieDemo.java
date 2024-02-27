package com.day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookieDemo {
	//@Test(priority = 1)
	void cookie()
	{
	  given()
	
	  .when()
	    .get("https://www.google.com/")
	  
	  
	  .then()
	  .cookie("AEC","Ackid1Swa7DbFOihZZCmrvlYb5IZel7j9YvmFvbBZd33iF_o4FYXhx6fD3o")
	  .log().all();
	  
	}
	
	@Test(priority = 2)
	void getCookiesInfo()
	{
	 Response res=given()
	  
				.when().get("https://www.google.com/");
		// get single cookie info
		// String cookie_vale=res.getCookie("AEC");
		// System.out.println("cookie value"+cookie_vale);

		// get all cookies information

		Map<String, String> cookies_values = res.getCookies();
		// to get only keys
		// System.out.println(cookies_values.keySet());
		for (String k : cookies_values.keySet()) {
			String cookies_value = res.getCookie(k);
			System.out.println(k + "    " + cookies_value);
		}
	
	
	
	  
	  
	  
	  
	}


}
