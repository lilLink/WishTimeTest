package ua.wishtime.yukon.tasks.admin;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import ua.wishtime.yukon.ui.AdminPage;
import ua.wishtime.yukon.ui.FacebookPage;

public class AdminLogOut implements Task {

    public static Performable exit() {
        return Instrumented.instanceOf(AdminLogOut.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T admin) {

        admin.attemptsTo(
                Open.url("https://wishtime.yukon.cv.ua/admin"),
                Click.on(AdminPage.buttonExit()),
                Open.url("https://www.facebook.com/"),
                Click.on(FacebookPage.selectDropdownLangUA()),
                Click.on(FacebookPage.buttonExitLangUA())
        );
    }
}
