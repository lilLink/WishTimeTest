package ua.wishtime.yukon.ui;

import net.serenitybdd.core.pages.PageObject;

public class HeaderNavigationBar extends PageObject {

    public void selectLogIn(){
        $("*[class=mat-toolbar-row] *[class=main-menu] button[routerlink='/login']").click();
    }

    public void selectFacebook(){
        $("*[class=login-card] button").click();
    }

    public void selectCreateWish(){
        $("*[class=mat-toolbar-row] *[class=main-menu] button").click();
    }

}
