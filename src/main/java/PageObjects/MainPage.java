package PageObjects;

import Elements.Button;
import Elements.Link;
import Elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.Waiter;

import java.util.List;

public class MainPage extends Page {
    @FindBy(xpath = "//*[@id='rz-search']/form/div[1]/div[2]/input")
    private TextField SearchBar;
    @FindBy(id="price[max]")
    public TextField MaximalPrice;
    @FindBy(id = "submitprice")
    public Button ok;
    @FindBy(xpath = "//*[@id=\"filter_strana-sborki-103324_673870\"]/label/a/span/i[1]")
    private List<Link> Producer;
    @FindBy(xpath = "//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div[3]/a")
    private List<Link> Goods;
    @FindBy(xpath = "//*[@id=\"filter_parameters_form\"]/div[16]/div[2]/a[1]")
    private Link More;
    @FindBy(xpath = "//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div/div/descendant::button")
    private List<Button> buttons;
    public MainPage(){
        super();
    }
    public MainPage setMaximalPrice(int price){
        MaximalPrice.clear();
        MaximalPrice.input(Integer.toString(price),false);
        return this;
    }
    public MainPage setCountry(String country){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        More.follow();
        Waiter.wait.until(o->{return ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"catalog_goods_block\"]/div/div/div[1]/div/div/div/div[3]/a"));});
        for(Link link : Producer){
            if(link.findElement(By.xpath("//*[@id=\"filter_strana-sborki-103324_673870\"]/label/a/span/i[1]")).getText().equals(country)) {
                link.follow();
                break;
            }
        }
        return this;
    }
    public MerchPage selectGood(String name){
        for(Link link : Goods){
            if(link.getText().equals(name)) {
                link.follow();
                break;
            }
        }
        return new MerchPage();
    }
    public MainPage submit(){
        ok.click();
        return this;
    }
    public MainPage facility(){
        ok.submit();
        return this;
    }
}
