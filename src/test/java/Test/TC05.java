package Test;

import Page.*;
import Utilities.execl.Read_excel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.*;

public class TC05 extends BaseTest{
   // private WebDriver driver;
    HomePage hp;
    LoginPage lp;
    RegisterPage rp;
    TvPage tp;
    WishlistPage wp;
    public static String email=random_email();
    @Test(priority = 8)
    public void verify_account_register_done() throws InterruptedException {
      //  driver=BaseTest.getDriver();
        hp=new HomePage(driver);
        lp=new LoginPage(driver);
        rp=new RegisterPage(driver);
        hp.click_My_account();
        lp.click_create_account();
        rp.click_register("ali","amr","kamel",email,"12345678","12345678");
        String msgRegister=hp.get_msg_register_done();
        Assert.assertEquals("Thank you for registering with Main Website Store.",msgRegister);
    }

    @Test(priority = 8)
    public void verify_wishlist_shared_successfully() {
        tp=new TvPage(driver);
        wp=new WishlistPage(driver);
        hp.click_tv_field();
        tp.add_to_wishlist("lg lcd");
        wp.click_share_wishlist();
        wp.click_share_wishlist_btn("ali02@gmail.com","good product");
        String msgwishlist=wp.get_msg_wishlist_done();
        Assert.assertEquals(msgwishlist,"Your Wishlist has been shared.");
    }
    @DataProvider
    public Object[][] data() throws IOException, InvalidFormatException {
        return Read_excel.read_sheet("register");
    }

}
