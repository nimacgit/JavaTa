package bp.java.ta.models;

public class Body extends MovableThings {

    public Body(int x, int y, int d) {
        super(x, y, d);
        iconPath = "../icons/body.png";
    }

    @Override
    public String getIconPath() {
        return iconPath;
    }

}
