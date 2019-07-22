package RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCall {
	@Test
	public void Post_request() {
		 RestAssured.baseURI="https://reqres.in/api/users";
		 //Reuqest object
		 RequestSpecification request=RestAssured.given();
		 //Responce Object
		 
		//payload
		 JSONObject jsonobject=new JSONObject();
		 
		 jsonobject.put("emial", "sachin123456@gmail.com");
		 jsonobject.put("Fname", "sachin");
		 jsonobject.put("Lname", "sahu");
		 jsonobject.put("age", "19");
		 
		 request.header("Content-Type","application/json");
		  
		 request.body(jsonobject.toJSONString());
		 Response response=request.request(Method.POST,"?page=11");
		 
		 String responceString=response.getBody().asString();
		 System.out.println(responceString);
		 
		 int responceCodee=response.getStatusCode();
		 Assert.assertEquals(responceCodee, 201);
		 
		 String successCode=response.jsonPath().get("Successcode");
		 System.out.println(successCode);
		 
		// System.out.println(responceCodee);
		 
		 
	}

}
