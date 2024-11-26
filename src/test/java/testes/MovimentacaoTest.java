package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.MovimentacaoPage;
import utils.DataUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static utils.DataUtils.dataFormatada;


public class MovimentacaoTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final MovimentacaoPage moviPage = new MovimentacaoPage();

    @Test
    public void test1InserirMovimentacao() {

        homePage.telaMovimentcao();

        moviPage.setDataMovimentacao(dataFormatada(new Date()));
        moviPage.setDataPagamento(dataFormatada(new Date()));
        moviPage.setDescricao("teste de movimentação de conta");
        moviPage.setInteressado("Eu mesmo");
        moviPage.setValor("1500");
        moviPage.setConta("Conta para movimentacoes");
        moviPage.setStatusPago();
        moviPage.salvar();

        //verificando mensagem de sucesso
        Assert.assertEquals("Movimentação adicionada com sucesso!", moviPage.alertaSucessoMovimentacao());

    }

    @Test
    public void test2CamposObrigatorios() {

        homePage.telaMovimentcao();

        moviPage.salvar();

        //verificando mensagem de erro
        List<String> erros = moviPage.alertaErrosMovimentacao();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
        )));

    }

    @Test
    public void test3MovimentacaoFutura() {

        homePage.telaMovimentcao();

        Date dataFutura = DataUtils.dataDiferencaDias(5);

        moviPage.setDataMovimentacao(dataFormatada(dataFutura));
        moviPage.setDataPagamento(dataFormatada(dataFutura));
        moviPage.setDescricao("teste de movimentação de conta");
        moviPage.setInteressado("Eu mesmo");
        moviPage.setValor("1500");
        moviPage.setConta("Conta para movimentacoes");
        moviPage.setStatusPago();
        moviPage.salvar();

        //verificando mensagem de erro
        List<String> erros = moviPage.alertaErrosMovimentacao();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));

    }
}
