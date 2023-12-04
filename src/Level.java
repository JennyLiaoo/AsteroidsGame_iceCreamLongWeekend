import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class Level extends LevelVariables{   //contains all the requirements each level must have (i,e entities)
    protected double playerX = 0;
    protected double playerY = 0;

    public void draw(GraphicsContext pen) {
        for(int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).move();
            gameObjects.get(i).draw(pen);
            if(boundaryHandler.checkObjects(gameObjects.get(i))) {
                if(gameObjects.get(i) instanceof Alien) {
                    ((Alien) gameObjects.get(i)).setAngle(alienFactory.getAngle(gameObjects.get(i).getPos().getX(), gameObjects.get(i).getPos().getY()));
                    // ((Alien) gameObjects.get(i)).shoot(playerX, playerY);
                    gameObjects.add(( ((Alien) gameObjects.get(i)).shoot(playerX,playerY))); //HELP

                }
                else{
                    gameObjects.remove(i);
                    i--;
                }
            }
        }

    }
    public void setPlayerPos(double x, double y) {
        playerX = x;
        playerY = y;
    }
    public abstract int getLvl();
    public abstract int getProbAsteroid();
    public abstract int getProbPower();
    public abstract int getProbAlien();
    public ArrayList<GameObject> getObjects() {
        return gameObjects;
    }

}