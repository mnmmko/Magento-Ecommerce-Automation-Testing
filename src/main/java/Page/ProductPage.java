package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private By productName=By.className("product-name");
    private By price=By.className("price");
    private By addToCart=By.className("add-to-cart-buttons");
    private By quntity=By.id("qty");
    private By addReviw=By.linkText("Add Your Review");

    public String get_product_name(){
        return gettext(productName);
    }
    public String get_product_price(){
        return gettext(price);
    }
    public void click_add_to_cart(){
        clickButton(addToCart);
    }
    public void click_add_review(){
        clickButton(addReviw);
    }
    public void click_add_quntity(String num){
        clearText(quntity);
        sendText(quntity,num);
    }
}
