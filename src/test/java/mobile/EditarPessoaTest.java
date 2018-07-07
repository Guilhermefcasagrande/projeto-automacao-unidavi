package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditarPessoaTest {

    @Test
    public void editarPessoaComSucesso() throws MalformedURLException {
        File app = new File("app/pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

        driver.findElement(By.id("com.eliasnogueira.workshop:id/fab")).click();

        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).sendKeys("Guilherme2");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).sendKeys("Rio do Oeste");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).sendKeys("Teste");

        driver.findElement(By.id("com.eliasnogueira.workshop:id/button")).click();

        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Guilherme2");

        driver.findElement(By.id("android:id/text1")).click();

        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).getAttribute("text"), "Guilherme2");
        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).getAttribute("text"), "Rio do Oeste");
        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).getAttribute("text"), "Teste");

        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.id("android:id/search_close_btn")).click();

        assertTrue(driver.findElement(By.id("com.eliasnogueira.workshop:id/refresh")).isDisplayed());
    }
}
