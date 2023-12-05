/**
 * Holds all the information that each Level must have
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;


public abstract class Level extends LevelVariables{   //contains all the requirements each level must have (i,e entities)
    protected double playerX = 0;
    protected double playerY = 0;
    protected int probAsteroid;
    protected int probPower;
    protected int probAlien;

    /**
     * Update everything in a level
     * @param pen, GraphicsContext
     */
    public void draw(GraphicsContext pen) {
        for(int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).move();
            gameObjects.get(i).draw(pen);
            if(boundaryHandler.checkObjects(gameObjects.get(i))) {
                if(gameObjects.get(i) instanceof Alien) {
                    ((Alien) gameObjects.get(i)).setAngle(alienFactory.getAngle(gameObjects.get(i).getPos().getX(), gameObjects.get(i).getPos().getY()));
                    gameObjects.add(( ((Alien) gameObjects.get(i)).shoot(playerX,playerY)));
                }
                else{
                    gameObjects.remove(i);
                    i--;
                }
            }
        }
    }

    /**
     * getters and setters
     */
    public void setPlayerPos(double x, double y) {
        playerX = x;
        playerY = y;
    }
    public abstract int getLvl();
    public int getProbAsteroid() {
        return probAsteroid;
    }
    public int getProbPower() {
        return probPower;
    }
    public int getProbAlien() {
        return probAlien;
    }
    public ArrayList<GameObject> getObjects() {
        return gameObjects;
    }
}