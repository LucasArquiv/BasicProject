package pages;

import core.BasePage;
import core.DriverFactory;

public class LoginPage extends BasePage {

    public void acessoTelaInicial() {
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
    }

    public void setEmail(String email) {
        escreve("email", email);
    }

    public void setSenha(String senha) {
        escreve("senha", senha);
    }

    public void entrar() {
        clickDeBotaoPorTexto("Entrar");
    }
    public void reset(){
        clicarLink("reset");
    }

    //Dica Caso você uutilize muito os metodos para logan na página
//    public void logar(String email, String senha){
//        setEmail(email);
//        setSenha(senha);
//        entrar();
//    }

}
