package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;

public class SaldoTest extends BaseTest {

    HomePage page = new HomePage();

    @Test
    public void SaldoConta() {

        page.telaHome();

        Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
    }
}
