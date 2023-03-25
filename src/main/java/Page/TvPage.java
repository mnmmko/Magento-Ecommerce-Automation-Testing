package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class TvPage extends BasePage{
    public TvPage(WebDriver driver) {
        super(driver);
    }
    private By tvPageTitle=By.className("page-title");
    private By product=By.className("products-grid");
    private WebElement row;
    private List<WebElement> names;
    private List<WebElement> addWishlist;
    public String get_tv_page_title(){
        return gettext(tvPageTitle);
    }
    public void add_to_wishlist(String product_name){
        row=driver.findElement(product);
        names=row.findElements(By.className("product-name"));
        addWishlist=row.findElements(By.linkText("Add to Wishlist"));
        int i=0;
        for(WebElement product:names) {
            if (product_name.equals(product.getText().toLowerCase().trim())) {
                break;
            }
            i++;
        }
        System.out.println(i);
        addWishlist.get(i).click();
    }
}
