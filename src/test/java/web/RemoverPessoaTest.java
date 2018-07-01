package web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class RemoverPessoaTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void preCondicao(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Guilherme\\Documents\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void removerPessoa(){
        driver.get("http://livrodeteste.com/otestadortecnico/app");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pesquisar")));
        driver.findElement(By.id("pesquisar")).click();
        driver.findElement(By.id("pesquisar")).sendKeys("Guilherme");
        driver.findElement(By.id("remover")).click();

        Alert alerta = driver.switchTo().alert();
        assertEquals(alerta.getText(), "Deseja realmente remover?");
        alerta.accept();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pesquisar")));

        String dadosPagina = driver.getPageSource();
        assertFalse(dadosPagina.contains("Guilherme"));
        assertFalse(dadosPagina.contains("Rio do Oeste"));
        assertFalse(dadosPagina.contains("TEste"));
    }
}
