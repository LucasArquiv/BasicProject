package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.ContasPage;
import pages.HomePage;
import pages.ResumoPage;

import static core.DriverFactory.getDriver;


public class ResumoMovimentacaoTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final ResumoPage resumoPage = new ResumoPage();
    private static final ContasPage contasPage = new ContasPage();

    @Test
    public void test1ExcluirMovimentacao() {

        homePage.telaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.alertaSucessoMovimentacao());

    }

    @Test
    public void test2ResumoMensal() {

        homePage.telaResumo();

        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

        //Checando local vazio
        resumoPage.selecionaAno("2023");
        resumoPage.buscar();
        resumoPage.verificarCampoVazio();
        Assert.assertEquals(0, resumoPage.verificarCampoVazio());


    }
}
