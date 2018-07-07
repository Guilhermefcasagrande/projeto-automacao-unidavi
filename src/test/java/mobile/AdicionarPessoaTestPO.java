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

public class AdicionarPessoaTestPO {

    @Test
    public void adicionarPessoa() throws MalformedURLException {
        File app = new File("app/pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

        TelaPrincipalPO telaPrincipal = new TelaPrincipalPO(driver);
        TelaNovoEditarPO telaNovoEditarPO = new TelaNovoEditarPO(driver);

        telaPrincipal.clicarEmAdicionar();

        telaNovoEditarPO.preencherCampoNome("GuilhermePO");
        telaNovoEditarPO.preencherCampoEndereco("Rio do Oeste");
        telaNovoEditarPO.preencherCampoHobie("TestePO");

        telaNovoEditarPO.salvarCadastro();

        telaPrincipal.pesquisar("GuilhermePO");
        telaPrincipal.editarNomePesquisado();

        assertEquals(telaNovoEditarPO.retornarValorNome(), "GuilhermePO");

    }
}
