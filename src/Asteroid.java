/**
 * Asteroids hurray! This class holds all information about asteroids
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
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
        if(level == 1) {                    //creates different asteroid based on its level
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


    /**
     * replaces Asteroid after it gets hit with lower level asteroid
     * @param level, int
     * @param pos, PVector
     * @return Asteroid
     */
    public Asteroid replaceAsteroid(int level, PVector pos) {
        double angle = Math.random()*360;
        Asteroid a = new Asteroid(level-1, pos.getX(), pos.getY(), angle);
        return a;
    }

    /**
     * Enhance Asteroid into a stronger Asteroid, with a higher level
     * @param level, int
     * @param pos, PVector
     * @param angle, double
     * @return Asteroid
     */
    public Asteroid enhanceAsteroid(int level, PVector pos, double angle) {
        Asteroid a = new Asteroid(level+1, pos.getX(), pos.getY(), angle);
        a.move();
        return a;

    }
    public double getAngle() {return velocity.getAngle();}
    public void draw(GraphicsContext pen) {pen.drawImage(picture, position.getX()-size/4.0, position.getY()-size/4.0, size, size);}

    /**
     * Asteroid handles what happens to itself if it collides. For example, it may split into multiple smaller asteroids
     * @param good, boolean
     * @return Asteroid
     */
    public ArrayList<GameObject> handleCollision(boolean good) {
        ArrayList<GameObject> temp = new ArrayList<>();
        double r = Math.random()*360;
        if(good) {
            if(lvl != 3) {temp.add(enhanceAsteroid(lvl, position, r));}
            else {
                int counter = 0;
                temp.add(new Asteroid(3, position.getX(), position.getY(), r));
                while (counter < 3) {
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