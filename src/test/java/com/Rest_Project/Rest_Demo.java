package com.Rest_Project;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest_Demo {

public static void main(String[] args) {
	//getMethod();
	//postMethod();
	//putMethod();
	deleteMethod();
}
	
public static void getMethod() {
	RestAssured.baseURI="https://api.github.com/";
	String bearerToken="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";
	String Response=RestAssured.given().header("Authorization", "Bearer" + bearerToken)
	.when().get("users/Dhilip1995"
			+ "/repos")
	.then().extract().asString();
	
	System.out.println(Response);
	

}

public static void postMethod() {
	RestAssured.baseURI="https://api.github.com/";
	String bearerToken="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";
	String createinformation = RestAssured.given().header("Authorization", " Bearer " + bearerToken)
	.body("{\r\n"
			+ "    \"name\": \"Dhilip\",\r\n"
			+ "    \"description\": \"This is your first repo!\",\r\n"
			+ "    \"homepage\": \"https://github.com\",\r\n"
			+ "    \"private\": false,\r\n"
			+ "    \"is_template\": true\r\n"
			+ "}").when().post("user/repos").then().log().all()
	.assertThat().statusCode(201).extract().asString();
	System.out.println(createinformation);
	

}

public static void putMethod() {
	RestAssured.baseURI="https://api.github.com/";
	String bearerToken="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";
	String updateinformation = RestAssured.given().header("Authorization", " Bearer " + bearerToken)
	.body("{\r\n"
			+ "    \"names\": [\r\n"
			+ "        \"dhilipan\",\r\n"
			+ "        \"atom\",\r\n"
			+ "        \"electron\",\r\n"
			+ "        \"api\"\r\n"
			+ "    ]\r\n"
			+ "}").when().put("repos/Dhilip1995/Dhilip/topics").then().log().all().assertThat().statusCode(200).extract().asString();
	System.out.println(updateinformation);		
			

}

private static void deleteMethod() {
	RestAssured.baseURI="https://api.github.com/";
	String bearerToken="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";
	String Delete = RestAssured.given().header("Authorization", " Bearer " + bearerToken)
			.when().delete("repos/Dhilip1995/Dhilip")
			.then().log().all().assertThat().statusCode(204).extract().asString();

			
			System.out.println(Delete);
	
	

}
}