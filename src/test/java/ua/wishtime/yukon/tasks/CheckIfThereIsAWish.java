package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.TheMatchingElement;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.ui.NavigationBar;

public class CheckIfThereIsAWish implements Task {

    private final Wish wish;

    public CheckIfThereIsAWish(Wish wish) {
        this.wish = wish;
    }

    public static Performable checking(Wish wish) {
        return Instrumented.instanceOf(CheckIfThereIsAWish.class).withProperties(wish);
    }

    @Override
    public <T extends Actor> void performAs(T user) {

        user.attemptsTo(
                Ensure.thatTheSetOf(NavigationBar.dropDownPreModeration()).anyMatch(TheMatchingElement.containsText(wish.getWishName()))
        );
    }
}
