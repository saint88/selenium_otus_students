package pages;

import annotations.UrlPrefix;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import components.FavouriteCourses;
import modules.ComponentGuiceModule;
import modules.GuiceModule;
import org.openqa.selenium.WebDriver;

@UrlPrefix("/")
public class MainPage extends AnyPageAbs<MainPage> {

  @Inject
  public MainPage(WebDriver driver) {
    super(driver);
  }

  private Injector injector = Guice.createInjector( new GuiceModule());


  public FavouriteCourses click() {
    return injector.getProvider(FavouriteCourses.class).get();
  }
}
