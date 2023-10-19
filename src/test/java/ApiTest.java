
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.Headers;
import pojos.ResponseData;


import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {

    String baseUrl = "https://postman-echo.com";

    @Test
    public void getTest() {
        Response response = given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then().log().body().statusCode(200).extract().response();
        ResponseData responseData = response.as(ResponseData.class);
        Map<String, String> args = responseData.getArgs();
        Headers headers = responseData.getHeaders();

        assertEquals("bar1",args.get("foo1"));
        assertEquals("bar2",args.get("foo2"));
        assertEquals("https",headers.getXForwardedProto());
        assertEquals("443",headers.getXForwardedPort());
        assertTrue(headers.getXAmznTraceId() != null);
        assertEquals("postman-echo.com",headers.getHost());
        assertEquals("*/*",headers.getAccept());
        assertEquals("Apache-HttpClient/4.5.13 (Java/11.0.11)",headers.getUserAgent());
        assertEquals("gzip,deflate",headers.getAcceptEncoding());
        assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", responseData.getUrl());

    }

    @Test
    public void postRawTextTest() {
        String requestBody = "\"test\": \"value\"";
        Response response = given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/post")
                .then().log().body().statusCode(200)
                .body("data", equalTo(requestBody)).extract().response();
        ResponseData responseData = response.as(ResponseData.class);
        Headers headers = responseData.getHeaders();

        assertEquals("https",headers.getXForwardedProto());
        assertEquals("443",headers.getXForwardedPort());
        assertEquals("postman-echo.com",headers.getHost());
        assertTrue(headers.getXAmznTraceId() != null);
        assertEquals(requestBody.length(), headers.getContentLength());
        assertEquals("*/*",headers.getAccept());
        assertEquals("application/json",headers.getContentType());
        assertEquals("Apache-HttpClient/4.5.13 (Java/11.0.11)",headers.getUserAgent());
        assertEquals("gzip,deflate",headers.getAcceptEncoding());
        assertEquals("https://postman-echo.com/post", responseData.getUrl());

    }

    @Test
    public void postFormDataTest() {
        Response response = given().baseUri(baseUrl)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1","bar1")
                .formParam("foo2","bar2")
                .post("/post")
                .then().statusCode(200).log().body().extract().response();
        ResponseData responseData = response.as(ResponseData.class);
        Map<String, String> form = responseData.getForm();
        Headers headers = responseData.getHeaders();
        Map<String,String> json = responseData.getJson();

        assertEquals("bar1",form.get("foo1"));
        assertEquals("bar2",form.get("foo2"));
        assertEquals("https",headers.getXForwardedProto());
        assertEquals("443",headers.getXForwardedPort());
        assertEquals("postman-echo.com",headers.getHost());
        assertTrue(headers.getXAmznTraceId() != null);
        assertEquals(19, headers.getContentLength());
        assertEquals("*/*",headers.getAccept());
        assertEquals("application/x-www-form-urlencoded; charset=UTF-8",headers.getContentType());
        assertEquals("Apache-HttpClient/4.5.13 (Java/11.0.11)",headers.getUserAgent());
        assertEquals("gzip,deflate",headers.getAcceptEncoding());
        assertEquals("bar1",json.get("foo1"));
        assertEquals("bar2",json.get("foo2"));
        assertEquals("https://postman-echo.com/post", responseData.getUrl());

    }

    @Test
    public void putTest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("/put")
                .then().statusCode(200).log().body()
                .body("data", equalTo(requestBody)).extract().response();
        ResponseData responseData = response.as(ResponseData.class);
        Headers headers = responseData.getHeaders();

        assertEquals("https",headers.getXForwardedProto());
        assertEquals("443",headers.getXForwardedPort());
        assertEquals("postman-echo.com",headers.getHost());
        assertTrue(headers.getXAmznTraceId() != null);
        assertEquals(requestBody.length(), headers.getContentLength());
        assertEquals("*/*",headers.getAccept());
        assertEquals("application/json",headers.getContentType());
        assertEquals("Apache-HttpClient/4.5.13 (Java/11.0.11)",headers.getUserAgent());
        assertEquals("gzip,deflate",headers.getAcceptEncoding());
        assertEquals(null ,responseData.getJson());
        assertEquals("https://postman-echo.com/put", responseData.getUrl());

    }

    @Test
    public void patchTest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .patch("/patch")
                .then().statusCode(200).log().body()
                .body("data", equalTo(requestBody)).extract().response();
        ResponseData responseData = response.as(ResponseData.class);
        Headers headers = responseData.getHeaders();

        assertEquals("https",headers.getXForwardedProto());
        assertEquals("443",headers.getXForwardedPort());
        assertEquals("postman-echo.com",headers.getHost());
        assertTrue(headers.getXAmznTraceId() != null);
        assertEquals(requestBody.length(), headers.getContentLength());
        assertEquals("*/*",headers.getAccept());
        assertEquals("application/json",headers.getContentType());
        assertEquals("Apache-HttpClient/4.5.13 (Java/11.0.11)",headers.getUserAgent());
        assertEquals("gzip,deflate",headers.getAcceptEncoding());
        assertEquals(null ,responseData.getJson());
        assertEquals("https://postman-echo.com/patch", responseData.getUrl());

    }

    @Test
    public void deleteTest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .delete("/delete")
                .then().statusCode(200).log().body()
                .body("data", equalTo(requestBody)).extract().response();
        ResponseData responseData = response.as(ResponseData.class);
        Headers headers = responseData.getHeaders();

        assertEquals("https",headers.getXForwardedProto());
        assertEquals("443",headers.getXForwardedPort());
        assertEquals("postman-echo.com",headers.getHost());
        assertTrue(headers.getXAmznTraceId() != null);
        assertEquals(requestBody.length(), headers.getContentLength());
        assertEquals("*/*",headers.getAccept());
        assertEquals("application/json",headers.getContentType());
        assertEquals("Apache-HttpClient/4.5.13 (Java/11.0.11)",headers.getUserAgent());
        assertEquals("gzip,deflate",headers.getAcceptEncoding());
        assertEquals(null ,responseData.getJson());
        assertEquals("https://postman-echo.com/delete", responseData.getUrl());

    }

}
