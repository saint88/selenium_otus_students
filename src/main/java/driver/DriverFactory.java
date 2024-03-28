package driver;

import driver.impl.ChromeWebDriver;
import driver.impl.IDriver;
import exceptions.DriverTypeNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
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

  @Override
  public WebDriver getDriver() {

    switch (this.browserType) {
      case "chrome": {

        WebDriverManager.chromiumdriver().setup();

        IDriver<ChromeOptions> browserSettings = new ChromeWebDriver();

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
