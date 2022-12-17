package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class GetRequestStepDefs {

    Response response;

    @Given("I submit a GET request with employee id={int}")
    public void i_submit_a_get_request_with_employee_id(Integer int1) {
        response =  given()
                .contentType(ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty("api_GET_url"));
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    @Then("I should have status-code={int} and employee id={int} should be listed")
    public void i_should_have_status_code_and_employee_id_should_be_listed(long int1, long int2) {
        Assert.assertEquals(response.getStatusCode(), int1);
    }
}
