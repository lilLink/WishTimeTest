package ua.wishtime.yukon.steps;

import net.thucydides.core.annotations.Step;
import ua.wishtime.yukon.ui.CurrentPage;
import ua.wishtime.yukon.ui.HeaderNavigationBar;
import ua.wishtime.yukon.ui.WishTimeHomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationUser {

    WishTimeHomePage wishTimeHomePage;

    CurrentPage currentPage;

    HeaderNavigationBar headerBar;

    @Step
    public void isOnTheHomePage() {
        wishTimeHomePage.open();
    }

    @Step
    public void navigatesToLogIn() {
        headerBar.selectLogIn();
    }

    @Step
    public void shouldSeePageLogIn(String expectedTitle) {
        assertThat(currentPage.getTitle().equalsIgnoreCase(expectedTitle));
    }

    @Step
    public void navigatesToLogInFromFacebook(){
        headerBar.selectFacebook();
    }

    @Step
    public void navigatesToCreateWish(){
        headerBar.selectCreateWish();
    }
}
