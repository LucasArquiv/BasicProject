package core;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>() {

        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;
        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
            switch (Propriedades.BROWSER) {
                case FIREFOX -> new FirefoxDriver();
                case CHROME -> new ChromeDriver();
            }
        }
        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            switch (Propriedades.BROWSER) { // Instancia conforme a propriedade setada
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                    firefoxOptions.merge(capabilities);
                    break;
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    chromeOptions.merge(capabilities);
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.1.8:4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                System.err.println("Falha na conexão com o GRID");
                throw new RuntimeException(e);
            }
        }
        assert driver != null;
        driver.manage().window().setPosition(new Point(1200, 700));
        return driver;
    }

    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
        }
        threadDriver.remove();
    }
}
