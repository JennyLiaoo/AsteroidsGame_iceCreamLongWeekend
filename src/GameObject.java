import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject implements Collideable, Drawable{
    protected PVector position;
    protected Image picture;
    protected int size;

    public abstract void draw(GraphicsContext pen);
    public int getSize() {return size;}
    public PVector getPos() {
        return position;
    }

    public boolean isColliding(GameObject other) {
        PVector otherPosition = other.getPos();
        double otherRadius = other.getSize();

        double dx = position.getX() - otherPosition.getX();
        double dy = position.getY() - otherPosition.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance < (this.getSize() + otherRadius);
    }


}
