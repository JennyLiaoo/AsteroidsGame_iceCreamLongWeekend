//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class AlienFactory {
    public AlienFactory() {
    }

    public static Alien getAlien() {
        double xPos = Math.random() * 790.0 + 10.0;
        double yPos = Math.random() * 590.0 + 10.0;
        double angle = Math.random() * 360.0;
        return new Alien(xPos, yPos, angle);
    }

    public double getAngle(double x, double y) {
        if (x <= 0.0) {
            return Math.random() * 178.0 - 89.0;
        } else if (x >= 750.0) {
            return Math.random() * 178.0 + 91.0;
        } else {
            return y >= 550.0 ? Math.random() * 178.0 + 181.0 : Math.random() * 178.0 + 1.0;
        }
    }
}
