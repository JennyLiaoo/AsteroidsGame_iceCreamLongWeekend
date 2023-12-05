//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity extends GameObject {
    protected PVector velocity;
    protected double rotation;
    protected int lvl;

    public Entity() {
    }

    public void move() {
        this.position.add(this.velocity.getX(), this.velocity.getY());
    }

    public abstract void draw(GraphicsContext var1);

    public double getAngle() {
        return this.rotation;
    }

    public int getLevel() {
        return this.lvl;
    }
}
