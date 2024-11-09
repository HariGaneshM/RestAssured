package sample;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class InterviewQuestion {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		Map<String, String> payload = new HashMap<>();
		
		payload.put("name", "String");
		payload.put("job", "String");
		
		Response response = RestAssured
				.given()
					.header("ContentType", "Application/JSON")
					.body(payload)
				.when()
					.post("/api/users")
				.then()
					.statusCode(200)
					.header("ContentType", "Application/JSON");
			
		
	}

}

//Task 2: Automate and verify Response Structure ,by  using                  MAP/POJO/JSON Object to  fetch payload .
//Method: POST
//Resource: /api/users
//Payload:
////{
//  "name": "String",
//  "job": "String"
//}
//
//Expected Response:
//{
//  "name": "String",
//  "job": "string",
//  "id": "156",
//  "createdAt": "String"
//}
//
//Steps:
//Send a POST request to /api/users with a JSON payload containing name and job fields.
//Verify that the response structure matches the expected JSON format:
//Contains name, job, id, and create
//Base URL: https://reqres.in/
//Objective: Automate API requests using Rest Assured with Java to interact with the ReqRes      API.
