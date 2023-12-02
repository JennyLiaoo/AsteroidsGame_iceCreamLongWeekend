import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class Player extends Shooters{

    private Image user = new Image("file:src/Images/spaceship.png");
    private int timer;
    public Player(int level, double x, double y) {
        size = 80;
        this.position= new PVector(x, y);
        this.velocity = new PVector(0, 0);
        this.rotation = 0;
        lvl = level;
        b = new ArrayList<>();
        timer = 0;

    }
    public void accelerate() {

        if(velocity.getSize() <= 5) {
            velocity.setSize(velocity.getSize()+0.5);
        }
        else{
            velocity.setSize(velocity.getSize());
        }
        velocity.setAngle(rotation);
        rotation = velocity.getAngle();     //testing
    }
    public void deccelerate() {
        velocity.setSize(velocity.getSize()-0.01);
    }
    public void shoot() {
        if(timer == 0) {
            Bullet temp = new Bullet(this.rotation, this.position.getX(), this.position.getY());
            b.add(temp);
        }
        else {
            shootEnhanced();
            timer--;
        }

    }

    public Bullet shootCreate() {
        return new Bullet(this.rotation, this.position.getX(), this.position.getY());
    }
    public void shootEnhanced() {
        double tempAngle = 0;
        while(tempAngle <= 360) {
            Bullet temp = new Bullet(tempAngle, this.position.getX(), this.position.getY());
            b.add(temp);
            tempAngle +=20;
        }

    }
    public void turnRight() {
        rotation += 10;
    }
    public void turnLeft() {
        rotation -= 10;
    }

    @Override
    public void move() {
        super.move();
        for(int i = 0; i < b.size(); i++) {
            b.get(i).move();
        }
        if(timer > 0) {
            timer--;
        }
    }
    public void draw(GraphicsContext pen) {
        move();
        pen.drawImage(user, -size/2, -size/2, size, size);

    }
    public void drawBul(GraphicsContext pen) {
        for(int i = 0; i < b.size(); i++) {
            b.get(i).move();
            b.get(i).draw(pen);
            if(b.get(i).getPos().getX() >= 800 || b.get(i).getPos().getY() >= 610 || b.get(i).getPos().getX() <= -10 || b.get(i).getPos().getY() <= -10) {
                b.remove(i);
                i--;
            }
        }
    }
    public void setPos(double x, double y) { position = new PVector(x, y);}


    public void setTime() {
        timer = 100;
    }
    /*
    public boolean isCollidingChange(GameObject other) {
        if(isColliding(other)) {
            if(other.getIdentity() == 1) {
                timer = 80;
            }
            else {
                decreaseLevel();

            }
        }

        return ;
    }

     */
    public ArrayList<Bullet> getBullets() {
        return b;
    }
    public void decreaseLevel() {
        lvl--;
        position.setPos(400, 300);
    }
    public int getTimer() {
        return timer;
    }
    public void setTimer(int t) {
        timer = t;
    }
}
