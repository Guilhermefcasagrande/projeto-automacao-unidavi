package mobile.page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class TelaNovoEditarPO {

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_nome")
    MobileElement campoNome;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_endereco")
    MobileElement campoEndereco;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_hobbies")
    MobileElement campoHobies;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/button")
    MobileElement botaoSalvar;

    public TelaNovoEditarPO(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String retornarValorNome(){
        return campoNome.getAttribute("text");
    }

    public String retornarValorEndereco(){
        return campoEndereco.getAttribute("text");
    }

    public String retornarValorHobie(){
        return campoHobies.getAttribute("text");
    }

    public void preencherCampoNome(String texto){
        campoNome.sendKeys(texto);
    }

    public void preencherCampoEndereco(String texto){
        campoEndereco.sendKeys(texto);
    }

    public void preencherCampoHobie(String texto){
        campoHobies.sendKeys(texto);
    }

    public void salvarCadastro(){
        botaoSalvar.click();
    }

}
