package pages;

import core.BasePage;

public class HomePage extends BasePage {

    public void telaInserirConta() {
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void telaListaConta() {
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void telaMovimentcao() {
        clicarLink("Criar Movimentação");
    }

    public void telaResumo() {
        clicarLink("Resumo Mensal");
    }

    public String obterSaldoConta(String conta) {
        return obtercelula("Conta", conta, "Saldo", "tabelaSaldo").getText();
    }

    public void telaHome(){
        clicarLink("Home");
    }
}
