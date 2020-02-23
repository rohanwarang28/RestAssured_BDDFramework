package com.qa.StepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.runner.Request;
import static org.junit.Assert.*;

import com.qa.pojo.Location;
import com.qa.pojo.Places;
import com.qa.resources.Payload;
import com.qa.resources.ResourceParams;
import com.util.TestUtil;

import static io.restassured.RestAssured.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class AddPlaceStepDefinition extends TestUtil{

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	Payload p1 = new Payload();
	public static String place_id1;
	
	
	@Given("AddPlaceAPI Payload with {string} {string} and {string}")
	public void addplaceapi_Payload_with_and(String name, String address, String language) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	
		  res = given().spec(RequestBuilders()).body(p1.getData(name,address,language));
	}

	@When("User calls the {string} with {string} http request")
	public void user_calls_the_with_http_request(String apiName, String reqType)  {
	    // Write code here that turns the phrase above into concrete actions
		
		ResourceParams reqParam = ResourceParams.valueOf(apiName);
		String reqParams = reqParam.getResource();
		 resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
		 if(reqType.equalsIgnoreCase("POST")) {
	     response = res.when().post(reqParams);
	     		 }
		 
		 else if(reqType.equalsIgnoreCase("GET")) {
			 
			 response =  res.when().get(reqParams);
		 }
	    //System.out.println(response.asString());
	}

	@Then("Response is returned with Status code {int}")
	public void response_is_returned_with_Status_code(int statusCode) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(statusCode, response.getStatusCode());
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
	   //String response1 = response.asString();
	   
		
		//JsonPath js =  new JsonPath(response1);
	   assertEquals(TestUtil.getJsPath(response, key).toString(), value);
	}
	
	
	@And("Verify whether place_id created maps to {string}")
	public void verify_whether_place_id_created_maps_to(String name) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 place_id1 = TestUtil.getJsPath(response, "place_id").toString();
		res = given().spec(RequestBuilders()).queryParam("place_id",place_id1 );
		user_calls_the_with_http_request("GetPlaceAPI", "GET");
		assertEquals(TestUtil.getJsPath(response, "name").toString(), name);
	}
	
	@Given("DeletePlaceAPI Payload")
	public void deleteplaceapi_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   res = given().spec(RequestBuilders()).body(p1.getDeletePayload(place_id1));
	   
	}
	
}
