package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By CreateAccount=By.xpath("//a[@title=\"Create an Account\"]");
    private By email=By.id("email");
    private By password=By.id("pass");
    private By login=By.name("send");


    public void click_create_account(){
        clickButton(CreateAccount);
    }

    public void login(String emails,String pass){

        sendText(email,emails);
        sendText(password,pass);
        clickButton(login);

    }
}
