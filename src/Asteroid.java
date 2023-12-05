//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Asteroid extends Entity {
    public Asteroid(int level, double x, double y, double angle) {
        this.lvl = level;
        this.position = new PVector(x, y);
        this.velocity = new PVector();
        this.velocity.setSize(Math.random() * 3.0 + 0.5);
        this.velocity.setAngle(angle);
        this.goodGuy = 0;
        if (level == 1) {
            this.picture = new Image("file:src/Images/asteroid_level1.png");
            this.size = 50;
        } else if (level == 2) {
            this.picture = new Image("file:src/Images/asteroid_level2.png");
            this.size = 75;
        } else if (level == 3) {
            this.picture = new Image("file:src/Images/asteroid_level3.png");
            this.size = 100;
        }

    }

    public Asteroid replaceAsteroid(int level, PVector pos) {
        double angle = Math.random() * 360.0;
        Asteroid a = new Asteroid(level - 1, pos.getX(), pos.getY(), angle);
        return a;
    }

    public Asteroid enhanceAsteroid(int level, PVector pos, double angle) {
        Asteroid a = new Asteroid(level + 1, pos.getX(), pos.getY(), angle);
        a.move();
        return a;
    }

    public double getAngle() {
        return this.velocity.getAngle();
    }

    public void draw(GraphicsContext pen) {
        pen.drawImage(this.picture, this.position.getX() - (double)this.size / 4.0, this.position.getY() - (double)this.size / 4.0, (double)this.size, (double)this.size);
    }

    public ArrayList<GameObject> handleCollision(boolean good) {
        ArrayList<GameObject> temp = new ArrayList();
        double r = Math.random() * 360.0;
        if (good) {
            if (this.lvl != 3) {
                temp.add(this.enhanceAsteroid(this.lvl, this.position, r));
            } else {
                int counter = 0;
                temp.add(new Asteroid(3, this.position.getX(), this.position.getY(), r));

                while(counter < 3) {
                    temp.add(new Asteroid(1, this.position.getX(), this.position.getY(), r));
                    ++counter;
                }
            }
        } else if (this.getLevel() != 1) {
            temp.add(this.replaceAsteroid(this.getLevel(), this.getPos()));
            temp.add(this.replaceAsteroid(this.getLevel(), this.getPos()));
        }

        return temp;
    }
}
