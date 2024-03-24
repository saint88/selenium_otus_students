package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import components.FavouriteCourses;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ComponentGuiceModule extends AbstractModule {

  private final WebDriver driver = new DriverFactory().getDriver();

  @Provides
  @Singleton
  public FavouriteCourses getFavoriteCources() {
    return new FavouriteCourses(driver);
  }
}
