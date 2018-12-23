package PageObjects;

import Elements.Button;
import Elements.CheckBox;
import Elements.TextField;
import org.openqa.selenium.support.FindBy;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.List;

public class OrderPage extends Page {
    public OrderPage (){
        super();
    }
    @FindBy(xpath = "//*[@id=\"orders\"]/div/div/div[4]/div/div[8]/div/div[2]/input")
    private TextField Surname;
    @FindBy(xpath = "//*[@id=\"orders\"]/div/div/div[4]/div/div[9]/div/div[2]/input")
    private TextField Name;
    @FindBy(xpath = "//*[@id='orders']/div/div/div[2]/div[1]/div[3]/div/div/ul/li[1]/div[2]/div[2]/div[1]/div/div[1]/input")
    private TextField Address;
    @FindBy(xpath = "//*[@id='orders']/div/div/div[3]/div/div[2]/ul/li/label/div/div")
    private List<CheckBox> Payment;
    @FindBy(xpath = "//*[@id='make-order']")
    private Button submit;
    public OrderPage inputNameSurname(String N,String S){
        Name.input(N,true);
        Surname.input(S,true);
        return this;
    }
    public OrderPage inputAddress(String address){
        Address.input(address,true);
        return this;
    }
    public OrderPage setPayment(String payment){
        for(CheckBox checkbox : Payment){
            if(checkbox.getText().equals(payment))
                checkbox.Select();
        }
        return this;
    }
    public boolean CheckOrder(){
        try {
            screen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return submit.isEnabled();
    }
}
