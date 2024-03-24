package ui.courses;

import annotations.Driver;
import com.google.inject.Inject;
import components.FavouriteCourses;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class FavouriteCourseTile_Test {

  @Inject
  private MainPage mainPage;

  @Inject
  private FavouriteCourses favouriteCourses;

  @Test
  public void click_favourite_course_tile() {
    mainPage.open();

    favouriteCourses
        .clickLessonItem()
        .getPageTitle();
  }

}
