package Test;

import Page.BackendLoginPage;
import Page.OrderMagentoPage;
import Report.Reportio;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.*;

@Listeners(value= Reportio.class)
public class TC10 extends BaseTest{
   // WebDriver driver;
    BackendLoginPage blp;
    OrderMagentoPage omp;
    @Test(priority = 17)
    public void verify_console_display_all_order_information() {
       // driver=BaseTest.getDriver();
        driver.navigate().to("http://live.techpanda.org/index.php/backendlogin/");
        blp=new BackendLoginPage(driver);
        omp=new OrderMagentoPage(driver);
        blp.login("user01","guru99com");
        omp.close_incoming_message();
        omp.hover_sales();
        omp.click_order();
        omp.select_export_option("CSV");
        omp.click_export();
        String filePath = System.getProperty("user.home")+"/Downloads/orders.csv";
       // EmailUti.emailUtil(filePath);

        File f = new File(filePath);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line = br.readLine();
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
