import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class PowerUp extends GameObject{

    public PowerUp (double x, double y) {
        position = new PVector(x,y);
        size = 30;
        picture = new Image("file:src/Images/Icons_22.png"); //change
        goodGuy = 1;
    }
    @Override
    public void draw(GraphicsContext pen) {
        pen.drawImage(picture, position.getX(), position.getY(), size, size);
    }

    @Override
    public ArrayList<GameObject> handleCollision(boolean good) {
        return null;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public void move() {

    }
}
