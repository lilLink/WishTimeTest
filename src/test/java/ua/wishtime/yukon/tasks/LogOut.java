package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import ua.wishtime.yukon.ui.FacebookPage;
import ua.wishtime.yukon.ui.NavigationBar;

public class LogOut implements Task {

    public static Performable exit() {
        return Instrumented.instanceOf(LogOut.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T user) {

        user.attemptsTo(
                Click.on(NavigationBar.selectAvatar()),
                Click.on(NavigationBar.buttonLogOut()),
                Open.url("https://www.facebook.com/"),
                Click.on(FacebookPage.selectDropdownLangRU()),
                Click.on(FacebookPage.buttonExitLangRU())
        );
    }
}
