
import javafx.scene.canvas.GraphicsContext;
public abstract class Entity extends GameObject implements Collideable, Drawable, Moveable, Splittable{
    protected PVector velocity;
    protected double rotation;
    protected int lvl;

    public void move() {
        position.add(velocity.getX(), velocity.getY());
    }
    public abstract void draw(GraphicsContext pen);
    public double getAngle() {
        return rotation;
    }
    public int getLevel() {
        return lvl;
    }
}
