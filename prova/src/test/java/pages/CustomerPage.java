package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class CustomerPage {

    public void setName (String name){
        getDriver().findElement(By.id("field-customerName")).sendKeys(name);
    }

    public void setLastName ( String lastName){
        getDriver().findElement(By.id("field-contactLastName")).sendKeys(lastName);
    }

    public void setContactFirstName ( String contactFirstName){
       getDriver().findElement(By.id("field-contactFirstName")).sendKeys(contactFirstName);
    }

    public void setPhone ( String phone){
        getDriver().findElement(By.id("field-phone")).sendKeys(phone);
    }

    public void setAddressLine1 ( String addressLine1){
        getDriver().findElement(By.id("field-addressLine1")).sendKeys(addressLine1);
    }

    public void setAddressLine2 ( String addressLine2){
        getDriver().findElement(By.id("field-addressLine2")).sendKeys(addressLine2);
    }

    public void setCity ( String city){
        getDriver().findElement(By.id("field-city")).sendKeys(city);
    }

    public void setState ( String state){
        getDriver().findElement(By.id("field-state")).sendKeys(state);
    }

    public void setPostalCode ( String postalCode){
        getDriver().findElement(By.id("field-postalCode")).sendKeys(postalCode);
    }

    public void setCountry ( String country){
        getDriver().findElement(By.id("field-country")).sendKeys(country);
    }

    public void selectFromEmployeer (String fromEmployeer){
        getDriver().findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
        getDriver().findElement(By.xpath("//li[text()='"+fromEmployeer+"']")).click();
//        Select comboBox = new Select(getDriver().findElement(By.id("field-salesRepEmployeeNumber")));
//        comboBox.selectByVisibleText(fromEmployeer);
    }

    public void setCreditiLimit (String creditiLimit){
        getDriver().findElement(By.id("field-creditLimit")).sendKeys(creditiLimit);
    }

    public void selecionarBotaoSalvar (){
        getDriver().findElement(By.id("form-button-save")).click();
    }

    public String getMensagem (){

        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id("report-success"))));

        return getDriver().findElement(By.id("report-success")).getText();
    }

    public void selecionarVoltar (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5000);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id("report-success"))));

        getDriver().findElement(By.linkText("Go back to list")).click();
    }

}
