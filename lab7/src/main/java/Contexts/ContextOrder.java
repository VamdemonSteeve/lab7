package Contexts;

import PageObjects.ClientDataPage;
import PageObjects.OrderPage;
import org.openqa.selenium.support.ui.FluentWait;
import utility.Chrome;

import java.time.Duration;
import java.util.function.Function;

public class ContextOrder {
    private ContextOrder(){}
    public static OrderPage order(ClientDataPage page, String Name, String Surname, String City, String Phone, String email) throws InterruptedException {
        FluentWait wait=new FluentWait(Chrome.getDriver());
        wait.withTimeout(Duration.ofMillis(9000));
        page.inputNameSurname(Name,Surname);
        Thread.sleep(1000);
        page.inputPhone(Phone);
        page.inputEmail(email);
        Thread.sleep(5000);
        return page.submit();
    }
}
