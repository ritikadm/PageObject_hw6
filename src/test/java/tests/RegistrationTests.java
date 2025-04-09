package tests;


import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import page.components.ResultTableComponent;



public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTable = registrationPage.getResultTable();

    @Test
    void fillFormTest() {

        registrationPage.openPage().
                removeBanner().
                setFirstName("Margarita").
                setLastName("Solopova").
                setEmail("Solopova@gmail.com").
                setGender().
                setUserNumber("8977926766").
                setDate0fBirth("12", "April", "2000").
                setSubjectsInput("English").
                setHobbiesCheckbox().
                selectUploadPicture().
                setCurrentAddress("Korolev").
                setState("NCR").
                setCity("Noida").
                clickSubmit();

        resultTable.checkResult("Student Name", "Margarita Solopova").
                checkResult("Student Email", "Solopova@gmail.com").
                checkResult("Gender", "Female").
                checkResult("Mobile", "8977926766").
                checkResult("Date of Birth", "12" + " " + "April" + " " + "2000").
                checkResult("Subjects", "English").
                checkResult("Hobbies", "Sports").
                checkResult("Picture", "picture.jpg").
                checkResult("Address", "Korolev").
                checkResult("State and City", "NCR" + " " + "Noida");

    }
        @Test
        void fillFormMinimumDateTest() {
            registrationPage.openPage().
                    removeBanner().
                    setFirstName("Margarita").
                    setLastName("Solopova").
                    setGender().
                    setUserNumber("8977926766").
                    clickSubmit();
            resultTable.checkResult("Student Name", "Margarita Solopova").
                    checkResult("Gender", "Female").
                    checkResult("Mobile", "8977926766").
        }

        @Test
    void fillFormNegativeDateTest(){
            registrationPage.openPage().
                    removeBanner().
                    setFirstName("Margarita").
                    setLastName("Solopova").
                    setGender().
                    setUserNumber(" ").
                    clickSubmit().
                    checkError();

        }

}
