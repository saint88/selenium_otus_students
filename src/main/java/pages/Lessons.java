package pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lessons extends AnyPageAbs<Lessons> {

  public Lessons(WebDriver driver) {
    super(driver);
  }

  public String getPageTitle() {

//    List list = new ArrayList<>();
//    list.stream().map(Integer::parseInt).collect(Collectors.toList());

    return driver.getTitle();
  }

}
