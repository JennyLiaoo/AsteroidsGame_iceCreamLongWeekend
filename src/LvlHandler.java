//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

public class LvlHandler implements Drawable {
    private final LvlFactory levelFactory = new LvlFactory();
    private Level level;
    protected Player player;
    private final BoundaryHandler boundaryHandler = new BoundaryHandler();

    public LvlHandler(int lvl, GameOverCallback gameOverCallback) {
        LvlFactory var10001 = this.levelFactory;
        this.level = LvlFactory.getLevel(lvl);
        this.player = new Player(5, 400.0, 300.0);
        this.player.setGameOverCallback(gameOverCallback);
    }

    public Level getLevel() {
        return this.level;
    }

    public void draw(GraphicsContext pen) {
        this.level.summonAll(this.level.getProbAsteroid(), this.level.getLvl(), this.level.getProbAlien(), this.level.getProbPower());
        this.level.draw(pen);
        this.checkCollisions();
    }

    public void checkCollisions() {
        ArrayList<GameObject> toAdd = new ArrayList();
        ArrayList<GameObject> toRemove = new ArrayList();

        int i;
        for(i = 0; i < this.level.getObjects().size(); ++i) {
            for(int j = 0; j < this.level.getObjects().size(); ++j) {
                if ((!(this.level.getObjects().get(i) instanceof Asteroid) || !(this.level.getObjects().get(j) instanceof Asteroid)) && this.level.getObjects().get(i) != this.level.getObjects().get(j) && ((GameObject)this.level.getObjects().get(i)).isColliding((GameObject)this.level.getObjects().get(j))) {
                    ArrayList<GameObject> temp = ((GameObject)this.level.getObjects().get(i)).handleCollision(((GameObject)this.level.getObjects().get(j)).isGoodGuy());
                    if (temp != null) {
                        toAdd.addAll(temp);
                    }

                    toRemove.add((GameObject)this.level.getObjects().get(i));
                    if (this.level.getObjects().get(i) instanceof PlayerBullet) {
                        this.player.incrementScore(((GameObject)this.level.getObjects().get(j)).getLevel());
                    }
                }
            }
        }

        for(i = 0; i < this.level.getObjects().size(); ++i) {
            if (this.player.isColliding((GameObject)this.level.getObjects().get(i))) {
                ArrayList<GameObject> temp = this.player.handleCollision(((GameObject)this.level.getObjects().get(i)).isGoodGuy());
                if (temp != null) {
                    this.player = (Player)temp.get(0);
                }

                toRemove.add((GameObject)this.level.getObjects().get(i));
            }
        }

        for(i = 0; i < toRemove.size(); ++i) {
            this.level.getObjects().remove(toRemove.get(i));
        }

        this.level.getObjects().addAll(toAdd);
    }

    public void shoot() {
        if (this.player.getTimer() > 0) {
            this.level.gameObjects.addAll(this.player.shootEnhanced());
        } else {
            this.level.getObjects().add(this.player.shoot());
        }

    }

    public void drawPlayer(GraphicsContext pen) {
        this.player.draw(pen);
        this.player.setPos(this.boundaryHandler.checkX(this.player.getPos().getX()), this.boundaryHandler.checkY(this.player.getPos().getY()));
        this.player.deccelerate();
        this.level.setPlayerPos(this.player.getPos().getX(), this.player.getPos().getY());
    }

    public Player getPlayer() {
        return this.player;
    }
}
