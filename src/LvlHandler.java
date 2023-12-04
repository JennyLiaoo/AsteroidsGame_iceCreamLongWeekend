import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

//each draw, new collision handler made. It checks if collide and returns the index of collision back to levelhandler. Levelhandler then removes the actual ones from array and does the stuff
public class LvlHandler implements Drawable{      //depending on user input, will "create" a certain level using the level Factory
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

    @Override
    public void draw(GraphicsContext pen) {
        level.summonAll(level.getProbAsteroid(), level.getLvl(), level.getProbAlien(), level.getProbPower());
        level.draw(pen);
        player.drawBul(pen);

        ArrayList<GameObject> toAdd = new ArrayList<>();
        ArrayList<GameObject> toRemove = new ArrayList<>();

        for(int i = 0; i < level.getObjects().size(); i++) {
            for(int j = 0; j < level.getObjects().size(); j++) {
                if(!(level.getObjects().get(i) instanceof Asteroid && level.getObjects().get(j) instanceof Asteroid)) {
                    if(level.getObjects().get(i) != level.getObjects().get(j)) {
                        if(level.getObjects().get(i).isColliding(level.getObjects().get(j))) {
                            ArrayList<GameObject> temp = level.getObjects().get(i).handleCollision(level.getObjects().get(j).isGoodGuy());
                            if(temp != null) {
                                toAdd.addAll(temp);
                            }
                            toRemove.add(level.getObjects().get(i));
                        }
                    }
                }
            }
        }

        for(int i = 0; i < level.getObjects().size(); i++) {
            if(player.isColliding(level.getObjects().get(i))) {
                ArrayList<GameObject> temp = player.handleCollision(level.getObjects().get(i).isGoodGuy());
                if(temp != null) {
                    player = (Player)temp.get(0);
                }
                toRemove.add(level.getObjects().get(i));    //remove obj so doesn't collide quickly again
            }
        }
        for(int j = 0; j < toRemove.size(); j++) {
            level.getObjects().remove(toRemove.get(j));
        }
        level.getObjects().addAll(toAdd);

        if(player.getLevel() <= 0) {
            System.out.println("Game Over");
        }

    }
    public void shoot() {
        if(player.getTimer() > 0) {
            level.gameObjects.addAll(player.shootEnhanced());
        }
        else {
            level.getObjects().add(player.shoot());
        }

    }
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