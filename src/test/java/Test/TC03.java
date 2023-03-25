package Test;

import Page.CartPage;
import Page.HomePage;
import Page.MobilePage;
import Page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends BaseTest
{
  //  private WebDriver driver;
    HomePage hp;
    MobilePage mp;
    ProductPage pp;
    CartPage cp;
        @Test(priority = 4)
    public void verify_can_not_add_more_500_product_in_cart() {
    //    driver=BaseTest.getDriver();
        hp=new HomePage(driver);
        mp=new MobilePage(driver);
        pp=new ProductPage(driver);
        cp=new CartPage(driver);
        hp.click_mobile_field();
        mp.add_to_cart("sony xperia");
        cp.add_quntity("1000");
        String errorMessage=cp.get_error_message();
        System.out.println(errorMessage);
        Assert.assertEquals("* The maximum quantity allowed for purchase is 500.",errorMessage);
    }

    @Test(priority = 5)
    public void verify_cart_is_empty() {
        cp.click_empty_cart();
        String cartEmpty= cp.get_cart_empty();
        System.out.println(cartEmpty);
        Assert.assertEquals("You have no items in your shopping cart.",cartEmpty);
    }
}
