package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class PostRequestStepDefs {

    Response response;
    @Given("I submit a POST request with given employee details")
    public void i_submit_a_post_request_with_given_employee_details() {
        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/create";
        String jsonBody ="{\n" +
                "      \"employee_name\":\"Male\",\n" +
                "      \"employee_salary\":35000,\n" +
                "      \"employee_age\":65,\n" +
                "      \"profile_image\":\"\",\n" +
                "   }";
        response=given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(jsonBody)
                .when()
                .post("https://dummy.restapiexample.com/api/v1/create");
        response.prettyPrint();
        System.out.println(response.statusCode());
    }
    @Then("I should have status-code={int} and a new employee should be created")
    public void i_should_have_status_code_and_a_new_employee_should_be_created(long int1) {
        System.out.println("StatusCode() = " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), int1);

    }
}