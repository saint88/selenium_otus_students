package actions;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waiters.StandartWaiter;

public class Button<T> {

  @Inject
  private WebDriver driver;

  private WebElement element;

  public Button(By locator) {
    element = driver.findElement(locator);
  }

  public T click() {
    element.click();
    new StandartWaiter(driver).waitForElementVisible(element);

    return (T)this;
  }

}
