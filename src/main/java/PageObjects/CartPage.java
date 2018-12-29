package PageObjects;

import Elements.Button;
import Elements.HTMLlabel;
import Elements.Link;
import org.openqa.selenium.support.FindBy;


public class CartPage extends Page {

    @FindBy(xpath = "//*[@id='cart-popup']/div[2]/div[2]/div[3]/span/span/a")
    private Link ContinuePurchase;
    @FindBy(xpath = "//*[@id='popup-checkout']")
    private Button Order;
    @FindBy(xpath = "//*[@id='cart_payment_info']/div/span[2]/span[1]")
    private HTMLlabel Price;
    public String getPrice(){
        return Price.getText();
    }
    public MerchPage continuePurchase(){
        ContinuePurchase.follow();
        return new MerchPage();
    }
    public ClientPage order(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order.click();
        return new ClientPage();
    }
    public CartPage(String url){
        super();
    }
}
