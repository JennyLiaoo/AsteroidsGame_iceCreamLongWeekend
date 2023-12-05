/**
 * Holds all information about powers
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
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

    /**
     * Handles collision, returns null to tell LvlHandler to delete it
     * @param good, boolean
     * @return ArrayList<GameObject>
     */
    @Override
    public ArrayList<GameObject> handleCollision(boolean good) {
        return null;
    }

    /**
     * In an improved project, the power ups would move too, but in specific ways different to asteroids and aliens
     */
    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public void move() {}
}
