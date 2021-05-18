package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;
import ua.wishtime.yukon.ui.NavigationBar;
import ua.wishtime.yukon.ui.WishTimeHomePage;

public class CreateWish implements Task {

    private WishTimeHomePage wishTimeHomePage;

    public static Performable create(String element) {
        return Instrumented.instanceOf(CreateWish.class).withProperties(element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(wishTimeHomePage),
                Click.on(NavigationBar.createWish()),
                Click.on(By.xpath("//section[@class='main']/section[@class='left']/button"))
        );
    }
}
