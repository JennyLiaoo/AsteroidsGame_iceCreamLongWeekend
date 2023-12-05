//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject implements Collideable, Drawable, Moveable, Splittable {
    protected PVector position;
    protected Image picture;
    protected int size;
    protected int goodGuy;

    public GameObject() {
    }

    public abstract void draw(GraphicsContext var1);

    public int getSize() {
        return this.size;
    }

    public PVector getPos() {
        return this.position;
    }

    public boolean isColliding(GameObject other) {
        PVector otherPosition = other.getPos();
        double thisRadius = (double)this.getSize() / 2.0;
        double otherRadius = (double)other.getSize() / 2.0;
        double thisMidPointX = this.position.getX() + thisRadius;
        double thisMidPointY = this.position.getY() + thisRadius;
        double otherMidPointX = otherPosition.getX() + otherRadius;
        double otherMidPointY = otherPosition.getY() + otherRadius;
        double dx = thisMidPointX - otherMidPointX;
        double dy = thisMidPointY - otherMidPointY;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < thisRadius + otherRadius;
    }

    public boolean isGoodGuy() {
        return this.goodGuy == 1;
    }

    public abstract ArrayList<GameObject> handleCollision(boolean var1);
}
