package extensions;

import annotations.Driver;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import driver.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import listeners.MouseListener;
import modules.ComponentGuiceModule;
import modules.GuiceModule;
import modules.GuicePageModule;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.ByteArrayInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
//import java.security.AccessController;
//import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.Set;

public class UIExtension implements BeforeEachCallback, AfterEachCallback, BeforeAllCallback {

//  private EventFiringWebDriver driver = null;
  private Injector injector;
  private Proxy seleniumProxy;

    @Override
  public void beforeAll(ExtensionContext extensionContext) throws Exception {
    BrowserMobProxy proxy = new BrowserMobProxyServer();
    proxy.start(4444);
//    int port = proxy.getPort();
//      seleniumProxy = ClientUtil.createSeleniumProxy(proxy);



  }

  //  @Override
//  public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
//    boolean testResult = extensionContext.getExecutionException().isPresent();
//    if(testResult) {
//      Allure.addAttachment("Failed screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//    }
//  }

//  private Set<Field> getAnnotatedFields(Class<? extends Annotation> annotation, ExtensionContext extensionContext) {
//    Set<Field> set = new HashSet<>();
//    Class<?> testClass = extensionContext.getTestClass().get();
//    while (testClass != null) {
//      for (Field field : testClass.getDeclaredFields()) {
//        if (field.isAnnotationPresent(annotation)) {
//          set.add(field);
//        }
//      }
//      testClass = testClass.getSuperclass();
//    }
//    return set;
//  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    extensionContext.getTestInstance()
        .ifPresent(instance -> {
          injector = Guice.createInjector(new GuiceModule(), new ComponentGuiceModule(), new GuicePageModule());
          injector.injectMembers(instance);
        });
//    driver = new DriverFactory().getDriver();
//    driver.register(new MouseListener());
//    Set<Field> fields = getAnnotatedFields(Driver.class, extensionContext);
//
//    for (Field field : fields) {
//      if (field.getType().getName().equals(WebDriver.class.getName())) {
//        AccessController.doPrivileged((PrivilegedAction<Void>)
//            () -> {
//              try {
//                field.setAccessible(true);
//                field.set(extensionContext.getTestInstance().get(), driver);
//              } catch (IllegalAccessException e) {
//                throw new Error(String.format("Could not access or set webdriver in field: %s - is this field public?", field), e);
//              }
//              return null;
//            }
//        );
//      }
//    }
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
//    if(driver != null) {
//      driver.close();
//      driver.quit();
//    }
  }
}
