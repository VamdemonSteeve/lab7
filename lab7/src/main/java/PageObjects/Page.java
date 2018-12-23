package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.*;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utility.Chrome;
import utility.Decorator;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Page {
    public Page(){
        PageFactory.initElements(new Decorator(Chrome.getDriver()),this);
    }
    public void screenShot(String key) throws IOException {
        if(!Chrome.getDriver().findElements(By.linkText(key)).isEmpty()){
            Screenshot screenshot=new AShot().takeScreenshot(Chrome.getDriver(),Chrome.getDriver().findElement(By.linkText(key)));
            ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\key.png"));
            return;
        }
        if(!Chrome.getDriver().findElements(By.xpath(key)).isEmpty()){
            Screenshot screenshot=new AShot().takeScreenshot(Chrome.getDriver(),Chrome.getDriver().findElement(By.xpath(key)));
            ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\key.png"));
            return;
        }
        if(!Chrome.getDriver().findElements(By.tagName(key)).isEmpty()){
            Screenshot screenshot=new AShot().takeScreenshot(Chrome.getDriver(),Chrome.getDriver().findElement(By.tagName(key)));
            ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\key.png"));
            return;
        }
        if(!Chrome.getDriver().findElements(By.className(key)).isEmpty()){
            Screenshot screenshot=new AShot().takeScreenshot(Chrome.getDriver(),Chrome.getDriver().findElement(By.className(key)));
            ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\key.png"));
            return;
        }
        if(!Chrome.getDriver().findElements(By.cssSelector(key)).isEmpty()){
            Screenshot screenshot=new AShot().takeScreenshot(Chrome.getDriver(),Chrome.getDriver().findElement(By.cssSelector(key)));
            ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\key.png"));
            return;
        }
        if(!Chrome.getDriver().findElements(By.id(key)).isEmpty()){
            Screenshot screenshot=new AShot().takeScreenshot(Chrome.getDriver(),Chrome.getDriver().findElement(By.id(key)));
            ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\key.png"));
            return;
        }
        if(!Chrome.getDriver().findElements(By.partialLinkText(key)).isEmpty()){
            Screenshot screenshot=new AShot().takeScreenshot(Chrome.getDriver(),Chrome.getDriver().findElement(By.partialLinkText(key)));
            ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\key.png"));
            return;
        }
    }
    public void screen() throws IOException{
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(Chrome.getDriver());
        ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots\\url"));
    }

}

