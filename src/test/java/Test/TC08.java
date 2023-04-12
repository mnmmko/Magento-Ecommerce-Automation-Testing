package Test;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC08 extends BaseTest{
    
  //  private WebDriver driver;
    HomePage hp;
    LoginPage lp;

    CartPage cp;
    CheckoutPage chp;
    OrderPage op;

    @Test(priority = 14)
    public void verify_grand_total_changed() throws InterruptedException {
       // driver=BaseTest.getDriver();
        op.close_pop_up_window();
        hp=new HomePage(driver);
        cp=new CartPage(driver);
        lp=new LoginPage(driver);
        chp=new CheckoutPage(driver);
        op=new OrderPage(driver);
//       hp.click_My_account();
//        lp.login("ali123@gmail.com","12345678");
        op.click_reorder();
        cp.add_quntity("10");
        cp.estimates("United States","New York","10005");
        cp.check_fix_rate();
        cp.click_upadte_total();
        String grandTotal=cp.get_total_price();
        Assert.assertEquals("$6,200.00",grandTotal);
    }

    @Test(priority = 15)
    public void verify_order_number_is_genrated() throws IOException {
        cp.click_proceed_checkout();
        chp.click_continue();
        chp.click_continue02();
        chp.click_money_order();
        chp.click_continue03();
        chp.click_place_order();
        String orderId= chp.get_order_id();
        String id=orderId.replaceAll("[^0-9]+","");
        System.out.println(id);
        BaseTest.take_screenShoot(id);
    }
}
