package org.example.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RepoHandle {
    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";

    @Test(description = "Create a repositorie")
    void postTest() {
        RestAssured
                .given()
                // .header("Authorization", "token " + TOKEN)
                .auth()
                .oauth2(TOKEN)
                .body("{\"name\": \"deleteme\"")
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }

    @Test(description = "Update repositories")
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

    @Test(description = "Delete repositories")
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
