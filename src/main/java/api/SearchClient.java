package api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.PayloadBuilder;

import static io.restassured.RestAssured.given;

public class SearchClient {

    public static Response searchWithKey(String term) {
        RestAssured.baseURI = "https://uscs32v2.ksearchnet.com";

        return given().header("Content-Type", "application/json")
                .body(PayloadBuilder.getSearchPayload(term)).post("/cs/v2/search");

    }
}
