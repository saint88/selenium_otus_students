package ui.teachers;

import com.google.inject.Inject;
import components.BlockWithItemsComponent;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class TeachersBlock_Test {

  @Inject
  private MainPage mainPage;

  @Inject
  private BlockWithItemsComponent blockWithItemsComponent;

  @Test
  public void openTeacherCardByClick() {
    mainPage
        .open();

    String name = blockWithItemsComponent
        .setTitle("Преподаватели")
        .getItemName(1);
    blockWithItemsComponent
        .clickItem(name)
        .pageShouldBeOpened(name);


  }

}
