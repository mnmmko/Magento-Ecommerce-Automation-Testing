package Test;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TC04 extends BaseTest{
    //private WebDriver driver;
    HomePage hp;
    MobilePage mp;
    CompareWindowPage cwp;

    @Test(priority = 6)
    public void verify_pop_up_compare_window() {
      //  driver = BaseTest.getDriver();
        hp = new HomePage(driver);
        mp = new MobilePage(driver);
        cwp = new CompareWindowPage(driver);
        hp.click_mobile_field();
        mp.click_add_compare("iphone");
        mp.click_add_compare("sony xperia");
        mp.click_compare();
        cwp.switich_to_window();
        String title= cwp.get_title();
        System.out.println(title);
        Assert.assertEquals("COMPARE PRODUCTS",title);
        String product1= cwp.get_product1();
        String product2=cwp.get_product2();
        System.out.println(product1);
        System.out.println(product2);
        Assert.assertEquals("IPHONE",product2);
        Assert.assertEquals("SONY XPERIA",product1);
           }

    @Test(priority = 7)
    public void verify_pop_up_window_closed() {
        cwp.close_pop_up_window();
    }
}
