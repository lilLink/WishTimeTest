package ua.wishtime.yukon.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AdminPage {
    public static Target inputStatus() {
        return Target.the("Статус")
                .locatedBy("//mat-select[@id='mat-select-0']");
    }

    public static Target inputUserName() {
        return Target.the("Власник")
                .locatedBy("//input[@id='mat-input-1']");
    }

    public static Target selectWish() {
        return Target.the("Бажання")
                .locatedBy("//tr[@class='mat-row cdk-row ng-star-inserted'][1]/td[@class='mat-cell cdk-cell pointer cdk-column-title mat-column-title ng-star-inserted']");
    }

    public static Target inputWishName() {
        return Target.the("Назва бажання")
                .locatedBy("//input[@id='mat-input-0']");
    }

    public static Target buttonApprove() {
        return Target.the("Підтвердити")
                .locatedBy("//button//span[contains(text(),'Підтвердити')]");
    }

    public static Target selectOnModeration() {
        return Target.the("На модерації")
                .locatedBy("//mat-option[@id='mat-option-5']");
    }

    public static Target rowWishName() {
        return Target.the("Власник")
                .locatedBy("//td[@class='mat-cell cdk-cell pointer cdk-column-title mat-column-title ng-star-inserted'][1]");
    }

    public static Target rowUserName() {
        return Target.the("Бажання")
                .locatedBy("//td[@class='mat-cell cdk-cell cdk-column-author mat-column-author ng-star-inserted'][1]");
    }

    public static Target buttonExit() {
        return Target.the("Вийти")
                .locatedBy("//button//span[contains(text(),'Вийти')]");
    }
}
