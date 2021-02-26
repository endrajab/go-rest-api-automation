package com.endrajab.gorestapi.common;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.config.RestAssuredConfig.config;

public class HttpClient {

    private String requestBody;

    private String endpoint;

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public HttpClient(String endpoint) {
        this.endpoint = endpoint;
    }

    public RequestSpecification BuildRequest() {
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification request = SerenityRest.given();
        request.config(config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                header("Content-Type", "application/jason").
                header("Authorization", "Bearer 186b676368adfb9bc8ddf8986395be24a673f9dcbc042b1544e9b2273a34c2a4").
                contentType(ContentType.JSON);
        return request;
    }

    public Response PostMethod(RequestSpecification request) {
        request.body(this.requestBody);
        return request.post(this.endpoint);
    }

    public Response GetMethod(RequestSpecification request) {
        return request.get(this.endpoint);
    }

    public Response PutMethod(RequestSpecification request) {
        request.body(this.requestBody);
        return request.put(this.endpoint);
    }
}
