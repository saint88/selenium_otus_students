package pages;

import actions.CommonActions;
import annotations.PageValidation;
import annotations.UrlPrefix;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AnyPageAbs<T> extends CommonActions<T> {

  protected String markerLocator = "";

  public AnyPageAbs(WebDriver driver) {
    super(driver);
    markerLocator = pageValidation();
  }

  private String pageValidation() {
    if(getClass().isAnnotationPresent(PageValidation.class)) {
      PageValidation pageValidation = getClass().getAnnotation(PageValidation.class);
      String markerElementLocator = pageValidation.value();
      if(markerElementLocator.startsWith("template:")) {
        return markerElementLocator.replace("template:", "");
      }

      By locator = null;
      if(markerElementLocator.startsWith("/")) {
        locator = By.xpath(markerElementLocator);
      } else {
        locator = By.cssSelector(markerElementLocator);
      }

      standartWaiter.waitForElementVisible($(locator));
    }

    return "";
  }

  private String getBaseUrl() {
    return StringUtils.stripEnd(System.getProperty("webdriver.base.url", "https://otus.ru"), "/");
  }

  private String getUrlPrefix() {
    UrlPrefix urlAnnotation = getClass().getAnnotation(UrlPrefix.class);
    if (urlAnnotation != null) {
      return urlAnnotation.value();
    }

    return "";
  }

  public T open() {
    driver.get(getBaseUrl() + getUrlPrefix());

    return (T)this;
  }

  public <T> T page(Class<T> clazz) {
    try {
      Constructor constructor = clazz.getConstructor(WebDriver.class);

      return convertInstanceOfObject(constructor.newInstance(driver), clazz);

    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
      e.printStackTrace();
    }

    return null;
  }

  private static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
    try {
      return clazz.cast(o);
    } catch (ClassCastException e) {
      return null;
    }
  }

}
