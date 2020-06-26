package sreeServiceRequest;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import files.PayLoads;

import static io.restassured.RestAssured.*;

public class SreeServiceRestAssuredScript extends PayLoads{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI ="http://localhost:9090";
		//to save and add user
	String Response=given().log().all().header("Content-Type","application/json").body(PayLoads.AddUser("nikki", "2017-08-02T14:14:52.147+00:00"))
	.when().post("/saveUsers")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(Response);
	
	//get the user
	String Rep=given().log().all().header("Content-Type", "application/json")
	.when().get("/findAllUsers")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	System.out.println(Rep);
	
	
	
		
		

	}

}
