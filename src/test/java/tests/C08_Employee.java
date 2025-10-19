package tests;

import base_urls.DummyUrl;
import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.path.json.JsonPath.given;
import static org.testng.AssertJUnit.assertEquals;

public class C08_Employee extends DummyUrl {
    @Test
    void test (){
//        Given
//        https://dummy.restapiexample.com/api/v1/employees
//        When
//        User sends GET request
//        Then
//        Status code is 200
//        And
//        There are 24 employees
//                And
//        "Tiger Nixon" and "Garrett Winters" are among them
//                And
//        Highest age = 66
//        And
//                Youngest = "Tatyana Fitzpatrick"
//        And
//        Total salary = 6,644,770

        Response response =  RestAssured.given(spec).get("/api/v1/employees");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        assertEquals(response.statusCode(), 200);

        int employeenum = jsonPath.getList("data").size();
        assertEquals(24,employeenum);
        System.out.println(" There are 24 employees"+ employeenum);
        String tiger = jsonPath.getString("data.findAll{ it.employee_name == 'Tiger Nixon' }.employee_name");
      String garrett = jsonPath.getString("data.findAll{ it.employee_name == 'Garrett Winters' }.employee_name");

        System.out.println( tiger  + "    and   "+ garrett +"  are among them");

        String maxAge = jsonPath.getString("data.max { it.employee_age }.employee_name");
        System.out.println("Highest age: " + maxAge);

        String youngestEmployee = jsonPath.getString("data.min { it.employee_age }.employee_name");
        System.out.println("Lowest age: " + youngestEmployee);

//
        int totalSalary = jsonPath.getInt("data.collect { it.employee_salary.toInteger() }.sum()");
        System.out.println("Total salary: " + totalSalary);

    }
}
