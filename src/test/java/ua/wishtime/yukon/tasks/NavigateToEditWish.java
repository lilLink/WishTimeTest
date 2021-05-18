package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.ui.NavigationBar;
import ua.wishtime.yukon.ui.WishFormPage;

public class NavigateToEditWish implements Task {

    private final Wish wish;

    public NavigateToEditWish(Wish wish) {
        this.wish = wish;
    }

    public static Performable navigateToEdit(Wish wish) {
        return Instrumented.instanceOf(NavigateToEditWish.class).withProperties(wish);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Click.on(WishFormPage.selectNameWish(wish.getWishName())),
                Click.on(NavigationBar.selectEditWish())
        );
    }

}
