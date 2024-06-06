package org.example.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

// Create, change and delete a repository.

public class RepoHandle {
    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";

    @Test(description = "Create a repositorie")
    void postTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body("{\"name\": \"deleteme\"")
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }

    @Test(description = "Update repositorie")
    void patchTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body("{\"name\": \"deleteme-patched\"}")
                .when()
                .patch("https://api.github.com/repos/KreshanXD/deleteme")
                .then()
                .statusCode(200);
    }

    @Test(description = "Delete repositorie")
    void deleteTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete("https://api.github.com/repos/KreshanXD/deleteme-patched")
                .then()
                .statusCode(204);
    }
}
