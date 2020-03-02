package com.qa.resources;

public enum ResourceParams {

	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	 private String apiName;

	ResourceParams(String apiName){
		 
		 this.apiName=apiName;
	 }
	 
	 public String getResource() {
		 
		 return apiName;
	 }
	
}
