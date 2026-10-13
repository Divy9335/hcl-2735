package HCL_Assessment_2_COREJAVA_230032153007_DivySingh.LibraryItemClasses;

public abstract class Magazines {
    private String magazineName;
    private int countOfMagazine;

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public int getCountOfMagazine() {
        return countOfMagazine;
    }

    public void setCountOfMagazine(int countOfMagazine) {
        this.countOfMagazine = countOfMagazine;
    }
}
