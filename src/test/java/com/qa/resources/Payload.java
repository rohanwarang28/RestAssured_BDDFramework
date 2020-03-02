package com.qa.resources;

import java.util.ArrayList;

import com.qa.pojo.Location;
import com.qa.pojo.Places;


public class Payload {

	
	public Places getData(String name,String address,String language) {
	ArrayList<String> typ = new ArrayList<String>();
	Places p = new Places();
	
	
	
	p.setAccuracy(50);
	p.setName(name);
	p.setPhone_number("(+91) 983 893 3937");
	p.setAddress(address);
	p.setWebsite("http://google.com");
	p.setLanguage(language);
	typ.add("shoe park");
	typ.add("shop");
	
	p.setTypes(typ);
	
	Location loc = new Location();
	loc.setLat(-38.383494);
	loc.setLng(33.427362);
	p.setLocation(loc);
	
	return p;
	}
	
	
	public String getDeletePayload(String placeId) {
		
		String del  = "{\r\n    \"place_id\":\""+placeId+"\"\r\n}\r\n";
		return del;
	}
}
