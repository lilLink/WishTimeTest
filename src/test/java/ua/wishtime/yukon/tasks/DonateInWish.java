package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ua.wishtime.yukon.ui.NavigationBar;

public class DonateInWish implements Task {

    private final String sum;

    public DonateInWish(String sum) {
        this.sum = sum;
    }

    public static Performable donate(String sum) {
        return Instrumented.instanceOf(DonateInWish.class).withProperties(sum);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Enter.theValue(sum).into(NavigationBar.inputAmount()),
                Click.on(NavigationBar.buttonDonate())
        );
    }
}
