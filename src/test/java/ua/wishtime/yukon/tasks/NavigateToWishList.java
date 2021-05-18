package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ua.wishtime.yukon.ui.NavigationBar;

public class NavigateToWishList implements Task {

    public static Performable navigateToWishList() {
        return Instrumented.instanceOf(NavigateToWishList.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Click.on(NavigationBar.selectAvatar()),
                Click.on(NavigationBar.selectYourPage()),
                Click.on(NavigationBar.selectModerationWish())
        );
    }
}
