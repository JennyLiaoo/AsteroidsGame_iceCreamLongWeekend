import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class Player extends Shooters{
    private GameOverCallback gameOverCallback;
    private int score;

    private Image user = new Image("file:src/Images/0spaceshipCropped.png");
    private int timer;
    public Player(int level, double x, double y) {
        size = 50;
        this.position= new PVector(x, y);
        this.velocity = new PVector(0, 0);
        this.rotation = 0;
        this.score=0;
        lvl = level;
        b = new ArrayList<>();
        timer = 0;
        goodGuy = 0;
    }
    public void incrementScore(int asteroidLevel) {
        switch (asteroidLevel) {
            case 1:
                score += 100;
                break;
            case 2:
                score += 200;
                break;
            case 3:
                score += 300;
                break;
            default:
                // Handle other cases if needed
                break;
        }
        //System.out.println("Score: " + score); // Print updated score
    }

    public int getScore() {
        return score;
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
    public Bullet shoot() {
        Bullet temp = new Bullet(this.rotation, this.position.getX(), this.position.getY());

        for(int i = 0; i < 8; i++) {
            temp.move();
        }

        return temp;
    }
    public ArrayList<Bullet> shootEnhanced() {
        ArrayList<Bullet> temporary = new ArrayList<>();
        double tempAngle = 0;
        while(tempAngle <= 360) {
            Bullet temp = new Bullet(tempAngle, this.position.getX()+size, this.position.getY()+size);
            for(int i = 0; i < 10; i++) {
                temp.move();
            }
            temporary.add(temp);
            tempAngle +=20;
        }
        return temporary;
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
        if(timer > 0) {
            timer--;
        }
    }
    public void draw(GraphicsContext pen) {
        move();
        pen.drawImage(user, -size/2.0, -size/2.0, size, size);

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

    @Override
    public ArrayList<GameObject> handleCollision(boolean good) {
        ArrayList<GameObject> temp = new ArrayList<>();
        if(good) {
            double chance = Math.random()*9+1;
            if(chance >= 5) {
                timer = 80;
            }
            else {
                lvl++;
            }
            return null;
        }
        else {
            decreaseLevel(1);
            temp.add(new Player(lvl, position.getX(), position.getY()));
        }
        return temp;
    }
    public ArrayList<Bullet> getBullets() {
        return b;
    }


    // Method to decrease the player's level
    public void decreaseLevel(int amount) {
        lvl -= amount;
        position.setPos(400, 300);
        //System.out.println("Player Level: " + lvl); // Print out the new level

        if (lvl <= 0) {
            gameOver();
        }
    }

    public void setGameOverCallback(GameOverCallback callback) {
        this.gameOverCallback = callback;
    }
    // Method to handle game over
    private void gameOver() {
        System.out.println("Game Over!");
        if (gameOverCallback != null) {
            gameOverCallback.onGameOver();
        }
    }
    public int getTimer() {
        return timer;
    }
}
