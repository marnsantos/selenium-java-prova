package tests;

import core.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CustomerPage;
import pages.HomePage;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;
import static junit.framework.TestCase.assertTrue;

public class Desafio1 {

    HomePage homePage = new HomePage();
    CustomerPage customerPage = new CustomerPage();
    @Before
    public void setUp(){
        getDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }


    @Test
    public void test2(){
        homePage.mudarSelectVersion("bootstrap_theme_v4");
        homePage.selecionarBotaoAddCustomer();
        customerPage.setName("Teste Sicred");
        customerPage.setLastName("Teste");
        customerPage.setContactFirstName("Marcia Santos");
        customerPage.setPhone("51 9999-9999");
        customerPage.setAddressLine1("Av Assis Brasil, 3970");
        customerPage.setAddressLine2("Torre D");
        customerPage.setCity("Porto Alegre");
        customerPage.setState("RS");
        customerPage.setPostalCode("91000-000");
        customerPage.setCountry("Brasil");
//        customerPage.selectFromEmployeer("Fixter");
        customerPage.setCreditiLimit("200");
        customerPage.selecionarBotaoSalvar();

        assertTrue(customerPage.getMensagem().contains("Your data has been successfully stored into the database."));

    }

    @After
    public void tearDown(){
//        killDriver();
    }
}
