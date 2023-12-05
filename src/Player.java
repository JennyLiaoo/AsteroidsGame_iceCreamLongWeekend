//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends Shooters {
    private GameOverCallback gameOverCallback;
    private int score;
    private Image user = new Image("file:src/Images/spaceship.png");
    private int timer;

    public Player(int level, double x, double y) {
        this.size = 50;
        this.position = new PVector(x, y);
        this.velocity = new PVector(0.0, 0.0);
        this.rotation = 0.0;
        this.score = 0;
        this.lvl = level;
        this.b = new ArrayList();
        this.timer = 0;
        this.goodGuy = 0;
    }

    public void incrementScore(int gameObjectLevel) {
        switch (gameObjectLevel) {
            case 1:
                this.score += 100;
                break;
            case 2:
                this.score += 200;
                break;
            case 3:
                this.score += 300;
        }

    }

    public int getScore() {
        return this.score;
    }

    public void accelerate() {
        if (this.velocity.getSize() <= 5.0) {
            this.velocity.setSize(this.velocity.getSize() + 0.5);
        } else {
            this.velocity.setSize(this.velocity.getSize());
        }

        this.velocity.setAngle(this.rotation);
        this.rotation = this.velocity.getAngle();
    }

    public void deccelerate() {
        this.velocity.setSize(this.velocity.getSize() - 0.01);
    }

    public void turnRight() {
        this.rotation += 10.0;
    }

    public void turnLeft() {
        this.rotation -= 10.0;
    }

    public void move() {
        super.move();
        if (this.timer > 0) {
            --this.timer;
        }

    }

    public Bullet shoot() {
        PlayerBullet temp = new PlayerBullet(this.rotation, this.position.getX(), this.position.getY());

        for(int i = 0; i < 8; ++i) {
            temp.move();
        }

        return temp;
    }

    public ArrayList<Bullet> shootEnhanced() {
        ArrayList<Bullet> temporary = new ArrayList();

        for(double tempAngle = 0.0; tempAngle <= 360.0; tempAngle += 20.0) {
            PlayerBullet temp = new PlayerBullet(tempAngle, this.position.getX() + (double)this.size, this.position.getY() + (double)this.size);

            for(int i = 0; i < 10; ++i) {
                temp.move();
            }

            temporary.add(temp);
        }

        return temporary;
    }

    public void draw(GraphicsContext pen) {
        this.move();
        pen.drawImage(this.user, (double)(-this.size) / 2.0, (double)(-this.size) / 2.0, (double)this.size, (double)this.size);
    }

    public void setPos(double x, double y) {
        this.position = new PVector(x, y);
    }

    public ArrayList<GameObject> handleCollision(boolean good) {
        ArrayList<GameObject> temp = new ArrayList();
        if (good) {
            double chance = Math.random() * 9.0 + 1.0;
            if (chance >= 5.0) {
                this.timer = 80;
            } else {
                ++this.lvl;
            }

            return null;
        } else {
            this.decreaseLevel(1);
            Player p = new Player(this.lvl, this.position.getX(), this.position.getY());
            p.setScore(this.getScore());
            temp.add(p);
            return temp;
        }
    }

    public void decreaseLevel(int amount) {
        this.lvl -= amount;
        if (this.lvl <= 0) {
            this.gameOver();
        }
    }

    public void setGameOverCallback(GameOverCallback callback) {
        this.gameOverCallback = callback;
    }

    private void gameOver() {
        if (this.gameOverCallback != null) {
            this.gameOverCallback.onGameOver();
        }
    }


    public int getTimer() {
        return this.timer;
    }

    public void setScore(int s) {
        this.score = s;
    }
}
