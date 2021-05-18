package ua.wishtime.yukon.ui;

import net.serenitybdd.screenplay.targets.Target;

public class FacebookLogInPage {


    public static Target inputEmail(){
        return Target.the("Електронна адреса або номер телефону")
                .locatedBy("//input[@id='email']");

    }

    public static Target inputPassword(){
        return Target.the("Пароль")
                .locatedBy("//input[@id='pass']");

    }

    public static Target buttonLogIn(){
        return Target.the("Увійти")
                .locatedBy("//button[@id='loginbutton']");
    }
}
