package ua.wishtime.yukon.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import ua.wishtime.yukon.model.RegisteredUser;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.ui.WishFormPage;

import javax.swing.text.MaskFormatter;
import java.text.DecimalFormat;
import java.text.ParseException;

public class CheckingCorrectCreatedWish implements Task {

    private final Wish wish;

    public CheckingCorrectCreatedWish(Wish wish) {
        this.wish = wish;
    }

    public static Performable checking(Wish wish) {
        return Instrumented.instanceOf(CheckingCorrectCreatedWish.class).withProperties(wish);
    }

    private String phoneNumber(String phone) {

        String phoneMask= "+(380) ##-###-####";

        MaskFormatter maskFormatter= null;
        try {
            maskFormatter = new MaskFormatter(phoneMask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        maskFormatter.setValueContainsLiteralCharacters(false);
        try {
            return maskFormatter.valueToString(phone) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return phone;
    }

    @Override
    public <T extends Actor> void performAs(T user) {

        user.attemptsTo(
                Ensure.that(WishFormPage.inputWishName()).value().isEqualTo(wish.getWishName()),
                Ensure.that(WishFormPage.inputCategory()).text().isEqualTo(wish.getWishCategory()),
                Ensure.that(WishFormPage.inputLinkToProduct()).value().isEqualTo(wish.getLinkToProduct()),
                Ensure.that(WishFormPage.inputFullName()).value().isEqualTo(wish.getFullName()),
                Ensure.that(WishFormPage.inputPhoneNumber()).value().isEqualTo(phoneNumber(wish.getPhoneNumber())),
                Ensure.that(WishFormPage.inputPrice()).value().isEqualTo(wish.getPrice()),
                Ensure.that(WishFormPage.inputAddress()).text().isEqualTo(wish.getAddress().getCity() + ", "
                        + wish.getAddress().getStreet() + ", " + wish.getAddress().getHouseNumber() + ","),
                Ensure.that(WishFormPage.inputDescription()).text().isEmpty(),
                Ensure.that(WishFormPage.inputImage()).text().isNullOrEmpty()
        );
    }

    private RegisteredUser registered(Actor actor){
        return (RegisteredUser) actor;
    }

}
