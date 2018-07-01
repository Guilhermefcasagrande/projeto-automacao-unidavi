package web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditarPessoaTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void preCondicao(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Guilherme\\Documents\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void editarPessoa(){
        driver.get("http://livrodeteste.com/otestadortecnico/app");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pesquisar")));
        driver.findElement(By.id("pesquisar")).click();
        driver.findElement(By.id("pesquisar")).sendKeys("Guilherme");
        driver.findElement(By.id("editar")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-btn.w3-teal")));

        WebElement nome = driver.findElement(By.id("nome"));
        WebElement endereco = driver.findElement(By.id("endereco"));
        WebElement hobbies = driver.findElement(By.id("hobbies"));

        //falta terminar

    }
}
