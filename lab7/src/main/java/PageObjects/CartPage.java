package PageObjects;

import Elements.Button;
import Elements.HTMLlabel;
import Elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Chrome;
import utility.Waiter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.function.Function;

public class CartPage extends Page {
@FindBy(xpath = "//*[@id='cart-popup']/div[2]/div[2]/div[3]/span/span/a")
private Link ContinuePurchase;
@FindBy(id = "popup-checkout")
private Button Order;
@FindBy(xpath = "//*[@id='cart_payment_info']/div/span[2]/span[1]")
private HTMLlabel Price;
public String getPrice(){
    return Price.getText();
}
public GoodsPage continuePurchase(){
    ContinuePurchase.follow();
    return new GoodsPage();
}
public ClientDataPage order(){
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //new WebDriverWait(Chrome.getDriver(),2000).until(ExpectedConditions.presenceOfElementLocated(By.id("popup-checkou")));
    Order.click();
    return new ClientDataPage();
}
public CartPage(String URL){
    super();
}
}
