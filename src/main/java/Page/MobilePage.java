package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class MobilePage extends BasePage{
    public MobilePage(WebDriver driver) {
        super(driver);
    }
    private Select select;
    private By MobilePageTitle=By.className("page-title");
    private By sort_filed=By.cssSelector("select[title=\"Sort By\"]");
    private By SortByName=By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul");
    private By compareBtn=By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-right.sidebar > div.block.block-list.block-compare > div.block-content > div > button");
    private By clearAllBtn=By.linkText("Clear All");
    private WebElement row;
    private List<WebElement> names;
    LinkedList<String> productNames;
    private List<WebElement> productLink;
    private List<WebElement> productPrice;
    private List<WebElement> addcart;
    private List<WebElement> addcompare;

    public String get_mobile_page_title(){
        return gettext(MobilePageTitle);
    }
    public void sort_product(String sortby){
        selectItem(sort_filed,sortby);
    }
    public String get_sort_by_name(){
        row=driver.findElement(SortByName);
        names=row.findElements(By.className("product-name"));
        productNames=new LinkedList<String>();
        for (WebElement product:names){
            System.out.println(product.getText().toLowerCase().trim());
            productNames.add(product.getText().toLowerCase().trim());
        }
        boolean nam=checkproductOrderByName(productNames);
        if(nam==true){
            return "All 3 products sorted by name";
        }else {
            return "All 3 products not sorted by name";
        }
    }
    public String click_on_product(String product_name){
        row=driver.findElement(SortByName);
        names=row.findElements(By.className("product-name"));
        productLink=row.findElements(By.className("product-image"));
        productPrice=row.findElements(By.className("price-box"));
        int i=0;
        for(WebElement product:names){
            if(product_name.equals(product.getText().toLowerCase().trim())){
                break;
            }
            i++;
        }
        String prices=productPrice.get(i).getText();
        System.out.println(prices);
        productLink.get(i).click();
        return prices;
    }
    public void add_to_cart(String product_name){
        row=driver.findElement(SortByName);
        names=row.findElements(By.className("product-name"));
        addcart=row.findElements(By.tagName("button"));
        int i=0;
        for(WebElement product:names) {
            if (product_name.equals(product.getText().toLowerCase().trim())) {
                break;
            }
            i++;
        }
        System.out.println(i);
        addcart.get(i).click();
    }
    public void click_add_compare(String product_name){
        row=driver.findElement(SortByName);
        names=row.findElements(By.className("product-name"));
        addcompare=row.findElements(By.linkText("Add to Compare"));
        int i=0;
        for(WebElement product:names) {
            if (product_name.equals(product.getText().toLowerCase().trim())) {
                break;
            }
            i++;
        }
        System.out.println(i);
        addcompare.get(i).click();
    }
    public void click_compare(){
        clickButton(compareBtn);
    }
    public void click_clear_all(){
        clickButton(clearAllBtn);
    }

    private boolean checkproductOrderByName(LinkedList<String>names){
        String previous="";
        for(String current:names){
            if(current.compareTo(previous)<0){
                return false;
            }
            previous=current;
        }
        return true;
    }
}
