package pages;

import annotations.UrlPrefix;
import org.openqa.selenium.WebDriver;

@UrlPrefix("/")
public class MainPage extends AnyPageAbs<MainPage> {

  public MainPage(WebDriver driver) {
    super(driver);
  }
}
