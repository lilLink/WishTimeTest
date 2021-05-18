package ua.wishtime.yukon.ui;

import net.serenitybdd.screenplay.targets.Target;

public class WishFormPage {

    public static Target addNewAddress() {
        return Target.the("Додати адресу")
                .locatedBy("//div[@class='add-address']/p");
    }

    public static Target saveWish() {
        return Target.the("Зберегти")
                .locatedBy("//button[@type='submit']");
    }

    public static Target inputWishName() {
        return Target.the("Вкажіть назву свого подарунка або свята")
                .locatedBy("//input[@formcontrolname='title']");
    }

    public static Target inputWishCategory() {
        return Target.the("Оберіть категорію")
                .locatedBy("//mat-select[@formcontrolname='wishCategory']");
    }

    public static Target selectWishCategory() {
        return Target.the("Техніка")
                .locatedBy("//span[contains(text(),'Техніка')]");
    }

    public static Target inputLinkToProduct() {
        return Target.the("Посилання на товар")
                .locatedBy("//input[@formcontrolname='link']");
    }

    public static Target inputPrice() {
        return Target.the("Вартість")
                .locatedBy("//div[@class='price-currency']//input");
    }

    public static Target inputFullName() {
        return Target.the("Отримувач")
                .locatedBy("//input[@formcontrolname='recipientFullName']");
    }

    public static Target inputPhoneNumber() {
        return Target.the("Номер телефону отримувача")
                .locatedBy("//input[@formcontrolname='recipientPhoneNumber']");
    }

    public static Target inputCity() {
        return Target.the("Населений пункт")
                .locatedBy("//input[@formcontrolname='settlement']");
    }

    public static Target inputStreet() {
        return Target.the("Вулиця")
                .locatedBy("//input[@formcontrolname='street']");
    }

    public static Target inputHouseNumber() {
        return Target.the("Будинок")
                .locatedBy("//input[@formcontrolname='build']");
    }

    public static Target saveAddress() {
        return Target.the("Зберегти")
                .locatedBy("//div[@class='buttons-group']//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']");
    }

    public static Target selectNameWish(String name) {
        return Target.the("Бажання")
                .locatedBy("//span/a[contains(text(), '" + name + "' )]");
    }

    public static Target inputAddress() {
        return Target.the("Адрес")
                .locatedBy("//mat-select[@formcontrolname='addressId']//span//span[contains(text(),'')]");
    }

    public static Target inputCategory() {
        return Target.the("Категорія")
                .locatedBy("//mat-select[@formcontrolname='wishCategory']//span//span[contains(text(),'')]");
    }

    public static Target inputDescription(){
        return Target.the("Опис")
                .locatedBy("//textarea");
    }

    public static Target inputImage(){
        return Target.the("Зображення")
                .locatedBy("//div[@class='image-container']//input");
    }

    public static Target errorLink() {
        return Target.the("Error link")
                .locatedBy("//div[@class='link-div']//mat-error");
    }

    public static Target errorPrice() {
        return Target.the("Error price")
                .locatedBy("//div[@class='price-currency']//mat-error");
    }

    public static Target errorPhone() {
        return Target.the("Error phone")
                .locatedBy("//div[@class='phone-div']//mat-error");
    }
}
