package data.menu;

public enum CourceTypeData {
  Programmer("Программирование");

  private String name;

  CourceTypeData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
