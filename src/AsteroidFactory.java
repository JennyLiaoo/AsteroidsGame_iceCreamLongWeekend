//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class AsteroidFactory {
    public AsteroidFactory() {
    }

    public static Asteroid getAsteroid(int lvl) {
        int side = (int)(Math.random() * 3.0 + 1.0);
        double xPos;
        double yPos;
        double angle;
        if (side == 1) {
            xPos = Math.random() * 1400.0 - 200.0;
            yPos = Math.random() * 100.0 - 200.0;
            angle = Math.random() * 180.0;
            return new Asteroid(lvl, xPos, yPos, angle);
        } else if (side == 2) {
            xPos = Math.random() * 200.0 + 800.0;
            yPos = Math.random() * 1000.0 - 200.0;
            angle = Math.random() * 180.0 + 90.0;
            return new Asteroid(lvl, xPos, yPos, angle);
        } else if (side == 3) {
            xPos = Math.random() * 1200.0 - 200.0;
            yPos = Math.random() * 200.0 + 600.0;
            angle = Math.random() * 180.0 + 180.0;
            return new Asteroid(lvl, xPos, yPos, angle);
        } else {
            xPos = Math.random() * 200.0 - 200.0;
            yPos = Math.random() * 1000.0 - 200.0;
            angle = Math.random() * 180.0 - 90.0;
            return new Asteroid(lvl, xPos, yPos, angle);
        }
    }

    public static Asteroid getAsteroid(double x, double y) {
        double angle = Math.random() * 360.0;
        return new Asteroid(1, x, y, angle);
    }
}
