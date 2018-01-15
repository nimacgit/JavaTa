package bp.java.ta.models;

public class Apple extends Cell{
    public Apple(int x, int y)
    {
        super(x, y);
        iconPath = "../icons/apple.png";
    }
    @Override
    public String getIconPath() {
        return iconPath;
    }
}
