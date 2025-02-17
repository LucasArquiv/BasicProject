package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static core.DriverFactory.getDriver;

public class BasePage {

    /*********** TextField e TextArea ***********/

    public void escreve(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escreve(String id_campo, String texto) {
        escreve(By.id(id_campo), texto);
    }

    public String obterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).
                getAttribute("value");
    }

    /********** Radio e check **********/

    public void clicarRadio(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarRadio(String id) {
        getDriver().findElement(By.id(id)).click();
    }


    public boolean isRadioMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void clicarCheck(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isCheckMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    /*********** Combo ***********/

    public void selecionaCombo(String id, String valor) {

        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }


    /********* Botao ***********/

    public void clicarBotao(By by) {
        getDriver().findElement(by).click();
    }

    public void clickDeBotaoPorTexto(String texto) {
        clicarBotao(By.xpath("//button[.='" + texto + "']"));
    }

    public void clicarBotao(String id) {
        clicarBotao(By.id(id));
    }

    public String obterValueElemento(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    /******** Links ************/

    public void clicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    /********** Texto ***********/

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    /************ Tabela ***************/

    public WebElement obtercelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {

        //Localizar coluna de registro
        WebElement tabela = getDriver().findElement(By.xpath(".//*[@id='" + idTabela + "']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //Localizar linha de registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //Localizar coluna do botão
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //Clicar no botão da célula encontrada
        return tabela.findElement(By.xpath("./tbody/tr[" + idLinha + "]/td[" + idColunaBotao + "]"));

    }

    public void clickBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        //Clicar no botão da célula encontrada
        WebElement celula = obtercelula(colunaBusca, valor, colunaBotao, idTabela);
        celula.findElement(By.xpath(".//input")).click();

    }

    private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    private int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }

}
