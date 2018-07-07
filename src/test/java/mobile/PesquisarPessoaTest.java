package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import mobile.page_objects.TelaNovoEditarPO;
import mobile.page_objects.TelaPrincipalPO;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class PesquisarPessoaTest {

    @Test
    public void pesquisarPessoa() throws MalformedURLException {
        File app = new File("app/pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

        TelaPrincipalPO telaPrincipal = new TelaPrincipalPO(driver);
        TelaNovoEditarPO telaNovoEditarPO = new TelaNovoEditarPO(driver);

        telaPrincipal.pesquisar("Guilherme2");
        telaPrincipal.editarNomePesquisado();

        assertEquals(telaNovoEditarPO.retornarValorNome(), "Guilherme2");
        assertEquals(telaNovoEditarPO.retornarValorEndereco(), "Rio do Oeste");
        assertEquals(telaNovoEditarPO.retornarValorHobie(), "Teste");
    }
}
