package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class DeleteRequestStepDefs {
    Response response;
    @Given("I submit a DELETE request for employee id={int}")
    public void i_submit_a_delete_request_for_employee_id(Integer int1) {
        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/delete/2";

        response=given().log().all()
                .when()
                .delete("https://dummy.restapiexample.com/api/v1/delete/2");
        response.prettyPrint();
        System.out.println(response.statusCode());


    }
    @Then("I should have a status-code={int} and employee id={int} should be deleted")
    public void i_should_have_a_status_code_and_employee_id_should_be_deleted(long int1, long int2) {
        Assert.assertEquals(int1,response.statusCode());
        response =  given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://dummy.restapiexample.com/api/v1/get/2");
        Assert.assertEquals(404,response.statusCode());
    }

}
