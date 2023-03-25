package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }
    private By shareWishlist=By.name("save_and_share");
    private By email=By.id("email_address");
    private By message=By.id("message");
    private By shareWishlistbtn=By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span");
    private By msgWishlist=By.className("success-msg");
    private By addCart=By.className("btn-cart");
    public void click_share_wishlist(){
        clickButton(shareWishlist);
    }

    public void click_share_wishlist_btn(String emails,String msg){
        sendText(email,emails);
        sendText(message,msg);
        clickButton(shareWishlistbtn);
    }
    public String get_msg_wishlist_done(){
        return gettext(msgWishlist);
    }
    public void click_add_cart(){
        clickButton(addCart);
    }
}
