package org.example.tests;

import com.opencsv.exceptions.CsvException;
import org.example.pages.LandingPage;
import org.example.pages.SignUpPage;
import org.example.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ValidSignUpTest extends BaseTest {

    private SignUpPage signUpPage;
    private LandingPage landingPage;

    @DataProvider(name = "validtestdata")
    public static Object[][] validCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/main/resources/validcreditentials.csv");
    }

    @Test(dataProvider = "validtestdata")
    public void validSignUpTest(String email, String pass, String user) throws InterruptedException {
        landingPage = new LandingPage();
        signUpPage = landingPage.clickButtonSignUp();
        signUpPage.finishSignUp(email, pass, user);
        signUpPage.checkBoxTick();
    }
}