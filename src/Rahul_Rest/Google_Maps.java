package Rahul_Rest;

import org.testng.Assert;

import files.PayLoads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;



public class Google_Maps {
	
	public static String placeid;
	
	public static void main(String[] args){
		
	
	
	//Add place using post method
	
	//set base uri -https://rahulshettyacademy.com
	
		
   	      RestAssured.baseURI = "https://rahulshettyacademy.com";
   	      
	      //given
   	      
   	    String response=  given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(PayLoads.addplace())
   	     
   	     
   	      //when u are submitting api with post http method with resource- /maps/api/place/add/json
   	       .when().post("/maps/api/place/add/json")
   	      
   	      //then response
   	      .then().log().all().assertThat().statusCode(200).assertThat()
   	     
   	      //verifying response body
   	      .body("scope", equalTo("APP"))
   	     
   	      //verifying header validation
   	      .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
   	 System.out.println(response);
   	    
   	   //retrieving placeid from add place to use in other operations
   	    
   	   
   	      
   	    JsonPath js=new JsonPath(response);
   	   placeid= js.get("place_id");
   	   System.out.println("place id is"+placeid);
   	   
   	   //update Address using put http method
   	 
   	   //given
   	   given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
   	   .body(PayLoads.updateplace())
   	   
   	   //when
   	   .when().put("/maps/api/place/update/json")
   	   
   	   //then
   	   .then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
   	   
   	   
   	   //getplace 
   	   //given
   	  
   	    	   
   	    String getresponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
   	   
   	     //when
   	     
   	     .when().get("/maps/api/place/get/json")
   	     //then
   	     .then().log().all().assertThat().statusCode(200).extract().response().asString();
   	    
   	    JsonPath js1=new JsonPath(getresponse);
   	   String actualaddress= js1.get("address");
   	   System.out.println(actualaddress);
   	  
   	   
   	      		
	      
}
	
}	
	


