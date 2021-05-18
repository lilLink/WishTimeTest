package ua.wishtime.yukon.features.navigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.net.ntp.TimeStamp;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ua.wishtime.yukon.model.Address;
import ua.wishtime.yukon.model.RegisteredUser;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.tasks.*;
import ua.wishtime.yukon.tasks.fill.*;
import ua.wishtime.yukon.ui.NavigationBar;
import ua.wishtime.yukon.ui.WishFormPage;


import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class WhenBrowsingWish {

    @Managed(driver = "chrome")
    WebDriver browser;

    private String sum = "20";

    private Address address = new Address("Чернівці","Головна 204В","2");

    private Wish wish = new Wish("Телефон" + TimeStamp.getCurrentTime(),"Техніка","https://rozetka.com.ua/ua/samsung_galaxy_s21_grey_sm_g991bzadsek/p272629166/","26999","Птіцин Вадим Юрійович","954644695",address);

    private Wish notValidWish = new Wish("!23s","","rozetka.com.ua/ua/samsung_galaxy_s21_grey_sm_g991bzadsek/p272629166/","12","123","23412", address);

    //Введіть реальні дані користувача для входу через Facebook
    private RegisteredUser person = new RegisteredUser("User","","");

    @Before
    public void initSetup() {
        person.can(BrowseTheWeb.with(browser));

        when(person).attemptsTo(NavigateTo.logInFromFacebook("Увійти"));

        then(person).attemptsTo(LogIn.withCredential());
    }

    @Test
    public void shouldBeAbleToCreateAndEditAWish(){

        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishForm.fillForm(wish));

        then(person).attemptsTo(NavigateToPreModeration.navigateToPreModeration());

        then(person).attemptsTo(NavigateToEditWish.navigateToEdit(wish));

        then(person).attemptsTo(CheckingCorrectCreatedWish.checking(wish));

    }

    @Test
    @Ignore
    public void shouldBeAbleToDonateInWish(){
        when(person).attemptsTo(NavigateToDonate.navigateToDonate());

        then(person).attemptsTo(DonateInWish.donate(sum));

        then(person).should(seeThat(WebElementQuestion.the(NavigationBar.successDonate()),
                WebElementStateMatchers.containsText("Дякуємо за пожертвування")));
    }

    @Test
    @Ignore
    public void shouldBeNotAbleToDonateWithEmptyAmountInWish(){
        when(person).attemptsTo(NavigateToDonate.navigateToDonate());

        then(person).should(seeThat(WebElementQuestion.the(NavigationBar.buttonDonate()),
                WebElementStateMatchers.isNotEnabled()));
    }

    @Test
    public void shouldBeNotAbleToCreateWithEmptyCategoryAWish(){
        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishFormWithEmptyCategory.fillForm(wish));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.saveWish()),
                WebElementStateMatchers.isNotEnabled()));
    }

    @Test
    public void shouldBeNotAbleToCreateWithEmptyNameAWish(){
        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishFormWithEmptyName.fillForm(wish));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.saveWish()),
                WebElementStateMatchers.isNotEnabled()));
    }

    @Test
    public void shouldBeNotAbleToCreateWithEmptyPriceAWish(){
        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishFormWithEmptyPrice.fillForm(wish));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.saveWish()),
                WebElementStateMatchers.isNotEnabled()));
    }

    @Test
    public void shouldBeNotAbleToCreateWithEmptyLinkAWish(){
        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishFormWithEmptyLink.fillForm(wish));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.saveWish()),
                WebElementStateMatchers.isNotEnabled()));
    }

    @Test
    public void shouldBeNotAbleToCreateWithEmptyFullNameAWish(){
        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishFormWithEmptyFullName.fillForm(wish));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.saveWish()),
                WebElementStateMatchers.isNotEnabled()));
    }

    @Test
    public void shouldBeNotAbleToCreateWithEmptyPhoneAWish(){
        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishFormWithEmptyPhone.fillForm(wish));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.saveWish()),
                WebElementStateMatchers.isNotEnabled()));
    }

    @Test
    public void shouldBeNotAbleToCreateWithNotValidDataAWish(){
        when(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishFormWithNotValidData.fillForm(notValidWish));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.errorPrice()),
                WebElementStateMatchers.containsText("Має бути більше 20 грн")));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.errorLink()),
                WebElementStateMatchers.containsText("Невірна адреса ресурсу")));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.errorPhone()),
                WebElementStateMatchers.containsText("Недійсний номер телефону")));

        then(person).should(seeThat(WebElementQuestion.the(WishFormPage.saveWish()),
                WebElementStateMatchers.isNotEnabled()));
    }
}
