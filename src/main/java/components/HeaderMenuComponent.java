package components;

import annotations.Component;
import data.menu.CourcesData;
import data.menu.MenuItemData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LessonsPage;

@Component("//*[contains(@class, 'header2-menu_main')]")
public class HeaderMenuComponent extends AnyComponentAbs<HeaderMenuComponent> {

  public HeaderMenuComponent(WebDriver driver) {
    super(driver);
  }

  private String menuItemLocator = baseLocator + "//*[contains(@class, 'header2-menu__item_dropdown')][.//*[contains(@class, 'header2-menu__item')][text()='%s']]";
  private String menuItemDropdownListLocator = menuItemLocator + "//*[@class='header2-menu__dropdown']";

  public HeaderMenuComponent moveToMenuItem(MenuItemData menuItemData) {
    WebElement menuItemElement = driver.findElement(By.xpath(String.format(menuItemLocator, menuItemData.getName())));
    actions.moveToElement(menuItemElement).build().perform();

    return this;
  }

  public HeaderMenuComponent checkSubMenuListVisible(MenuItemData menuItemData) {
    assert standartWaiter.waitForElementVisible(
        driver.findElement(By.xpath(String.format(menuItemDropdownListLocator, menuItemData.getName())))
    ): "Sub menu not visible";

    return this;
  }

  @Step("Проверяем, что подменю {menuItemData} не отображается на странице")
  public HeaderMenuComponent checkSubMenuListNotVisible(MenuItemData menuItemData) {
    assert standartWaiter.waitForElementNotVisible(
        driver.findElement(By.xpath(String.format(menuItemDropdownListLocator, menuItemData.getName())))
    ): "Sub menu visible";

    return this;
  }

  public LessonsPage clickCourseItem(CourcesData courcesData) {
    String baseCourseTypeLocator = menuItemDropdownListLocator + "/*[contains(@class, 'header2-menu__subdropdown-wrapper')][.//a[@title='%s']]";
    WebElement baseCourceElement = driver.findElement(By.xpath(String.format(baseCourseTypeLocator, MenuItemData.Courses.getName(), courcesData.getCourceTypeData().getName())));

    actions.moveToElement(baseCourceElement).build().perform();
    assert standartWaiter.waitForCondition(ExpectedConditions.attributeContains(baseCourceElement, "class", "header2-menu__dropdown-wrapper_open")): "";

    baseCourceElement.findElement(By.xpath(String.format(".//a[@title='%s']", courcesData.getName()))).click();

    return new LessonsPage(driver);
  }

}
