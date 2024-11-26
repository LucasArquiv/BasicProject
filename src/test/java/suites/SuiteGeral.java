package suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.LoginPage;
import testes.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContTest.class,
        MovimentacaoTest.class,
        ExcluirMovimentacaoTest.class,
        SaldoTest.class,
        ResumoMovimentacaoTest.class
})
public class SuiteGeral {

    private static final LoginPage page = new LoginPage();


    @BeforeClass
    public static void reset(){

        //coloque seu login do site aqui
        page.acessoTelaInicial();
        page.setEmail("");
        page.setSenha("");
        page.entrar();

        //reset de massa de dados
        page.reset();

    }

}
