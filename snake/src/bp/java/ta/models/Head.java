package bp.java.ta.models;

public class Head extends MovableThings{


    public Head(int x, int y, int d) {
        super(x, y, d);
        iconPath = "../icons/head";
    }

    @Override
    public String getIconPath() {
        switch (dir){
            case 0:
                return this.iconPath + "U.png";
            case 1:
                return this.iconPath + "R.png";
            case 2:
                return this.iconPath + "D.png";
            case 3:
                return this.iconPath + "L.png";
            default:
                return "U.png";
        }
    }


}
