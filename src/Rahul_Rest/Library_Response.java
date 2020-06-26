package Rahul_Rest;


import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Library_Response {

	@Test(dataProvider="BooksData")
	public void addbook(String isbn,String aisle)
	{
		
		//given
		RestAssured.baseURI="http://216.10.245.166";
   String Response= given().log().all().header("Content-Type","application/json").body(PayLoads.Addbook("asdf","5556"))
    		.when().post("Library/Addbook.php ")
    		.then().log().all().assertThat().statusCode(200).extract().response().asString();
    JsonPath js=new JsonPath(Response);
   String id= js.get("ID");
   System.out.println(id);

   
   
 


		}


		
		
		
	}
		
		
		

	


