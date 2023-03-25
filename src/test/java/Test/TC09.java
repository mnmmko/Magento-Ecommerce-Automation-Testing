package Test;

import Page.CartPage;
import Page.HomePage;
import Page.MobilePage;
import Page.ProductPage;
import Report.Reportio;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(value= Reportio.class)
public class TC09 extends BaseTest{
    //private WebDriver driver;
    HomePage hp;
    MobilePage mp;
    ProductPage pp;
    CartPage cp;

    @Test(priority = 16)
    public void verify_dicount_is_applied() {
       // driver=BaseTest.getDriver();
        hp=new HomePage(driver);
        mp=new MobilePage(driver);
        pp=new ProductPage(driver);
        cp=new CartPage(driver);
        hp.click_mobile_field();
        mp.add_to_cart("iphone");
        cp.add_coupon_code("GURU50");
        String msgCoupon=cp.get_success_msg_coupon();
        Assert.assertEquals("Coupon code \"GURU50\" was applied.",msgCoupon);
    }
}
