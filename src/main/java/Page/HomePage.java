package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By pagetitle= By.className("page-title");
    private By mobilefield=By.linkText("MOBILE");
    private By tvfield=By.linkText("TV");
    private  By myAccount=By.linkText("MY ACCOUNT");
    private By msgRegister=By.className("success-msg");
    private By myWishlist=By.linkText("MY WISHLIST");
    private By myOrder=By.linkText("MY ORDERS");

    private By Account=By.xpath("//div[@class=\"account-cart-wrapper\"]//a");
    private By logout=By.linkText("Log Out");



    public String get_page_title(){

        return gettext(pagetitle);
    }
    public void click_mobile_field(){
        clickButton(mobilefield);
    }
    public void click_tv_field(){
      clickButton(tvfield);
    }
    public void click_My_account() throws InterruptedException {
        ScrolltoButtom(myAccount);
        Thread.sleep(1000);
        clickButton(myAccount);
    }
    public String get_msg_register_done(){

        return gettext(msgRegister);
    }
    public void click_My_wishlist(){
     clickButton(myWishlist);
    }
    public void click_My_orders(){
       clickButton(myOrder);
    }
    public void click_account(){
        clickButton(Account);
    }
    public void logout(){
        clickButton(logout);
    }

}
