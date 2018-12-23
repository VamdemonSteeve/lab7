package PageObjects;

import Elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.Chrome;
import utility.Waiter;

public class ClientDataPage extends Page {
    public ClientDataPage() {
        super();
    }

    @FindBy(xpath = "//*[@id='purchases_block']/div[1]/div[3]/a")
    private Link Cart;
    @FindBy(xpath = "//*[@id='purchases_block']/div[1]/div[1]/div[5]/div[2]")
    private HTMLlabel Price;
    @FindBy(id = "reciever_name")
    private TextField NameSurname;
    @FindBy(id = "suggest_locality")
    private TextField City;
    @FindBy(id = "reciever_phone")
    private TextField Phone;
    @FindBy(id = "reciever_email")
    private TextField Email;
    @FindBy(xpath = "//*[@id='step_contacts']/div/div[1]/div[2]/div/span/button")
    private Button Forward;

    public CartPage cart() {
        Cart.follow();
        return new CartPage(Chrome.getDriver().getCurrentUrl());
    }

    public String getPrice() {
        return Price.getText();
    }

    public ClientDataPage inputNameSurname(String Name, String Surname) {
        NameSurname.input(Surname + " " + Name, false
        );
        return this;
    }

    public ClientDataPage inputPhone(String phone) {
        Phone.input(phone, false);
        return this;
    }

    public ClientDataPage inputEmail(String email) {
        Email.input(email, false);
        return this;
    }

    public ClientDataPage setCity(String city) {
        Chrome.getDriver().findElement(By.xpath("//*[@id=\"tip_for_input\"]")).click();
        for (WebElement cities : Chrome.getDriver().findElements(By.xpath("//*[@id=\"step_contacts\"]/div/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/div/ul/li"))) {
            if (cities.getText().equals(city)) {
                cities.click();
            }
        }
        Chrome.getDriver().findElement(By.xpath("//*[@id=\"tip_for_input\"]")).click();
        return this;
    }

    public boolean isEnabled() {
        return Forward.isEnabled();
    }

    public OrderPage submit() {
        Waiter.wait.until(o->{return ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='step_contacts']/div/div[1]/div[2]/div/span/button"));});
        Forward.click();
        System.out.println("clicked");
        return new OrderPage();
    }
}
