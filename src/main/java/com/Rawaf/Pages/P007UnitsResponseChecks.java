package com.Rawaf.Pages;
import com.Rawaf.Responses.UnitResponseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P007UnitsResponseChecks {

    private static final String BASE_URL = "https://beta.rawaf.ai/api/deals";


    public void testGetPropertyDetails(String expectedStatus , String projectId , int unitId ) {
        RestAssured.baseURI = BASE_URL;

        // Perform the API request and extract the response
        Response response = given()
                .pathParam("unitId", projectId)
                .when()
                .get("/{unitId}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Extract response body as an array of PropertyModel
        UnitResponseModel[] propertyArray = response.as(UnitResponseModel[].class);

        // Iterate through the array to find the object with dealDetailsId equal to 415
        UnitResponseModel matchingProperty = null;
        for (UnitResponseModel property : propertyArray) {
            if (property.getDealDetailsId() == unitId) {
                matchingProperty = property;
                break; // Exit the loop once a match is found
            }
        }

        // Assert that a matching PropertyModel is found
        assert matchingProperty != null : "No PropertyModel found with dealDetailsId " + unitId;

        // Assert on the status value of the matching PropertyModel
        String actualStatus = matchingProperty.getStatus();
        given()
                .when()
                .then()
                .statusCode(200)
                .body("status", equalTo(actualStatus));
        System.out.println(actualStatus);
        Assert.assertTrue(actualStatus.equals(expectedStatus));
    }
}
