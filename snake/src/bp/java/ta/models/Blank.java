package bp.java.ta.models;

public class Blank extends Cell{

    static String iconPath = "../icons/blank.png";

    public Blank(int x, int y) {
        super(x, y);
    }

    @Override
    public String getIconPath() {
        return iconPath;
    }
}
