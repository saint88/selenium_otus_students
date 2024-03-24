package driver;

import driver.impl.ChromeWebDriver;
import driver.impl.IDriver;
import exceptions.DriverTypeNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ActionsListener;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class DriverFactory implements IDriverFactory {

  private String browserType = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);

  private static BrowserMobProxy proxy = null;

  @Override
  public WebDriver getDriver() {

    if(proxy == null) {
     proxy = new BrowserMobProxyServer();
    }
    if(!proxy.isStarted()) {
      proxy.start(4444);
    }

    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

    switch (this.browserType) {
      case "chrome": {
        WebDriverManager.chromedriver().setup();
        IDriver<ChromeOptions> browserSettings = new ChromeWebDriver();
        browserSettings.getDriverOptions().setCapability(CapabilityType.PROXY, seleniumProxy);

        return new EventFiringDecorator<>(new ActionsListener())
            .decorate(new ChromeDriver(browserSettings.getDriverOptions()));
      }
      default:
        try {
          throw new DriverTypeNotSupported(this.browserType);
        } catch (DriverTypeNotSupported ex) {
          ex.printStackTrace();
          return null;
        }
    }
  }
}
