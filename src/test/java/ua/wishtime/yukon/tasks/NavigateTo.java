package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import ua.wishtime.yukon.ui.NavigationBar;
import ua.wishtime.yukon.ui.WishTimeHomePage;

public class NavigateTo implements Task {

    private WishTimeHomePage wishTimeHomePage;

    public static Performable logInFromFacebook(String element) {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(element);
    }

    @Override
    @Step("{0} authorize in WishTime")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(wishTimeHomePage),
                Click.on(NavigationBar.logIn()),
                Click.on(NavigationBar.checkboxLogin()),
                Click.on(NavigationBar.cookieButton()),
                Click.on(NavigationBar.logInFromFacebook())
        );
    }
}
