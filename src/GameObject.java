/**
 * GameObject class for all objects within the game, checks for their collisions
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class GameObject implements Collideable, Drawable, Moveable{
    protected PVector position;
    protected Image picture;
    protected int size;
    protected int goodGuy;

    public abstract void draw(GraphicsContext pen);
    public int getSize() {return size;}
    public PVector getPos() {
        return position;
    }

    /**
     * Checks if the object is colliding with another gameObject
     * @param other, GameObject
     * @return boolean
     */
    public boolean isColliding(GameObject other) {
        PVector otherPosition = other.getPos();
        double thisRadius = this.getSize()/2.0;
        double otherRadius = other.getSize()/2.0;
        double thisMidPointX = position.getX() + thisRadius;
        double thisMidPointY = position.getY() + thisRadius;
        double otherMidPointX = otherPosition.getX() + otherRadius;
        double otherMidPointY = otherPosition.getY() + otherRadius;
        double dx = thisMidPointX- otherMidPointX;
        double dy = thisMidPointY - otherMidPointY;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < (thisRadius + otherRadius);
    }
    /**
     * Checks if the object is a good entity (good entities help whatever it collides with)
     * @return boolean
     */
    public boolean isGoodGuy() {
        if(goodGuy == 1) {
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * abstract class that all gameObjects must have
     * @return ArrayList<GameObject>
     */
    public abstract ArrayList<GameObject> handleCollision(boolean good);
}
