package Test;

import Page.HomePage;
import Page.MobilePage;
import Page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends BaseTest{
   // private WebDriver driver;
    HomePage hp;
    MobilePage mp;
    ProductPage pp;
    @Test(priority = 3)
    public void verify_product_value() {
    //    driver=BaseTest.getDriver();
        hp=new HomePage(driver);
        mp=new MobilePage(driver);
        pp=new ProductPage(driver);
        hp.click_mobile_field();
        String price=mp.click_on_product("sony xperia");
        String product_price=pp.get_product_price();
        Assert.assertEquals(price,product_price);
    }
}
