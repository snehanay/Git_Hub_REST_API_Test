import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class APITests {
    @Test
    void test1() {
        Response response = RestAssured.get("http://10.0.64.223:8082/PlatformSandboxApp/actuator/health");

        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Body :" + response.getBody().asString());
        System.out.println("Time :" + response.getTime());
        System.out.println("Header :" + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void test2(){

        given().
                get("http://10.0.64.223:8082/PlatformSandboxApp/actuator/health").
                then().
                statusCode(200);
    }

}
