package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By quntity=By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input");
    private By updatebtn=By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button");
    private By errorMessage=By.className("error");
    private By emptybtn=By.className("btn-empty");
    private By cartEmpty=By.className("cart-empty");
    private By proceedCheckout=By.className("btn-proceed-checkout");
    private By price=By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[1]/td[2]/span");
    private By rate=By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span");
    private By totalPrice=By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span");
    private By estimate=By.xpath("//*[@id=\"shipping-zip-form\"]/div/button");
    private By updatetotal=By.name("do");
    private By region=By.id("region_id");
    private By regions=By.name("region");
    private By country=By.id("country");
    private By zip=By.id("postcode");
    private By fixRate=By.name("estimate_method");
    private By coupon=By.name("coupon_code");
    private By apply=By.xpath("//*[@id=\"discount-coupon-form\"]/div/div/div/div/button");
    private By couponApplied=By.className("success-msg");

    Select select;
    public void add_quntity(String qun){
        clearText(quntity);
        sendText(quntity,qun);
        clickButton(updatebtn);
    }

    public String get_error_message(){
        return gettext(errorMessage);
    }
    public void click_empty_cart(){
        clickButton(emptybtn);
    }
    public String get_cart_empty(){
        WebElement errors=driver.findElement(cartEmpty);
        List<WebElement> error=errors.findElements(By.tagName("p"));
        return error.get(0).getText();
    }
    public void click_proceed_checkout(){
        clickButton(proceedCheckout);
    }
    public String get_price(){
        return gettext(price);
    }
    public String get_rate(){
        return gettext(rate);
    }
    public String get_total_price(){
        return gettext(totalPrice);
    }

    public void estimates(String countrys,String reg,String zips){
        selectItem(country,countrys);
        selectItem(region,reg);
        clearText(zip);
        sendText(zip,zips);
        clickButton(estimate);
    }
    public void check_fix_rate(){
        clickButton(fixRate);
    }
    public void click_upadte_total(){
        clickButton(updatetotal);
    }
    public void add_coupon_code(String code){
        clearText(coupon);
        sendText(coupon,code);
        clickButton(apply);
    }

    public String get_success_msg_coupon(){
        return gettext(couponApplied);
    }
}
