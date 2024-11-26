package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.DriverFactory.getDriver;

public class ResumoPage extends BasePage {

    public void excluirMovimentacao() {
        clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }

    public String alertaSucessoMovimentacao() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public Object verificarCampoVazio() {

        List<WebElement> elements =
                getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        return elements.size();
    }

    public void selecionaAno(String ano){
        selecionaCombo("ano", ano);
    }
    public void buscar(){
        clicarBotao(By.xpath("//input[@value='Buscar']"));
    }

}
