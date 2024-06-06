package org.example.tests;

import com.opencsv.exceptions.CsvException;
import org.example.pages.LandingPage;
import org.example.pages.SignUpPage;
import org.example.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class InvalidSignUpTest extends BaseTest {
    private SignUpPage signUpPage;
    private LandingPage landingPage;


    @DataProvider(name = "invalidemails")
    public static Object[][] emailCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/main/resources/invalidemails.csv");
    }

    @DataProvider(name = "invalidpasswords")
    public static Object[][] passCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/main/resources/invalidpasswords.csv");
    }

    @DataProvider(name = "invalidusernames")
    public static Object[][] userCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/main/resources/invalidusernames.csv");
    }


    @Test(dataProvider = "invalidemails")
    public void invalidEmailsTest(String email, String emailErrorText) {
        landingPage = new LandingPage();
        signUpPage = landingPage.clickButtonSignUp();
        signUpPage.invalidEmailSetup(email);
        assertEquals(emailErrorText, signUpPage.emailErrorMessage());
    }

    @Test(dataProvider = "invalidpasswords")
    public void invalidPasswordsTest(String pass, String passErrorMessage) {
        landingPage = new LandingPage();
        signUpPage = landingPage.clickButtonSignUp();
        signUpPage.validEmailSetup("gosho@gosho.com");
        signUpPage.invalidPassSetup(pass);
        assertEquals(passErrorMessage, signUpPage.passErrorMessage());
    }

    @Test(dataProvider = "invalidusernames")
    public void invalidUserNamesTest(String user, String userErrorMessage) {
        landingPage = new LandingPage();
        signUpPage = landingPage.clickButtonSignUp();
        signUpPage.validEmailSetup("gosho@gosho.com");
        signUpPage.validPassSetup("Gosho100#");
        signUpPage.invalidUserSetup(user);
        assertEquals(userErrorMessage, signUpPage.userErrorMessage());
    }

}

