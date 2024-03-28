package pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import annotations.PageValidation;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@PageValidation("template://div[text()='%s']")
public class InstructorPage extends AnyPageAbs<InstructorPage> {

  public InstructorPage(WebDriver driver) {
    super(driver);
  }

  public InstructorPage pageShouldBeOpened(String name) {
    String locator = String.format(markerLocator, name);

    assertThat(standartWaiter.waitForElementVisible($(By.xpath(locator))))
        .as("Error")
        .isTrue();

    return this;
  }




}
