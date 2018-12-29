package PageObjects;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.*;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utility.Chrome;
import utility.Decorator;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Page {
    public Page(){
        PageFactory.initElements(new Decorator(Chrome.getDriver()),this);
    }

    public void screen() throws IOException{
        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(Chrome.getDriver());
        ImageIO.write(screenshot.getImage(), "PNG", new File("Screenshots/screen.png"));
    }

}

