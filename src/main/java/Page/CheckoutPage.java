package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private By newAddress=By.name("billing_address_id");
    private By address=By.id("billing:street1");
    private By city=By.id("billing:city");
    Select select;
    private By state=By.id("billing:region_id");
    private By zip=By.id("billing:postcode");
    private By country=By.id("billing:country_id");
    private By telephone=By.id("billing:telephone");
    private By continueBtn=By.xpath("//*[@id=\"billing-buttons-container\"]/button");
    private By continueBtn01=By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    private By continueBtn02=By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    private By moneyOrder=By.id("p_method_checkmo");
    private By continueBtn03=By.xpath("//*[@id=\"payment-buttons-container\"]/button");
    private By placeOrder=By.xpath("//*[@id=\"review-buttons-container\"]/button");
    private By orderid=By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]");
    private By continueShopiing= By.cssSelector("div.buttons-set button");

    public void select_new_address(){
        selectItem(newAddress,"New Address");
    }
    public void setinfo(String add,String citys,String states,String zips,String countrys,String phone){
        clearText(address);
        sendText(address,add);
        sendText(city,citys);
        selectItem(state,states);
        clearText(zip);
        sendText(zip,zips);
        selectItem(country,countrys);
        clearText(telephone);
        sendText(telephone,phone);
    }
    public void click_continue(){

        clickButton(continueBtn);
    }
    public void click_continue01(){
        clickButton(continueBtn01);
    }
    public void click_continue02(){
        clickButton(continueBtn02);
    }
    public void click_money_order(){
        clickButton(moneyOrder);
    }
    public void click_continue03(){
        clickButton(continueBtn03);
    }
    public void click_place_order(){
        clickButton(placeOrder);
    }
    public String get_order_id(){
        return gettext(orderid);
    }
    public void continue_shopinng(){
        clickButton(continueShopiing);
    }



}