package com.qa.StepDefinition;

import java.io.IOException;

import org.hamcrest.core.IsNull;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@DeleteAPI")
	public void createDeletePayload() throws IOException {
		if ((StepDefinition.place_id1) != null) 
			{
				
				
			}
			
		else {
	
		StepDefinition sd = new StepDefinition();
		
		sd.addplaceapi_Payload_with_and("Rohan", "India", "Marathi");
		sd.user_calls_the_with_http_request("AddPlaceAPI", "POST");
		sd.verify_whether_place_id_created_maps_to("Rohan");
		
		
		}	
		
		}
	
	
}
