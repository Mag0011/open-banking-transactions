package org.openbanking.com.component;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;

public class TransactionComponentTest {

    @Test
    public void givenAccountNumber_WhenJsonResponseHasBody_ThenStatus200AndBodyWithOneElement() {
        when()
                .get("/transactions/123456789")
                .then()
                .body("$", hasSize(1))
                .statusCode(200);
    }

//    @Test
//    public void givenAccountNumber_WhenJsonResponseHasBody_ThenStatus200AndEmptyBody() {
//        when()
//                .get("/transactions/123")
//                .then()
//                .body("$", hasSize(0))
//                .statusCode(200);
//    }

}
