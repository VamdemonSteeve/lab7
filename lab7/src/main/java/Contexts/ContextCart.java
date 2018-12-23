package Contexts;

import PageObjects.CartPage;
import PageObjects.ClientDataPage;
import PageObjects.GoodsPage;
import utility.Chrome;
import utility.Waiter;

import java.util.concurrent.TimeUnit;

public class ContextCart {
    private ContextCart(){}
    private static ClientDataPage MakeOrder(CartPage page)throws InterruptedException{
        return page.order();
    }
    public static ClientDataPage Order(GoodsPage page) throws InterruptedException {
        Thread.sleep(1000);
        //System.out.println("here");
        return MakeOrder(page.addToCart());
    }
}
