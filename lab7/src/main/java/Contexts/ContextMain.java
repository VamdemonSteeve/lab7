package Contexts;

import PageObjects.GoodsPage;
import PageObjects.MainPage;
import PageObjects.Page;
import sun.applet.Main;
import utility.Chrome;

import java.sql.Driver;

public class ContextMain {
private ContextMain(){}
private static MainPage filterPrice(MainPage mainpage , int minimal, int maximal) throws InterruptedException {
mainpage=mainpage.setMaximalPrice(maximal);
//mainpage.MaximalPrice.clear();
//mainpage.setMaximalPrice(maximal);
mainpage=mainpage.facility();
Thread.sleep(2000);
mainpage=mainpage.setMinimalPrice(minimal);
mainpage.MaximalPrice.sendKeys("");
return mainpage.submit();

}
private static MainPage filterCountry(MainPage mainPage,String country){
    return mainPage.setCountry(country);
}
public static GoodsPage ChooseItem(MainPage mainPage, String name, String country, int minimal, int maximal) throws InterruptedException {
    Thread.sleep(2000);
    mainPage=filterCountry(   filterPrice(mainPage,minimal,maximal),country);
    Thread.sleep(3000);
    return mainPage.selectGood(name);
}
}
