package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;
import static java.lang.Thread.sleep;

public class HomePage  {



    public  void mudarSelectVersion(String version){
        Select comboBox = new Select(getDriver().findElement(By.id("switch-version-select")));
        comboBox.selectByValue(version);
    }

    public void selecionarBotaoAddCustomer (){
        getDriver().findElement(By.linkText("Add Customer")).click();

    }


    public void pesquisar (String titulo){

        WebElement element = getDriver().findElement(By.xpath("//a[@class=\"btn btn-primary search-button t5\"]"));
        WebElement search = getDriver().findElement(By.className("search-input"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(element));

        element.click();

        search.sendKeys(titulo, Keys.ENTER);
    }

    public void selecionarCheckBox () throws InterruptedException {

        WebElement element = getDriver().findElement(By.xpath("//tr[@class=\"filter-row gc-search-row\"]//div[@class=\"floatL t5\"]/input"));
        sleep(1000);
        element.click();
    }

    public void selecionarBotaoDeletar (){

        WebElement element = getDriver().findElement(By.xpath("//td[@class=\"no-border-left \"]//a[@title=\"Delete\"]"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(element));

        element.click();

    }

    public String getMensagem(){
        WebElement element = getDriver().findElement(By.xpath("//div[@class=\"delete-multiple-confirmation modal fade in show\"]//div[@class=\"modal-content\"]"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(element));

        return  getDriver().findElement(By.className("alert-delete-multiple-one")).getText();
    }

    public void confirmarDeletar(){
        getDriver().findElement(By.xpath("//button[@class=\"btn btn-danger delete-multiple-confirmation-button\"]")).click();
    }

}
