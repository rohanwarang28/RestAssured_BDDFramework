package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestUtil {

	public static RequestSpecification reqspec;
	ResponseSpecification resspec;
	static PrintStream ps;
	
	public RequestSpecification RequestBuilders() throws IOException {
	
	if(reqspec != null) {}	
	else{ ps = new PrintStream(new File("logger.txt"));
	}	
	 reqspec =new RequestSpecBuilder().setBaseUri((String) fetchProperties("baseUri"))
								.addQueryParam("key","qaclick123").setContentType(ContentType.JSON).
								addFilter(RequestLoggingFilter.logRequestTo(ps))
								.addFilter(ResponseLoggingFilter.logResponseTo(ps))
								.build();
		
	return reqspec;
	}
	
	
	public Object fetchProperties(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\EnvironmentVariables.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		return prop.get(key);
		
	}
	
	
	public static Object getJsPath(Response response1,String key) {
		
		 JsonPath js =  new JsonPath(response1.asString());
		 return js.get(key);
	}
	
	
	
}
