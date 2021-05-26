package ua.wishtime.yukon.features.navigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.net.ntp.TimeStamp;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ua.wishtime.yukon.model.Address;
import ua.wishtime.yukon.model.RegisteredUser;
import ua.wishtime.yukon.model.Wish;
import ua.wishtime.yukon.tasks.*;
import ua.wishtime.yukon.tasks.admin.AdminLogOut;
import ua.wishtime.yukon.tasks.admin.ApproveWish;
import ua.wishtime.yukon.tasks.fill.FillWishForm;
import ua.wishtime.yukon.ui.NavigationBar;

import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

@RunWith(SerenityRunner.class)
public class PreparingWish {

    @Managed
    WebDriver browser;

    private String username = "Вадим Птицын";

    private Address address = new Address("Чернівці","Головна 204В","2");

    private Wish wish = new Wish("Телефон" + TimeStamp.getCurrentTime(),"Техніка","https://rozetka.com.ua/ua/samsung_galaxy_s21_grey_sm_g991bzadsek/p272629166/","26999","Птіцин Вадим Юрійович","954644695",address);


    //Введіть реальні дані адміна для входу через Facebook
    private RegisteredUser admin = new RegisteredUser("Admin","","");

    //Введіть реальні дані користувача для входу через Facebook
    private RegisteredUser person = new RegisteredUser("User","","");

    @Before
    public void initSetup(){

        person.can(BrowseTheWeb.with(browser));

        admin.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void shouldBeAbleToApproveAWish(){

        when(person).attemptsTo(NavigateTo.logInFromFacebook("Увійти"));

        then(person).attemptsTo(LogIn.withCredential());

        then(person).attemptsTo(CreateWish.create("Створити бажання"));

        then(person).attemptsTo(FillWishForm.fillForm(wish));

        then(person).attemptsTo(Click.on(NavigationBar.buttonSendingToModeration()));

        then(person).attemptsTo(LogOut.exit());

        then(admin).attemptsTo(NavigateTo.logInFromFacebook("Увійти"));

        then(admin).attemptsTo(LogIn.withCredential());

        then(admin).attemptsTo(ApproveWish.approve(username,wish));

        then(admin).attemptsTo(AdminLogOut.exit());
    }

    @After
    public void clear(){
        when(person).attemptsTo(NavigateTo.logInFromFacebook("Увійти"));

        then(person).attemptsTo(LogIn.withCredential());

        then(person).attemptsTo(DeleteWish.delete());
    }

}
