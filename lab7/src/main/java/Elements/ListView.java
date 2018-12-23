package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ListView extends element {
    private final Select choose=new Select(super.getElement());
    public ListView(WebElement element){
        super(element);
    }
    public void selectByValue(String value){
        if(!super.isSelected())
        choose.selectByValue(value);
    }
    public void selectByVisibleText(String text){
        if(!super.isSelected())
        choose.selectByVisibleText(text);
        }
    public void selectByIndex (int index){
            if(!super.isSelected())
            choose.selectByIndex(index);
        }
    public List<WebElement> getOptions(){
        return choose.getOptions();
    }
    public boolean isMultiple(){
        return choose.isMultiple();
    }
    @Override
    public void submit(){return;}
    @Override
    public void sendKeys(CharSequence...sequences){return;}
    @Override
    public void clear(){choose.deselectAll();}
    }


