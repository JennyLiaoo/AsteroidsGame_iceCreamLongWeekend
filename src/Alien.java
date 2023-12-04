import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Alien extends Shooters{

    public Alien(double x, double y, double angle) {
        position = new PVector(x, y);
        velocity = new PVector(0, 0);
        picture = new Image("file:src/Images/Icons_22.png");
        velocity.setSize(Math.random()*3+0.5);
        velocity.setAngle(angle);
        b = new ArrayList<>();
        size = 50;
        lvl = 1;
    }
    public void shoot(double xPlayer, double yPlayer) { //takes player position
        double a = Math.atan2(yPlayer-position.getY(), xPlayer-position.getX());
        double temp2 = Math.toDegrees(a);
        Bullet temp = new Bullet(0, this.position.getX(), this.position.getY());
        temp.setRotation(temp2);
        b.add(temp);

    }

    public double getAngle() {
        return velocity.getAngle();

    }
    public void setAngle(double a) {
        velocity.setAngle(a);
        rotation = a;

    }
    public void draw(GraphicsContext pen) {
        pen.drawImage(picture, position.getX(), position.getY(), size, size);
        for(int i = 0; i < b.size(); i++) {
            b.get(i).move();
            b.get(i).draw(pen);
        }
    }

    @Override
    public boolean isColliding(GameObject other) {
        return false;
    }
    public ArrayList<Bullet> getBullets() {
        return b;
    }
}
