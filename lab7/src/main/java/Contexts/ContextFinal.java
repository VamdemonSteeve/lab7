package Contexts;

import PageObjects.OrderPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Chrome;

public class ContextFinal {
    private ContextFinal(){}
    private static void setParametres(OrderPage page,String Name,String Surname){
        page.inputNameSurname(Name,Surname);
    }
    public static void CheckOrder(OrderPage page,String Name,String Surname){
        setParametres(page,Name,Surname);
        System.out.println(page.CheckOrder());
    }
}
