/**
 * Level handler, manages everything when the game starts. It contains the player and the level while checking for the collisions between objects
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class LvlHandler implements Drawable{
    private final LvlFactory levelFactory = new LvlFactory();
    private Level level;
    protected Player player;
    private final BoundaryHandler boundaryHandler = new BoundaryHandler();

    public LvlHandler(int lvl, GameOverCallback gameOverCallback) {
        level = levelFactory.getLevel(lvl);
        player = new Player(5, 400, 300); // Initialize player with level 5
        player.setGameOverCallback(gameOverCallback);
    }
    public Level getLevel() { //returns level obj
        return level;
    }

    /**
     * Update everything in a level
     * @param pen, GraphicsContext
     */
    @Override
    public void draw(GraphicsContext pen) {
        level.summonAll(level.getProbAsteroid(), level.getLvl(), level.getProbAlien(), level.getProbPower());
        level.draw(pen);
        checkCollisions();
    }
    /**
     * Checks collisions between all objects
     */
    public void checkCollisions() {
        ArrayList<GameObject> toAdd = new ArrayList<>();
        ArrayList<GameObject> toRemove = new ArrayList<>();
        for(int i = 0; i < level.getObjects().size(); i++) {        //collision between all objects
            for(int j = 0; j < level.getObjects().size(); j++) {
                if(!(level.getObjects().get(i) instanceof Asteroid && level.getObjects().get(j) instanceof Asteroid)) {
                    if(level.getObjects().get(i) != level.getObjects().get(j)) {
                        if(level.getObjects().get(i).isColliding(level.getObjects().get(j))) {
                            ArrayList<GameObject> temp = level.getObjects().get(i).handleCollision(level.getObjects().get(j).isGoodGuy());
                            if(temp != null) {toAdd.addAll(temp);}
                            toRemove.add(level.getObjects().get(i));
                        }
                    }
                }
            }
        }
        for(int i = 0; i < level.getObjects().size(); i++) {
            if(player.isColliding(level.getObjects().get(i))) {     //player collisions
                ArrayList<GameObject> temp = player.handleCollision(level.getObjects().get(i).isGoodGuy());
                if(temp != null) {player = (Player)temp.get(0);}
                toRemove.add(level.getObjects().get(i));    //remove obj so doesn't collide quickly again
            }
        }
        for(int j = 0; j < toRemove.size(); j++) {                  //removes all objects that should be removed
            level.getObjects().remove(toRemove.get(j));
        }
        level.getObjects().addAll(toAdd);                           //adds all objects that have been created from collisions
    }
    /**
     * allows the player to shoot in a certain way depending on if the player hit a power up
     */
    public void shoot() {
        if(player.getTimer() > 0) {level.gameObjects.addAll(player.shootEnhanced());}
        else {level.getObjects().add(player.shoot());}

    }
    /**
     * draws player
     * @param pen, GraphicsContext
     */
    public void drawPlayer(GraphicsContext pen) {
        player.draw(pen);
        player.setPos(boundaryHandler.checkX(player.getPos().getX()), boundaryHandler.checkY(player.getPos().getY()));
        player.deccelerate();
        level.setPlayerPos(player.getPos().getX(), player.getPos().getY());
    }
    public Player getPlayer() {
        return player;
    }
}