package ui.courses;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@ExtendWith(UIExtension.class)
public class Actions_Test {

  @Driver
  public WebDriver driver;

  @Test
  public void dragAndDrop() {
    driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
    WebElement elementButtonsBlock = driver.findElement(By.id("sortable"));

    WebElement charElement1 = elementButtonsBlock.findElement(By.xpath("./li[@name='B']"));
    WebElement charElement2 = elementButtonsBlock.findElement(By.xpath("./li[@name='J']"));

    Actions actions = new Actions(driver);
    actions
        .clickAndHold(charElement1)
        .moveToElement(charElement2, 10, 50)
        .click()
        .build().perform();
  }

  @Test
  public void rightClickAction() {
    driver.get("https://demo.guru99.com/test/simple_context_menu.html");

    WebElement rightButtonElement = driver.findElement(By.cssSelector("span.context-menu-one"));
    Actions actions = new Actions(driver);

    actions.contextClick(rightButtonElement).build().perform();
  }
}
