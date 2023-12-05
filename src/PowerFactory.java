public class PowerFactory {
    public static PowerUp getPower() {
            double xPos = Math.random()*750+20;
            double yPos = Math.random()* 550+20;
            return new PowerUp(xPos, yPos);

    }
}
