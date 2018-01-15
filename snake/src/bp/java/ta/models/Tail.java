package bp.java.ta.models;

public class Tail extends MovableThings {
    public Tail(int x, int y, int d) {
        super(x, y, d);
        iconPath = "../icons/tail";
    }

    @Override
    public String getIconPath() {
        switch (dir) {
            case 0:
                return iconPath + "U.png";
            case 1:
                return iconPath + "R.png";
            case 2:
                return iconPath + "D.png";
            case 3:
                return iconPath + "L.png";
            default:
                return "U.png";
        }
    }

}
