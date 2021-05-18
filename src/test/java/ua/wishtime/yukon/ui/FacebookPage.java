package ua.wishtime.yukon.ui;

import net.serenitybdd.screenplay.targets.Target;

public class FacebookPage {
    public static Target selectDropdownLangRU() {
        return Target.the("Аккаунт")
                .locatedBy("//div[@aria-label='Аккаунт']");
    }

    public static Target selectDropdownLangUA(){
        return Target.the("Обліковий запис")
                .locatedBy("//div[@aria-label='Обліковий запис']");
    }

    public static Target buttonExitLangRU() {
        return Target.the("Выйти")
                .locatedBy("//div[@class='qzhwtbm6 knvmm38d']//span[contains(text(),'Выйти')]");
    }

    public static Target buttonExitLangUA() {
        return Target.the("Вийти")
                .locatedBy("//div[@class='qzhwtbm6 knvmm38d']//span[contains(text(),'Вийти')]");
    }
}
