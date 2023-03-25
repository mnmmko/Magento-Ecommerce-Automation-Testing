package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackendLoginPage extends BasePage{
    public BackendLoginPage(WebDriver driver) {
        super(driver);
    }
    private By username=By.id("username");
    private By password=By.id("login");
    private By login=By.className("form-button");

    public void login(String user,String pass){
        sendText(username,user);
        sendText(password,pass);
        clickButton(login);
    }
}
