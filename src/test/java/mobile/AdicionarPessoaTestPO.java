package mobile;

import mobile.page_objects.TelaNovoEditarPO;
import mobile.page_objects.TelaPrincipalPO;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class AdicionarPessoaTestPO extends BaseTestMobile {

    @Test
    public void adicionarPessoa(){


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
