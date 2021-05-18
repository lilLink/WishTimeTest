package ua.wishtime.yukon.tasks.fill;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.ui.WishFormPage;

public class FillWishFormWithEmptyCategory implements Task {

    private final Wish wish;

    public FillWishFormWithEmptyCategory(Wish wish) {
        this.wish = wish;
    }

    public static Performable fillForm(Wish wish) {
        return Instrumented.instanceOf(FillWishFormWithEmptyCategory.class).withProperties(wish);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Enter.theValue(wish.getWishName()).into(WishFormPage.inputWishName()),
                Enter.theValue(wish.getLinkToProduct()).into(WishFormPage.inputLinkToProduct()),
                Enter.theValue(wish.getPrice()).into(WishFormPage.inputPrice()),
                Enter.theValue(wish.getFullName()).into(WishFormPage.inputFullName()),
                Enter.theValue(wish.getPhoneNumber()).into(WishFormPage.inputPhoneNumber()),
                Click.on(WishFormPage.addNewAddress()),
                Enter.theValue(wish.getAddress().getCity()).into(WishFormPage.inputCity()),
                Enter.theValue(wish.getAddress().getStreet()).into(WishFormPage.inputStreet()),
                Enter.theValue(wish.getAddress().getHouseNumber()).into(WishFormPage.inputHouseNumber()),
                Click.on(WishFormPage.saveAddress())
        );
    }
}
