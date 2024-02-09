package practiceOAuth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class OAuthAPI {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi";
		
		String accessToken = 
				given()
					.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
					.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
					.formParam("grant_type", "client_credentials")
					.formParam("scope", "trust")
					.when()
					.post("oauth2/resourceOwner/token")
					.then()
					.contentType(ContentType.JSON)
					.extract()
					.path("access_token");
		
		given()
			.param("access_token", accessToken)
			.when()
			.get("getCourseDetails")
			.then()
			.log()
			.all();
	}

}
