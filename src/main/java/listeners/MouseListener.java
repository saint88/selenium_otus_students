package listeners;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MouseListener implements WebDriverEventListener {

  @Override
  public void beforeAlertAccept(WebDriver driver) {

  }

  @Override
  public void afterAlertAccept(WebDriver driver) {

  }

  @Override
  public void afterAlertDismiss(WebDriver driver) {

  }

  @Override
  public void beforeAlertDismiss(WebDriver driver) {

  }

  @Override
  public void beforeNavigateTo(String url, WebDriver driver) {

  }

  @Override
  public void afterNavigateTo(String url, WebDriver driver) {

  }

  @Override
  public void beforeNavigateBack(WebDriver driver) {

  }

  @Override
  public void afterNavigateBack(WebDriver driver) {

  }

  @Override
  public void beforeNavigateForward(WebDriver driver) {

  }

  @Override
  public void afterNavigateForward(WebDriver driver) {

  }

  @Override
  public void beforeNavigateRefresh(WebDriver driver) {

  }

  @Override
  public void afterNavigateRefresh(WebDriver driver) {

  }

  @Override
  public void beforeFindBy(By by, WebElement element, WebDriver driver) {

  }

  @Override
  public void afterFindBy(By by, WebElement element, WebDriver driver) {

  }

  @Override
  public void beforeClickOn(WebElement element, WebDriver driver) {
    ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red;'", element);
  }

  @Override
  public void afterClickOn(WebElement element, WebDriver driver) {
    ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red;'", element);
  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

  }

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

  }

  @Override
  public void beforeScript(String script, WebDriver driver) {

  }

  @Override
  public void afterScript(String script, WebDriver driver) {

  }

  @Override
  public void beforeSwitchToWindow(String windowName, WebDriver driver) {

  }

  @Override
  public void afterSwitchToWindow(String windowName, WebDriver driver) {

  }

  @Override
  public void onException(Throwable throwable, WebDriver driver) {

  }

  @Override
  public <X> void beforeGetScreenshotAs(OutputType<X> target) {

  }

  @Override
  public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

  }

  @Override
  public void beforeGetText(WebElement element, WebDriver driver) {

  }

  @Override
  public void afterGetText(WebElement element, WebDriver driver, String text) {

  }
}
