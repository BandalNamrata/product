package com.algoDomain.TechnicalTask;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.restassured.RestAssured.with;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.algoDomain.TechnicalTask.entity.Product;
import com.github.tomakehurst.wiremock.WireMockServer;

import io.restassured.RestAssured;

@SpringBootTest
class TechnicalTaskApplicationTests {
	 private static final String EVENTS_PATH = "/user";
	    private static final String APPLICATION_JSON = "application/json";
	    private static final String USER = getJson();
	    private static WireMockServer wireMockServer;

	    @BeforeClass
	    public static void before() {
	        System.out.println("Setting up!");
	        final int port = Util.getAvailablePort();
	        wireMockServer = new WireMockServer(port);
	        wireMockServer.start();
	        configureFor("localhost", port);
	        RestAssured.port = port;
	        stubFor(get(urlEqualTo(EVENTS_PATH)).willReturn(
	                aResponse().withStatus(200)
	                        .withHeader("Content-Type", APPLICATION_JSON)
	                        .withBody(USER)));
	        stubFor(post(urlEqualTo("/user/product"))
	                .withRequestBody(containing("{\"name\":\"piyu\",\"mobileNumber\":\"90876756\",\"email\":\"piyu@gmail.com\",\"password\":\"1234\",\"phoneNo\":\"67899878\",\"adharCard\":\"898767\",\"drivingLicence\":\"89876\",\"bloodGroup\":\"A+\",\"roles\":2,\"schoolId\":2}"))
	                .willReturn(aResponse().withStatus(201)));
	    }
	    private static String getJson() {
	        return Util.inputStreamToString(TechnicalTaskApplicationTests.class
	                .getResourceAsStream("/user.json"));
	    }


	    @Test
	    public void whenRequestedPost_thenCreated() {
	        with().body(new Product())
	                .when()
	                .request("POST", "/user/product")
	                .then()
	                .statusCode(201);
	    }
	    @Test 
		  public void getUser() {
			  RestAssured.given()
			  .get("/user/allProduct")
			  .then(). statusCode(200); 
			  }
}
