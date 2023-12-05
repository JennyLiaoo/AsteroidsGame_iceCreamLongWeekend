//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class PowerFactory {
    public PowerFactory() {
    }

    public static PowerUp getPower() {
        double xPos = Math.random() * 750.0 + 20.0;
        double yPos = Math.random() * 550.0 + 20.0;
        return new PowerUp(xPos, yPos);
    }
}
