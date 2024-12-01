package org.openbanking.com.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openbanking.com.persistence.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    TransactionRepository transactionRepository;

    static MySQLContainer<?> mysql =
            new MySQLContainer<>("mysql:8")
                    .withDatabaseName("transactions")
                    .withInitScript("sql/database_init.sql");

    @BeforeAll
    static void beforeAll() {
        mysql.start();
    }

    @AfterAll
    static void afterAll() {
        mysql.close();
    }

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Test
    public void testSuccessfulTransaction() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/transactions/123456789")
                .then()
                .statusCode(200)
                .body("$", hasSize(2));
    }

    @Test
    public void testFailingTransaction() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/transactions/837461028")
                .then()
                .statusCode(200)
                .body("$", hasSize(0));
    }

}
