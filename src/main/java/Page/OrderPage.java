package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }
    private By viewOrder=By.linkText("VIEW ORDER");
    private By recentOrder=By.tagName("h1");
    private By printOrder=By.linkText("Print Order");
    private By print=By.xpath("//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[1]");
    private By reorder=By.linkText("Reorder");
    public void click_view_order(){
        clickButton(viewOrder);
    }
    public void click_print_order(){
        clickButton(printOrder);
    }
    public String get_recent_order_pendding(){
        return gettext(recentOrder);
    }
    public void click_print(){
        clickButton(print);
    }
    public void click_reorder(){
        clickButton(reorder);
    }

}
