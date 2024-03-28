package extensions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuiceModule;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

//import java.security.AccessController;
//import java.security.PrivilegedAction;


public class UIExtension implements BeforeEachCallback, AfterEachCallback {

  private Injector injector;


  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    injector = Guice.createInjector(new GuiceModule());

    extensionContext.getTestInstance()
        .ifPresent(instance -> {
          injector.injectMembers(instance);
        });
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) {
    extensionContext.getTestInstance()
        .ifPresent(instance -> {
          WebDriver driver = injector.getProvider(WebDriver.class).get();
          if (driver != null) {
            driver.quit();
          }
        });
  }
}
