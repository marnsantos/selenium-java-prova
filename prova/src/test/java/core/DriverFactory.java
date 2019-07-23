package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver navegador;

    public DriverFactory() {}

    public static WebDriver getDriver(){
        if(navegador == null) {
            switch (Propriedades.browser) {
                case FIREFOX:  navegador = new FirefoxDriver(); break;
                case CHROME:  WebDriverManager.chromedriver().version("75").setup();navegador = new ChromeDriver(); break;
            }
            navegador.manage().window().setSize(new Dimension(1200, 765));
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return navegador;
    }

    public static void killDriver(){
        if(navegador != null) {
            navegador.quit();
            navegador = null;
        }
    }

}
