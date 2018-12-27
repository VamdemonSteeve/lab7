import Contexts.ContextCart;
import Contexts.ContextFinal;
import Contexts.ContextMain;
import Contexts.ContextOrder;
import PageObjects.GoodsPage;
import PageObjects.MainPage;
import org.openqa.selenium.support.ui.FluentWait;
import utility.Chrome;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String args[]){
        try {
            Chrome.initialize();
            FluentWait wait=new FluentWait(Chrome.getDriver());
            wait.withTimeout(Duration.ofMillis(5000));
            wait.pollingEvery(Duration.ofMillis(500));
            Chrome.getDriver().navigate().to("https://rozetka.com.ua/protein/c273294/");
            Chrome.getDriver().manage().window().maximize();
            Thread.sleep(2000);
            ContextFinal.CheckOrder(ContextOrder.order(ContextCart.Order(ContextMain.ChooseItem(new MainPage(),"Протеин Ванситон Ультра-Про 900 г","Украина",200,2000)),"Mister","Trickster","Киев","0988773356","vamdemonsteeve@gmai.com"),"Mister","Trickster");

        }
        catch (Exception e){e.printStackTrace();}
        finally {
            Chrome.getDriver().quit();
        }
    }
}
