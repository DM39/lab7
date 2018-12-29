import Contexts.*;
import PageObjects.MainPage;
import org.openqa.selenium.support.ui.FluentWait;
import utility.Chrome;
import java.time.Duration;

public class Test {
    public static void main(String args[]){
        try {
            Chrome.initialize();
            FluentWait wait=new FluentWait(Chrome.getDriver());
            wait.withTimeout(Duration.ofMillis(5000));
            wait.pollingEvery(Duration.ofMillis(500));
            Chrome.getDriver().navigate().to("https://bt.rozetka.com.ua/coffee_machines/c80164/filter/");
            Chrome.getDriver().manage().window().maximize();
            Thread.sleep(2000);
            EndingContext.CheckOrder(OrderContext.order(CartContext.Order(MainPageContext.ChooseItem(new MainPage(),
                    "Капельная кофеварка Magio МG-347","Украина",2000)),"Дмитрий","Колдаев","+380665286695","DM39ki@gmail.com"),"Дмитрий","Колдаев");

        }
        catch (Exception e){e.printStackTrace();}
        finally {
            Chrome.getDriver().quit();
        }
    }
}
