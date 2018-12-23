package PageObjects;

import Elements.Button;
import Elements.Link;
import Elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.Chrome;
import utility.Decorator;
import utility.Waiter;

import java.util.List;

public class MainPage extends Page {
    @FindBy(xpath = "//*[@id='rz-search']/form/div[1]/div[2]/input")
    private TextField SearchBar;
    @FindBy(xpath = "//*[@id=\"26819[min]\"]")
    public TextField MinimalPrice;
    @FindBy(xpath="//*[@id=\"26819[max]\"]")
    public TextField MaximalPrice;
    @FindBy(xpath = "//*[@id='submitprice']")
    public Button ok;
    @FindBy(xpath = "//*[@id='sort_strana-proizvoditel-97388']/descendant::a")
    private List<Link> Producer;
    @FindBy(xpath = "//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div[3]/a")
    private List<Link> Goods;
    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]/div[13]/div[2]/a[1]")
    private Link More;
    @FindBy(xpath = "//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div/div/descendant::button")
    private List<Button> buttons;
    public MainPage(){
        super();
    }
    public int getMinimalPrice(){
        return Integer.parseInt(MinimalPrice.getText());
    }
    public MainPage setMinimalPrice(int price){
        MinimalPrice.clear();
        MinimalPrice.input(Integer.toString(price),true);
        return this;
    }
    public MainPage setMaximalPrice(int price){
        MaximalPrice.clear();
        MaximalPrice.input(/*Keys.chord(Keys.COMMAND,"x")+*/Integer.toString(price),false);
        return this;
    }
    public MainPage setCountry(String country){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        More.follow();
        Waiter.wait.until(o->{return ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div[3]/a"));});
        for(Link link : Producer){
            //System.out.println(link.findElement(By.xpath("span/i")).getText());
            if(link.findElement(By.xpath("span/i")).getText().equals(country)) {
                link.follow();
                break;
            }
        }
        return this;
    }
    public GoodsPage selectGood(String name){
        for(Link link : Goods){
            //System.out.println(link.getText());
            if(link.getText().equals(name)) {
                //System.out.println(link.getText());
                //System.out.println("FOUND!");
                link.follow();
                break;
            }
        }
        return new GoodsPage();
    }
    public MainPage submit(){
        ok.click();
        return this;
    }
    public MainPage facility(){
        ok.submit();
        return this;
    }
}
