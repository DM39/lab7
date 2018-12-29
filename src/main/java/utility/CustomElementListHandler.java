package utility;

import Elements.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CustomElementListHandler implements InvocationHandler{
    private final ElementLocator locator;
    private final Class<Element> clazz;

    CustomElementListHandler(ElementLocator locator, Class<Element> clazz) {
        this.locator = locator;
        this.clazz = clazz;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<WebElement> elements = locator.findElements();
        List<Element> customs = new ArrayList<Element>();
        for (WebElement element : elements)
            customs.add(clazz.getConstructor(WebElement.class).newInstance(element));
        try {
            return method.invoke(customs, objects);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
