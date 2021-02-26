package com.endrajab.gorestapi.steps;

import com.endrajab.gorestapi.common.HttpClient;
import com.endrajab.gorestapi.model.CreateUserRequestModel;
import com.endrajab.gorestapi.model.CreateUserResponseModel;
import com.endrajab.gorestapi.model.DataCreateUserResponseModel;
import com.endrajab.gorestapi.model.UpdateUserRequestModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.json.Json;

public class UserAPIDefinitions {

    public String userRegistered;

    Response response;

    CreateUserRequestModel createUserRequestModel = new CreateUserRequestModel();

    CreateUserResponseModel createUserResponseModel = new CreateUserResponseModel();

    DataCreateUserResponseModel dataCreateUserResponseModel = new DataCreateUserResponseModel();

    UpdateUserRequestModel updateUserRequestModel = new UpdateUserRequestModel();

    @Given("email user is {string}")
    public void emailUserIs(String email) {
        createUserRequestModel.setEmail(email);
    }

    @And("name user is {string}")
    public void nameUserIs(String name) {
        createUserRequestModel.setName(name);
    }

    @And("gender user is {string}")
    public void genderUserIs(String gender) {
        createUserRequestModel.setGender(gender);
    }

    @And("status status user is {string}")
    public void statusStatusUserIs(String status) {
        createUserRequestModel.setStatus(status);
    }

    @When("user access api {string}")
    public void userAccessApi(String endpoint) {
        String body;
        HttpClient httpClient = new HttpClient(endpoint);

        Json json = new Json();
        body = json.toJson(createUserRequestModel);

        httpClient.setRequestBody(body);
        RequestSpecification req = httpClient.BuildRequest().log().all();
        response = httpClient.PostMethod(req);
        response.then().log().all();
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println(jsonPathEvaluator);

        dataCreateUserResponseModel.setId(jsonPathEvaluator.get("data.id"));
        userRegistered = String.valueOf(dataCreateUserResponseModel.getId());
        System.out.println(userRegistered);
    }

    @Then("user get the status code {int}")
    public void userGetTheStatusCode(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @And("response body code {int}")
    public void responseBodyCode(int code) {
        response.then().body("code", Matchers.equalTo(code));
    }

    @And("response body have data {string}, {string}, {string} and {string}")
    public void responseBodyHaveEmailNameGenderAndStatus(String email, String name, String gender, String status) {
        response.then().body("data.email", Matchers.equalTo(email));
        response.then().body("data.name", Matchers.equalTo(name));
        response.then().body("data.gender", Matchers.equalTo(gender));
        response.then().body("data.status", Matchers.equalTo(status));
    }

    @When("user access api get user detail")
    public void userAccessApiGetUserDetail() {
        HttpClient httpClient = new HttpClient("/public-api/users/" + userRegistered);

        RequestSpecification req = httpClient.BuildRequest().log().all();
        response = httpClient.GetMethod(req);
        response.then().log().all();
    }

    @When("user access api for update user with data {string} and {string}")
    public void userAccessApiForUpdateUserWithDataEmail_updateAndName_update(String email, String name) {
        String body;

        updateUserRequestModel.setEmail(email);
        updateUserRequestModel.setName(name);
        Json json = new Json();
        body = json.toJson(updateUserRequestModel);

        HttpClient httpClient = new HttpClient("/public-api/users/" + userRegistered);

        httpClient.setRequestBody(body);
        RequestSpecification req = httpClient.BuildRequest().log().all();
        response = httpClient.PutMethod(req);
        response.then().log().all();
    }
}
