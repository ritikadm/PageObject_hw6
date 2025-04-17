package tests;

import org.junit.jupiter.api.Test;
import page.TextBoxPage;



public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName("Margarita")
                .setUserEmail("solopova@mail.ru")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .clickSubmit();
        textBoxPage.outputCheck("Name:Margarita")
                .outputCheck("Email:solopova@mail.ru")
                .outputCheck("Current Address :Some street 1")
                .outputCheck("Permananet Address :Another street 1");



    }
}

