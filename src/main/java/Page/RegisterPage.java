package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private By firstName=By.id("firstname");
    private By middleName=By.id("middlename");
    private By lastName=By.id("lastname");
    private By email=By.id("email_address");
    private By password=By.id("password");
    private By confirmationPassword=By.id("confirmation");
    private By signupNewsLetter=By.id("is_subscribed");
    private By registerBtn=By.xpath("//*[@id=\"form-validate\"]/div[2]/button");
    private By back=By.className("back-link");


    public void click_register(String fname,String mname,String lname,String emails,String pass,String conpass){
        sendText(firstName,fname);
        sendText(middleName,mname);
        sendText(lastName,lname);
        sendText(email,emails);
        sendText(password,pass);
        sendText(confirmationPassword,conpass);
        clickButton(signupNewsLetter);
        clickButton(registerBtn);
    }
    public void click_back(){
       clickButton(back);
    }

}
