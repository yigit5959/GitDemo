package API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;






import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;
import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.replaceFiltersWith;

  @FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class HardCodedExamples {
      String x="a";
      String y="b";


         String baseURI= RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";

         String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5Njk1OTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxMjc5MCwidXNlcklkIjoiNTMyMCJ9.7F9mDR5xiFO0Db6j0hyfbbJszNsATfJpAWvsrvRsTC8";


    static String employee_id;



   @Test
   public void bgetCreatedEmployee(){
       RequestSpecification preparedRequest=given().header("Content-Type","application/json")
               .header("Authorization",token).queryParam("employee_id",employee_id);

       //hitting the endpoint
       Response response=preparedRequest.when().get("/getOneEmployee.php");
       response.prettyPrint();
       //verify the repsone
       response.then().assertThat().statusCode(200);

       String tempEmpId=response.jsonPath().getString("employee.employee_id");

       //we have 2 emp id one is global second s local
       Assert.assertEquals(employee_id,tempEmpId);




   }




    @Test


         public void acreateEmployee(){
              // prepare the request
             RequestSpecification preparedRequest= given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
                     "  \"emp_firstname\": \"Hagi\",\n" +
                     "  \"emp_lastname\": \"Metin\",\n" +
                     "  \"emp_middle_name\": \"Oktay\",\n" +
                     "  \"emp_gender\": \"M\",\n" +
                     "  \"emp_birthday\": \"2005-05-10\",\n" +
                     "  \"emp_status\": \"comfirmed\",\n" +
                     "  \"emp_job_title\": \"Legend\"\n" +
                     "}");


             // hitting the end point/send the request
           Response response= preparedRequest.when().post("/createEmployee.php");




             //verifying thr assertions / get response

            response.then().assertThat().statusCode(201);


           // it will print the output in the console
            response.prettyPrint();

        //we are capturing employee id from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

             response.then().assertThat().body("Employee.emp_firstname",Matchers.equalTo("Hagi"));


             System.out.println("My test case is passed");




   }

         @Test
   public void cupdateEmployee(){

       RequestSpecification preparedRequest=given().header("Content-Type","application/json").
               header("Authorization",token).body("{\n" +
                       "  \"employee_id\": \""+employee_id+"\",\n" +
                       "  \"emp_firstname\": \"icardi\",\n" +
                       "  \"emp_lastname\": \"Toreria\",\n" +
                       "  \"emp_middle_name\": \"Muslera\",\n" +
                       "  \"emp_gender\": \"F\",\n" +
                       "  \"emp_birthday\": \"2005-05-10\",\n" +
                       "  \"emp_status\": \"probation\",\n" +
                       "  \"emp_job_title\": \"CEO\"\n" +
                       "}");

       // hitting the endpoint
       Response response=preparedRequest.when().put("/updateEmployee.php");
       response.then().assertThat().statusCode(200);

       //for verification
       response.then().assertThat().body("Message",Matchers.equalTo("Employee record Updated"));



   }

   @Test
      public void dgetUpdatedEmployee(){
       RequestSpecification preparedRequest = given().
               header("Content-Type","application/json").
               header("Authorization", token).
               queryParam("employee_id",employee_id);

       Response response = preparedRequest.when().get("/getOneEmployee.php");
       response.prettyPrint();
       response.then().assertThat().statusCode(200);
       //if you want to verify the body of the response.
       //you can do that using hamcrest matchers





   }







}
