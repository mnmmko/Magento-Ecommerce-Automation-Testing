package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.sikuli.script.*;

import java.util.Iterator;
import java.util.Set;

public class BasePage{
    WebDriver driver;
    JavascriptExecutor jse;
    Select select;
    Actions actions;
    Screen screen;
    Pattern pattern;
    Match match;
    private String projectPath = System.getProperty("user.dir");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButton(By element){
        waits_for_element(driver,20,element);
        driver.findElement(element).click();
    }
    public void sendText(By element,String text){
        waits_for_element(driver,20,element);
        driver.findElement(element).sendKeys(text);
    }
    public void clearText(By element){
        waits_for_element(driver,20,element);
        driver.findElement(element).clear();
    }
    public void selectItem(By element,String text){
        waits_for_element(driver,20,element);
        select=new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }
    public String get_page_title(){
        return driver.getTitle();
    }

    public void mouseHover(By element){
        actions=new Actions(driver);
        waits_for_element(driver,20,element);
        actions.moveToElement(driver.findElement(element)).perform();
    }
    public String gettext(By element){
        waits_for_element(driver,20,element);
        return driver.findElement(element).getText();
    }
    public String gettextofelements(By element,int index){
        waits_for_element(driver,20,element);
        return driver.findElements(element).get(index).getText();
    }

    public void ScrolltoButtom(By element)
    {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }
    private void waits_for_element(WebDriver driver, int time, By element){
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickScreenButton(String element) throws FindFailed {
        screen = new Screen();
        pattern=new Pattern(projectPath+"\\screenelement\\"+element+".png");
        screen.wait(pattern,20);
        screen.click(pattern);
    }
    public void sendTextsecreen(String element,String text) throws FindFailed {
        screen = new Screen();
        pattern=new Pattern(projectPath+"\\screenelement\\"+element+".png");
        screen.wait(pattern,20);
        screen.type(pattern,text);
    }
    public String getTextScreen(String element) throws FindFailed {
        screen = new Screen();
        pattern=new Pattern(projectPath+"\\screenelement\\"+element+".png");
        match=screen.find(pattern);
        screen.wait(pattern,20);
        return match.text();
    }


    public void switich_to_window(){
        String parent=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        String child_window = "";
        while(I1.hasNext()) {

            child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getTitle());
            }
        }
    }
    public void close_pop_up_window(){

        String currentWindowHandle = driver.getWindowHandle();


        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(currentWindowHandle);


        for(String windowHandle : windowHandles) {

            // If it's a new window, switch to it and close the old window
            if(windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.close();
                break;
            }

        }
        for(String windowHandle : windowHandles){
            if(!(windowHandle.equals(currentWindowHandle))) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println(driver.getWindowHandle());


    }
}
