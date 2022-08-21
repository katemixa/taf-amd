package ui.step;

import ui.page.HomePage;
import ui.page.LoginPage;
import ui.utils.Random;

public class LoginPageStep extends LoginPage {
    public LoginPage typeLoginFormFields(String userEmail, String userPassword) {
        return new HomePage().openPage()
                .clickLogIn()
                .typeUserEmail(userEmail)
                .typePassword(userPassword);
    }

//    public LoginPageStep verify(){
//
//    }
}
