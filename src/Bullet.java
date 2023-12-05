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

    @Override
    public ArrayList<GameObject> handleCollision(boolean good) {
        return null;
    }
}
