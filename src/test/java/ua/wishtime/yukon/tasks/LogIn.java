package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import ua.wishtime.yukon.model.RegisteredUser;
import ua.wishtime.yukon.ui.FacebookLogInPage;

public class LogIn implements Task {

    public static LogIn withCredential(){
        return Instrumented.instanceOf(LogIn.class).withProperties();
    }

    @Override
    @Step("Logs in as: {0}")
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Enter.theValue(registered(user).email()).into(FacebookLogInPage.inputEmail()),
                Enter.theValue(registered(user).password()).into(FacebookLogInPage.inputPassword()),
                Click.on(FacebookLogInPage.buttonLogIn())
        );
    }

    private RegisteredUser registered(Actor actor){
        return (RegisteredUser) actor;
    }
}
