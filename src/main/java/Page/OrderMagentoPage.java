package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrderMagentoPage extends BasePage{
    public OrderMagentoPage(WebDriver driver) {
        super(driver);
    }
    Actions actions;
    Select select;
    private By closeIncommingMessage=By.linkText("close");
    private By sales=By.linkText("Sales");
    private By order=By.linkText("Orders");
    private By exportOption=By.name("sales_order_grid_export");
    private By export=By.xpath("//button[@title = 'Export']");


    public void close_incoming_message(){
        clickButton(closeIncommingMessage);
    }
    public void hover_sales(){
        mouseHover(sales);
    }
    public void click_order(){
        clickButton(order);
    }
    public void select_export_option(String s){
        selectItem(exportOption,s);
    }
    public void click_export(){
        clickButton(export);
    }
}
