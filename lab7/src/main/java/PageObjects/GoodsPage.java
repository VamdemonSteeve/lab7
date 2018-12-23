package PageObjects;
import Elements.Button;
import Elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Chrome;

public class GoodsPage extends Page {
    @FindBy(xpath = "//*[@id=\"price_container\"]/descendant::button")
    private Button buy;
    @FindBy(xpath = "//*[@id='cart_block65757']/a")
    private Link Cart;
    public CartPage addToCart(){
        buy.click();
        return  new CartPage(Chrome.getDriver().getCurrentUrl());
    }
    public CartPage revealOrder(){
        WebDriverWait wait = new WebDriverWait(Chrome.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cart_block65757']/a")));
        Cart.follow();
        return new CartPage(Chrome.getDriver().getCurrentUrl());
    }
    public GoodsPage(){
        super();
    }
    //*[@id="popup-checkout"]
}
