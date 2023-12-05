//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Alien extends Shooters {
    public Alien(double x, double y, double angle) {
        this.position = new PVector(x, y);
        this.velocity = new PVector(0.0, 0.0);
        this.picture = new Image("file:src/Images/Icons_22.png");
        this.velocity.setSize(Math.random() * 3.0 + 0.5);
        this.velocity.setAngle(angle);
        this.b = new ArrayList();
        this.size = 50;
        this.lvl = 3;
        this.goodGuy = 0;
    }

    public Alien(double x, double y, double angle, double speed) {
        this.position = new PVector(x, y);
        this.velocity = new PVector(0.0, 0.0);
        this.picture = new Image("file:src/Images/Icons_22.png");
        this.velocity.setSize(speed);
        this.velocity.setAngle(angle);
        this.b = new ArrayList();
        this.size = 50;
        this.lvl = 3;
        this.goodGuy = 0;
    }

    public Bullet shoot(double xPlayer, double yPlayer) {
        double a = Math.atan2(yPlayer - this.position.getY(), xPlayer - this.position.getX());
        double temp2 = Math.toDegrees(a);
        Bullet temp = new Bullet(0.0, this.position.getX(), this.position.getY());
        temp.setRotation(temp2);

        for(int i = 0; i < 17; ++i) {
            temp.move();
        }

        return temp;
    }

    public double getAngle() {
        return this.velocity.getAngle();
    }

    public void setAngle(double a) {
        this.velocity.setAngle(a);
        this.rotation = a;
    }

    public void draw(GraphicsContext pen) {
        pen.drawImage(this.picture, this.position.getX(), this.position.getY(), (double)this.size, (double)this.size);
    }

    public ArrayList<GameObject> handleCollision(boolean good) {
        ArrayList<GameObject> temp = new ArrayList();
        if (good) {
            temp.add(new Alien(this.position.getX(), this.position.getY(), this.rotation, this.velocity.getSize() + 1.0));
            return temp;
        } else {
            return null;
        }
    }
}
