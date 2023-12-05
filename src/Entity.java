/**
 * Entity abstract class for all interacting "things" within the game that move
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
import javafx.scene.canvas.GraphicsContext;
public abstract class Entity extends GameObject implements Moveable, Splittable{     //implements interfaces
    //instance variables for all entities
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
