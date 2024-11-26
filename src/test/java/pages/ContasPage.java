package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNomeConta(String nomeConta) {
        escreve("nome", nomeConta);
    }

    public void salvar() {
        clickDeBotaoPorTexto("Salvar");
    }

    public String alertaSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String alertaErro() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clicarAlteraConta(String contaDoTeste) {

        obtercelula("Conta", contaDoTeste, "Ações", "tabelaContas")
                .findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void clicarExcluirConta(String contaDoTeste) {

        obtercelula("Conta", contaDoTeste, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
