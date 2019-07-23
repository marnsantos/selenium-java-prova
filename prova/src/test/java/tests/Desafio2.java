package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.CustomerPage;
import pages.HomePage;

import static core.DriverFactory.getDriver;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Desafio2 {

    HomePage homePage = new HomePage();
    CustomerPage customerPage = new CustomerPage();
    @Before
    public void setUp(){
        getDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
        homePage.mudarSelectVersion("bootstrap_theme_v4");
        homePage.selecionarBotaoAddCustomer();
        customerPage.setName("Empresa");
        customerPage.setLastName("Empresa Teste");
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
    }


    @Test
    public void test2() throws InterruptedException {
       customerPage.selecionarVoltar();
       homePage.pesquisar("Teste Sicred");
       homePage.selecionarCheckBox();
       homePage.selecionarBotaoDeletar();
       assertEquals("Are you sure that you want to delete this 1 item?",homePage.getMensagem());
       homePage.confirmarDeletar();

    }

    @After
    public void tearDown(){
//        killDriver();
    }
}
