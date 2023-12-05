/**
 * Has all bullet information
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
public class Bullet extends Entity{
    public Bullet(double rot, double x, double y) {
        size = 5;
        picture = new Image("images/0spaceshipCropped.png");
        position = new PVector(x, y);
        velocity = new PVector();
        velocity.setSize(7);
        rotation = rot;
        velocity.setAngle(rotation);
        lvl = 1;
        goodGuy = 0;
    }
    public void draw(GraphicsContext pen) {pen.drawImage(picture, position.getX(), position.getY(), size, size);
    }
    public void setRotation(double r) {
        rotation = r;
        velocity.setAngle(rotation);
    }

    /**
     * Handles collision with bullets, returns null to tell LvlHandler to delete it
     * @param good, boolean
     * @return ArrayList<GameObject>
     */
    @Override
    public ArrayList<GameObject> handleCollision(boolean good) {
        return null;
    }
}
