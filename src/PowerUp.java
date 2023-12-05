//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PowerUp extends GameObject {
    public PowerUp(double x, double y) {
        this.position = new PVector(x, y);
        this.size = 30;
        this.picture = new Image("file:src/Images/Icons_22.png");
        this.goodGuy = 1;
    }

    public void draw(GraphicsContext pen) {
        pen.drawImage(this.picture, this.position.getX(), this.position.getY(), (double)this.size, (double)this.size);
    }

    public ArrayList<GameObject> handleCollision(boolean good) {
        return null;
    }

    public double getAngle() {
        return 0.0;
    }

    public void move() {
    }

    public int getLevel() {
        return 1;
    }
}
