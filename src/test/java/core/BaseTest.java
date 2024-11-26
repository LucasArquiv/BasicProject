package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    private final LoginPage page = new LoginPage();

    @Before
    public void inicilizar() {
        page.acessoTelaInicial();

        //coloque seu login do site aqui
        page.setEmail("");
        page.setSenha("");
        page.entrar();
    }

    @After
    public void finaliza() throws IOException {

        TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator +
                "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

        if (Propriedades.FECHAR_BROWSER) {
            killDriver();
        }

    }
}
