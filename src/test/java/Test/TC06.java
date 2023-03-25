package Test;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC06 extends BaseTest{
   // private WebDriver driver;
    HomePage hp;
    LoginPage lp;
    WishlistPage wp;
    CartPage cp;
    CheckoutPage chp;

    @Test(priority = 9)
    public void verify_flat_rate_shipping_of_5$_is_genrated() throws InterruptedException {
       // driver=BaseTest.getDriver();
        hp=new HomePage(driver);
        lp=new LoginPage(driver);
        wp=new WishlistPage(driver);
        cp=new CartPage(driver);
        chp=new CheckoutPage(driver);
        hp.click_account();
        hp.logout();
        hp.click_My_account();
        lp.login(TC05.email,"12345678");
        hp.click_My_wishlist();
        wp.click_add_cart();
        cp.estimates("United States","New York","10005");
        cp.check_fix_rate();
        cp.click_upadte_total();

        String rate=cp.get_rate();

        Assert.assertEquals("$5.00",rate);


    }

    @Test(priority = 10)
    public void verify_shipping_cost_is_add_total() {
        String price= cp.get_price();
        String totalprice=cp.get_total_price();
        Assert.assertEquals("$615.00",price);
        Assert.assertEquals("$620.00",totalprice);
    }
    @Test(priority = 11)
    public void verify_order_is_created() throws IOException {
        cp.click_proceed_checkout();
//        chp.select_new_address();
        chp.setinfo("glaa","can","New York","10001","United States","01054898");
        chp.click_continue();
        chp.click_continue01();
        chp.click_continue02();
        chp.click_money_order();
        chp.click_continue03();
        chp.click_place_order();
        String orderId= chp.get_order_id();
        String id=orderId.replaceAll("[^0-9]+","");
        System.out.println(orderId);
        BaseTest.take_screenShoot(id);
        chp.continue_shopinng();
    }

}
