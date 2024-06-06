package org.example.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RepoHandle {

    private static final String REPO_EP = "https://api.github.com/user/repos";
    private static String token;

    @BeforeClass
    public void setup() throws IOException {
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/config.properties");
        properties.load(input);
        token = properties.getProperty("TOKEN");
        input.close();
    }

    @Test(description = "Create a repository")
    void postTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(token)
                .body("{\"name\": \"deleteme\"}")
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }

    @Test(description = "Update repository")
    void patchTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(token)
                .body("{\"name\": \"deleteme-patched\"}")
                .when()
                .patch("https://api.github.com/repos/KreshanXD/deleteme")
                .then()
                .statusCode(200);
    }

    @Test(description = "Delete repository")
    void deleteTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(token)
                .when()
                .delete("https://api.github.com/repos/KreshanXD/deleteme-patched")
                .then()
                .statusCode(204);
    }
}