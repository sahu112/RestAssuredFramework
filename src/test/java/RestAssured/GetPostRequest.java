package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetPostRequest {
	
	@Test
	void getWetherDetails() {
		//Specify Base URI
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		
		//Responce Object
		Response responce=httprequest.request(Method.GET,"?page=3");
		
	//	System.out.println(responce);
		
		String responceBody=responce.getBody().asString();
		
		System.out.println(responceBody);
		
		//Status code validation
		int statusCode=responce.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		//status line
		String statusLine=responce.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		//
		
		
		
		
	}

}
