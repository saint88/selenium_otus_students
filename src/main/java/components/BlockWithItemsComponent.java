package components;

import annotations.Component;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.InstructorPage;

import java.util.List;

@Component("xpath://section[.//*[text()='%s']]")
public class BlockWithItemsComponent extends AnyComponentAbs<BlockWithItemsComponent> {

  public BlockWithItemsComponent(WebDriver driver) {
    super(driver);
  }

  public InstructorPage clickItem(String name) {
    getComponentEntity().findElement(By.xpath(String.format(".//a[.//div[text()='%s']]", name))).click();

    return new InstructorPage(driver);
  }

  public String getItemName(int index) {
    return getComponentEntity().findElements(By.xpath(".//a[./div]")).get(--index).findElement(By.xpath(".//div[2]")).getText();
  }


}
