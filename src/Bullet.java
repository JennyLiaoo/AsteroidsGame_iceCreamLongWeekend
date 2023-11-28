import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class Bullet extends Entity{
    public Bullet(double rot, double x, double y) {
        size = 20;
        picture = new Image("images/spaceship.png");
        position = new PVector(x, y);
        velocity = new PVector();
        velocity.setSize(5);
        rotation = rot;
        velocity.setAngle(rotation);
        lvl = 1;
    }
    public void draw(GraphicsContext pen) {pen.drawImage(picture, position.getX(), position.getY(), size, size);
    }
    public void setRotation(double r) {
        rotation = r;
        velocity.setAngle(rotation);
    }

    @Override
    public boolean isColliding(GameObject other) {
        PVector otherPosition = other.getPos();
        double otherRadius = other.getSize();

        double dx = position.getX() - otherPosition.getX();
        double dy = position.getY() - otherPosition.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance < ((double) this.getSize() /2 + otherRadius/2);
    }
}
