package ua.wishtime.yukon.tasks.fill;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.ui.WishFormPage;

public class FillWishFormWithEmptyName implements Task {

    private final Wish wish;

    public FillWishFormWithEmptyName(Wish wish) {
        this.wish = wish;
    }

    public static Performable fillForm(Wish wish) {
        return Instrumented.instanceOf(FillWishFormWithEmptyName.class).withProperties(wish);
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                Wait.until(WebElementQuestion.the(WishFormPage.inputWishCategory()), WebElementStateMatchers.isEnabled()).forNoLongerThan(10).seconds(),
                Click.on(WishFormPage.inputWishCategory()),
                Click.on(WishFormPage.selectWishCategory()),
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
