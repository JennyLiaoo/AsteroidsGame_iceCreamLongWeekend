import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public class Asteroid extends Entity{
    public Asteroid(int level, double x, double y, double angle) {

        this.lvl = level;
        position = new PVector(x,y);
        velocity = new PVector();
        velocity.setSize(Math.random()*3+0.5);
        velocity.setAngle(angle);
        if(level == 1) {
            picture = new Image("file:src/Images/Icons_22.png");
            size = 50;
        }
        else if(level == 2) {
            picture = new Image("file:src/Images/Icons_23.png");
            size = 75;
        }
        else if(level == 3) {
            picture = new Image("file:src/Images/Icons_24.png");
            size = 100;
        }
    }

    public double getAngle() {return velocity.getAngle();}
    public void draw(GraphicsContext pen) {
        pen.drawImage(picture, position.getX(), position.getY(), size, size);
    }

    @Override
    public boolean isColliding(GameObject other) {
        PVector otherPosition = other.getPos();
        double otherRadius = other.getSize();

        double dx = position.getX() - otherPosition.getX();
        double dy = position.getY() - otherPosition.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance < (this.getSize() + otherRadius);
    }
}
