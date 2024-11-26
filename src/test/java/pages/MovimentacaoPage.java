package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static core.DriverFactory.getDriver;

public class MovimentacaoPage extends BasePage {

    public void setDataMovimentacao(String dataMovimentacao) {
        escreve("data_transacao", dataMovimentacao);
    }

    public void setDataPagamento(String dataPagamento) {
        escreve("data_pagamento", dataPagamento);
    }

    public void setDescricao(String descricao) {
        escreve("descricao", descricao);
    }

    public void setInteressado(String interessado) {
        escreve("interessado", interessado);
    }

    public void setValor(String valor) {
        escreve("valor", valor);
    }

    public void setConta(String conta) {
        selecionaCombo("conta", conta);
    }

    public void setStatusPago() {
        clicarRadio("status_pago");
    }

    public void setStatusPendente() {
        clicarRadio("status_pendente");
    }

    public void salvar() {
        clickDeBotaoPorTexto("Salvar");
    }

    public String alertaSucessoMovimentacao() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public List<String> alertaErrosMovimentacao() {
        List<WebElement> erros = getDriver().findElements(By.xpath(
                "//div[@class='alert alert-danger']//li"));
        List<String> retorna = new ArrayList<String>();
        for (WebElement erro : erros) {
            retorna.add(erro.getText());
        }
        return retorna;
    }
}
