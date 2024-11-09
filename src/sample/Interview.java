package sample;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class Interview {
	
	public void sampleRequest() {
		
		RestAssured.baseURI = "https://api.example.com";
		
		given()
			.header("ContentType", "Application/json")
			.body("{\r\n"
					+ "    \"name\": \"Hari Ganesh\",\r\n"
					+ "    \"email\": \"hari.ganesh@example.com\",\r\n"
					+ "    \"password\": \"Password123\",\r\n"
					+ "    \"confirm_password\": \"Password123\",\r\n"
					+ "    \"state\" : \"Hyd\"\r\n"
					+ "}")
		.when()
			.post("/users/register")
		.then()
			.statusCode(200)
			.log()
			.body();
	}
}