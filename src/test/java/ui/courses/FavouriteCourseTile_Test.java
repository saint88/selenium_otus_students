package ui.courses;

import annotations.Driver;
import components.FavouriteCourses;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class FavouriteCourseTile_Test {

  @Driver
  public WebDriver driver;

  @Test
  public void click_favourite_course_tile() {
    new MainPage(driver).open();

    new FavouriteCourses(driver)
        .clickLessonItem()
        .getPageTitle();
  }

}
