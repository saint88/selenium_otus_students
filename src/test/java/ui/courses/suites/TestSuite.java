package ui.courses.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import ui.courses.FavouriteCourseTile_Test;
import ui.courses.HeaderMenu_Test;

@Suite
@SelectClasses({
    FavouriteCourseTile_Test.class,
    HeaderMenu_Test.class
})
public class TestSuite {}
