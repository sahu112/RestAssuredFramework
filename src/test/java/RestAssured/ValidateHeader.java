package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.internal.http.HttpResponseDecorator.HeadersDecorator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateHeader {
	@Test
	public void validateHeader() {
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.request(Method.GET,"?pages=9");
		
		/*String cache=response.header("cache-control");
		System.out.println(cache);
		
		String content=response.header("etag");
		System.out.println(content);*/
		
		//get All hearder from API
		Headers allheaders=response.headers();
		
		for(Header header:allheaders) {
			System.out.println(header.getName()+"          "+header.getValue());
			
		}
		
		
	}

}
