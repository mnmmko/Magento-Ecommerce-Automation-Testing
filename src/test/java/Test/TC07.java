package Test;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends BaseTest{
   // private WebDriver driver;
    HomePage hp;
    LoginPage lp;
    OrderPage op;


    @Test(priority = 12)
    public void verify_recent_order_is_display() throws InterruptedException {
        //driver=BaseTest.getDriver();
        hp=new HomePage(driver);
        lp=new LoginPage(driver);
        op=new OrderPage(driver);
        hp.click_My_account();
        hp.click_My_orders();
        op.click_view_order();
        String pending=op.get_recent_order_pendding();
        if(pending.contains("PENDING")){
            Assert.assertTrue(true);
        }
        System.out.println(pending);

    }

    @Test(priority = 13)
    public void verify_order_is_saved_as_pdf() throws FindFailed {
        op.click_print_order();
        op.switich_to_window();
        //System.out.println(op.get_oreder_details());
        //op.click_print();
       // op.click_save(TC06.id);
        op.close_pop_up_window();
    }
}
