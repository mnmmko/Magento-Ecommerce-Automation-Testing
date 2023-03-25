package Test;

import Page.CartPage;
import Page.HomePage;
import Page.MobilePage;
import Page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends BaseTest{
  //  private WebDriver driver;
    HomePage hp;
    MobilePage mp;
    ProductPage pp;
    CartPage cp;

    @Test(priority = 0)
    public void verify_title_of_home_page() {
      //  driver=BaseTest.getDriver();
        hp=new HomePage(driver);
        String HomePageTitle= hp.get_page_title();
        System.out.println(HomePageTitle);
        Assert.assertEquals("THIS IS DEMO SITE FOR   ",HomePageTitle);
    }

    @Test(priority = 1,dependsOnMethods = "verify_title_of_home_page")
    public void verfiy_title_of_mobile_page() {
        mp=new MobilePage(driver);
        hp.click_mobile_field();
        String MobilePageTitle= mp.get_mobile_page_title();
        System.out.println(MobilePageTitle);
        Assert.assertEquals("MOBILE",MobilePageTitle);
    }

    @Test(priority = 2,groups = "tc01")
    public void verify_product_sort_by_name() {
        mp.sort_product("Name");
        String sorted= mp.get_sort_by_name();
        Assert.assertEquals("All 3 products sorted by name",sorted);
    }

}
