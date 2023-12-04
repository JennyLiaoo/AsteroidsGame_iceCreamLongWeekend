import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class PowerUp extends GameObject{

    public PowerUp (double x, double y) {
        position = new PVector(x,y);
        size = 30;
        picture = new Image("file:src/Images/Icons_22.png"); //change
    }
    @Override
    public void draw(GraphicsContext pen) {
        pen.drawImage(picture, position.getX(), position.getY(), size, size);
    }


    @Override
    public boolean isColliding(GameObject other) {
        return false;
    }
}
