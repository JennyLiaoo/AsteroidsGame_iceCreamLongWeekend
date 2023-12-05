import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;


public class Asteroid extends Entity{
    public Asteroid(int level, double x, double y, double angle) {

        this.lvl = level;
        position = new PVector(x,y);
        velocity = new PVector();
        velocity.setSize(Math.random()*3+0.5);
        velocity.setAngle(angle);
        goodGuy=0;
        if(level == 1) {
            picture = new Image("file:src/Images/asteroid_level1.png");
            size = 50;
        }
        else if(level == 2) {
            picture = new Image("file:src/Images/asteroid_level2.png");
            size = 75;
        }
        else if(level == 3) {
            picture = new Image("file:src/Images/asteroid_level3.png");
            size = 100;
        }
    }
    public Asteroid replaceAsteroid(int level, PVector pos) {
        double angle = Math.random()*360;
        Asteroid a = new Asteroid(level-1, pos.getX(), pos.getY(), angle);

        return a;

    }
    public Asteroid enhanceAsteroid(int level, PVector pos, double angle) {
        Asteroid a = new Asteroid(level+1, pos.getX(), pos.getY(), angle);
        a.move();
        return a;

    }
    public double getAngle() {return velocity.getAngle();}
    public void draw(GraphicsContext pen) {
        pen.drawImage(picture, position.getX()-size/4.0, position.getY()-size/4.0, size, size);
    }

    public ArrayList<GameObject> handleCollision(boolean good) {
        ArrayList<GameObject> temp = new ArrayList<>();
        double r = Math.random()*360;
        if(good) {
            if(lvl != 3) {
                temp.add(enhanceAsteroid(lvl, position, r));
            }
            else {

                int counter = 0;
                temp.add(new Asteroid(3, position.getX(), position.getY(), r));
                while (counter < 3) {
                    //double angle = Math.random()*360;
                    temp.add(new Asteroid(1, position.getX(), position.getY(), r));
                    counter++;
                }
            }
        }
        else {
            if(getLevel() != 1) {
                temp.add(replaceAsteroid(getLevel(), getPos()));
                temp.add(replaceAsteroid(getLevel(), getPos()));
            }
        }
        return temp;

    }
}
