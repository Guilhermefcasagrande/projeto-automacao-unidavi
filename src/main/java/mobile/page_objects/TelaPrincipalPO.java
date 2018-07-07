package mobile.page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class TelaPrincipalPO {

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/fab")
    MobileElement botaoAdicionar;

    @AndroidFindBy(id = "android:id/search_button")
    MobileElement botaoLupa;

    @AndroidFindBy(id = "android:id/search_src_text")
    MobileElement campoPesquisa;

    @AndroidFindBy(id = "android:id/text1")
    MobileElement nomePesquisado;

    public TelaPrincipalPO(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clicarEmAdicionar(){
        botaoAdicionar.click();
    }

    public void clicarLupa(){
        botaoLupa.click();
    }

    public void preencherCampoPesquisa(String texto){
        campoPesquisa.sendKeys(texto);
    }

    public void pesquisar(String texto){
        clicarLupa();
        preencherCampoPesquisa(texto);
    }

    public void editarNomePesquisado(){
        nomePesquisado.click();
    }

}
