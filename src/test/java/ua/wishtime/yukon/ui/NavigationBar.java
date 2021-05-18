package ua.wishtime.yukon.ui;

import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {


    public static Target logIn() {
        return Target.the("Увійти")
                .locatedBy("//div[@class = 'main-menu']/button[@routerlink='/login']");
    }

    public static Target cookieButton(){
        return Target.the("")
                .locatedBy("//div[@class='button']/button[@class='mat-focus-indicator mat-stroked-button mat-button-base']");
    }

    public static Target checkboxLogin(){
        return Target.the("")
                .locatedBy("//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");
    }

    public static Target logInFromFacebook() {
        return Target.the("Увійти через Facebook")
                .locatedBy("//div[@class='button']");
    }

    public static Target createWish(){
        return Target.the("Створити бажання")
                .locatedBy("//div[@class = 'main-menu']/button");
    }

    public static Target selectAvatar(){
        return Target.the("Профіль")
                .locatedBy("//div[@class='owner ng-star-inserted']");
    }

    public static Target selectYourPage(){
        return Target.the("Моя сторінка")
                .locatedBy("//button[@type = 'submit']");
    }


    public static Target selectPreModerationWish() {
        return Target.the("На премодерації")
                .locatedBy("//div[contains(text(),'На премодерації')]");
    }


    public static Target selectEditWish() {
        return Target.the("Редагувати бажання")
                .locatedBy("//button[@class='mat-focus-indicator tools mat-mini-fab mat-button-base mat-primary']//img[@src='./assets/icons/ic_edit.svg']");
    }

    public static Target selectModerationWish() {
        return Target.the("На модерації")
                .locatedBy("//div[contains(text(),'На модерації')]");
    }


    public static Target dropDownPreModeration() {
        return Target.the("Список бажань в премодерації")
                .locatedBy("//div[@class='mat-expansion-panel-body ng-tns-c171-11']/div[@class='wish ng-star-inserted']/div[@class='text ng-star-inserted']");
    }

    public static Target selectWish() {
        return Target.the("Бажаня")
                .locatedBy("//app-wish-list//app-wish-card[1]//img[@alt='photo of wish']");
    }

    public static Target selectDonate() {
        return Target.the("Пожертвувати")
                .locatedBy("//div[@class='right-menu']/div[@class='input-money-button']/button");
    }

    public static Target inputAmount() {
        return Target.the("Сума внеску")
                .locatedBy("//input[@formcontrolname='sum']");
    }

    public static Target buttonDonate() {
        return Target.the("Внести")
                .locatedBy("//button[@class='mat-focus-indicator donate mat-raised-button mat-button-base mat-primary']");
    }

    public static Target successDonate() {
        return Target.the("Подяка")
                .locatedBy("//p[@class='title ng-star-inserted']");
    }

    public static Target buttonLogOut() {
        return Target.the("Вийти")
                .locatedBy("//button[@class='mat-focus-indicator log-out mat-menu-item']");
    }

    public static Target buttonSendingToModeration() {
        return Target.the("Відправити на модерацію")
                .locatedBy("//button[@class='mat-focus-indicator mat-stroked-button mat-button-base mat-primary']");
    }

    public static Target buttonDeleteWish() {
        return Target.the("Видалити")
                .locatedBy("//div[@class='button-with-description']//button[@class='mat-focus-indicator tools mat-mini-fab mat-button-base mat-primary']");
    }

    public static Target okButtonDelete() {
        return Target.the("Ок")
                .locatedBy("//button[@class='mat-focus-indicator mat-flat-button mat-button-base']");
    }
}
