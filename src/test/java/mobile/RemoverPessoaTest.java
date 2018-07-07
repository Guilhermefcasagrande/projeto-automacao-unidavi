package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class RemoverPessoaTest {

    @Test
    public void removerPessoaComSucesso() throws MalformedURLException {
        File app = new File("app/pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

        driver.findElement(By.id("com.eliasnogueira.workshop:id/fab")).click();

        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).sendKeys("Guilherme");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).sendKeys("Rio do Oeste");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).sendKeys("Teste");

        driver.findElement(By.id("com.eliasnogueira.workshop:id/button")).click();

        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Guilherme");

        TouchAction action = new TouchAction(driver);
        LongPressOptions longPressOptions = new LongPressOptions();

        longPressOptions.withElement(new ElementOption().withElement(driver.findElement(By.id("android:id/text1")))).build();
        action.longPress(longPressOptions).perform();

        assertEquals(driver.findElement(By.id("android:id/message")).getText(), "Deseja remover a pessoa selecionada?");

        //modal de apagar
        driver.findElement(By.id("android:id/button1")).click();

        //modal de sucesso
        driver.findElement(By.id("android:id/button3")).click();

        //limpa a pesquisa após apagar
        driver.findElement(By.id("android:id/search_close_btn")).click();



    }
}
