package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class CompareWindowPage extends BasePage{
    public CompareWindowPage(WebDriver driver) {
        super(driver);
    }
    private By title=By.tagName("h1");
    private By product1=By.className("product-name");



    public String get_title(){
        return gettext(title);
    }
    public String get_product1(){
        return gettextofelements(product1,0);
    }
    public String get_product2(){
        return gettextofelements(product1,1);
    }

}
