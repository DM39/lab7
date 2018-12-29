package Elements;

import org.openqa.selenium.WebElement;

public class TextField extends Element {

    public TextField(WebElement element) {
        super(element);
    }

    public void input(String s, boolean i) {
        if (i) {
            sendKeys(s);
        } else {
            clear();
            sendKeys(s);
        }
    }
}