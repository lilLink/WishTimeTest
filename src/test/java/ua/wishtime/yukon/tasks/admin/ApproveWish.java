package ua.wishtime.yukon.tasks.admin;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.ui.AdminPage;

public class ApproveWish implements Task {

    private final String username;

    private final Wish wish;

    public ApproveWish(String username, Wish wish) {
        this.username = username;
        this.wish = wish;
    }

    public static Performable approve(String username, Wish wish) {
        return Instrumented.instanceOf(ApproveWish.class).withProperties(username,wish);
    }

    @Override
    public <T extends Actor> void performAs(T admin) {

        admin.attemptsTo(
                Enter.theValue(wish.getWishName()).into(AdminPage.inputWishName()),
                Wait.until(WebElementQuestion.the(AdminPage.inputWishName()), WebElementStateMatchers.isEnabled()).forNoLongerThan(10).seconds(),
                Click.on(AdminPage.inputStatus()),
                Click.on(AdminPage.selectOnModeration()),
                Ensure.that(AdminPage.rowWishName()).text().isEqualTo(wish.getWishName()),
                Ensure.that(AdminPage.rowUserName()).text().isEqualTo(username),
                Click.on(AdminPage.selectWish()),
                Click.on(AdminPage.buttonApprove())
        );
    }
}
