package PageObjects;
import Elements.Button;
import Elements.Link;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import utility.Chrome;

public class MerchPage extends Page {
    @FindBy(xpath = "//*[@id=\"price_container\"]/div[2]/div/form/span/span/button")
    private Button buy;
    @FindBy(xpath = "//*[@id=\"cart_block19526\"]/a/span")
    private Link Cart;

    public CartPage addToCart() {
        buy.click();
        return new CartPage(Chrome.getDriver().getCurrentUrl());
    }

    public CartPage goToCart() {
        Cart.follow();
        return new CartPage(Chrome.getDriver().getCurrentUrl());
    }

    public MerchPage(){
        super();
    }
}
