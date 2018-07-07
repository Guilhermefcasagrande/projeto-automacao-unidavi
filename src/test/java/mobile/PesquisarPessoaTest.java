package mobile;


import mobile.page_objects.TelaNovoEditarPO;
import mobile.page_objects.TelaPrincipalPO;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class PesquisarPessoaTest extends BaseTestMobile{

    @Test
    public void pesquisarPessoa() {

        TelaPrincipalPO telaPrincipal = new TelaPrincipalPO(driver);
        TelaNovoEditarPO telaNovoEditarPO = new TelaNovoEditarPO(driver);

        telaPrincipal.pesquisar("Guilherme2");
        telaPrincipal.editarNomePesquisado();

        assertEquals(telaNovoEditarPO.retornarValorNome(), "Guilherme2");
        assertEquals(telaNovoEditarPO.retornarValorEndereco(), "Rio do Oeste");
        assertEquals(telaNovoEditarPO.retornarValorHobie(), "Teste");
    }
}
