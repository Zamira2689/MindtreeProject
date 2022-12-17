package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;


public class UpdateRequestStepDefs {
    Response response;

    @Given("I submit a PUT request for employee id={int} with salary change")
    public void i_submit_a_put_request_for_employee_id_with_salary_change(Integer int1) {

        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/update/1";
        String jsonBody ="{\n" +
                "      \"id\":1,\n" +
                "      \"employee_name\":\"Male\",\n" +
                "      \"employee_salary\":45000,\n" +
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
                .put("https://dummy.restapiexample.com/api/v1/update/1");
        response.prettyPrint();
        System.out.println(response.statusCode());


    }
    @Then("I should have status-code={int} and employee id={int} salary has updated")
    public void i_should_have_status_code_and_employee_id_salary_has_updated(long int1, Integer int2) {
        Assert.assertEquals(int1,response.getStatusCode() );

    }

}