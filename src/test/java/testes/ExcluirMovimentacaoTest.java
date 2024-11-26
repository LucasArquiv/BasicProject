package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.ContasPage;
import pages.HomePage;


public class ExcluirMovimentacaoTest extends BaseTest {

    HomePage homePage = new HomePage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void excluirContaComMovimentacao() {

        homePage.telaListaConta();

        contasPage.clicarExcluirConta("Conta com movimentacao");

        //verificando mensagem de erro ao excluir a conta
        Assert.assertEquals("Conta em uso na movimentações",contasPage.alertaErro());
    }
}
