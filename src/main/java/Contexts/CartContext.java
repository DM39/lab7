package Contexts;

import PageObjects.CartPage;
import PageObjects.ClientPage;
import PageObjects.MerchPage;


public class CartContext {
    private CartContext(){}
    private static ClientPage MakeOrder(CartPage page)throws InterruptedException{
        return page.order();
    }
    public static ClientPage Order(MerchPage page) throws InterruptedException {
        Thread.sleep(1000);
        return MakeOrder(page.addToCart());
    }
}
