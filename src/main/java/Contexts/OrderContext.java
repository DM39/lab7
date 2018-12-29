package Contexts;

import PageObjects.ClientPage;
import PageObjects.OrderPage;
import org.openqa.selenium.support.ui.FluentWait;
import utility.Chrome;
import java.time.Duration;


public class OrderContext {
    private OrderContext(){}
    public static OrderPage order(ClientPage page, String name, String surname, String phone, String email) throws InterruptedException {
        FluentWait wait=new FluentWait(Chrome.getDriver());
        wait.withTimeout(Duration.ofMillis(5000));
        page.inputNameSurname(name,surname);
        Thread.sleep(1000);
        page.inputPhone(phone);
        page.inputEmail(email);
        Thread.sleep(2000);
        return page.submit();
    }
}
