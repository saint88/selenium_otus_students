package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import components.FavouriteCourses;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class GuiceModule extends AbstractModule {
  private final WebDriver driver = new DriverFactory().getDriver();

  @Provides
  public WebDriver getDriver() {
    return driver;
  }

//  @Provides
//  @Singleton
//  public MainPage getMainPage() {
//    return new MainPage(driver);
//  }

//  @Provides
//  @Singleton
//  public FavouriteCourses getFavoriteCources() {
//    return new FavouriteCourses(driver);
//  }
}
