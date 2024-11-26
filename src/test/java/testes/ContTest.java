package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.ContasPage;
import pages.HomePage;


public class ContTest extends BaseTest {

    HomePage homePage = new HomePage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void test1_AdicionarConta() {
        homePage.telaInserirConta();

        contasPage.setNomeConta("Conta do teste");
        contasPage.salvar();

        //verificando mensagem de sucesso ao criar a conta
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.alertaSucesso());
    }

    @Test
    public void test2_AlteraConta() {
        homePage.telaListaConta();

        contasPage.clicarAlteraConta("Conta para alterar");

        contasPage.setNomeConta("Conta para alterar teste");
        contasPage.salvar();

        //verificando mensagem de sucesso ao Alterar a conta
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.alertaSucesso());
    }

    @Test
    public void test3_AdicionarContaMesmoNome() {
        homePage.telaInserirConta();

        contasPage.setNomeConta("Conta mesmo nome");
        contasPage.salvar();

        //verificando mensagem de erro ao criar a conta
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.alertaErro());
    }


}
