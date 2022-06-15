package data.menu;

public enum CourcesData {
  Highload_Architect("Highload Architect", CourceTypeData.Programmer);

  private String name;
  private CourceTypeData courceTypeData;

  CourcesData(String name, CourceTypeData courceTypeData) {
    this.name = name;
    this.courceTypeData = courceTypeData;
  }

  public String getName() {
    return name;
  }

  public CourceTypeData getCourceTypeData() {
    return courceTypeData;
  }
}
