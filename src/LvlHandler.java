import javafx.scene.canvas.GraphicsContext;
//each draw, new collision handler made. It checks if collide and returns the index of collision back to levelhandler. Levelhandler then removes the actual ones from array and does the stuff
public class LvlHandler implements Drawable{      //depending on user input, will "create" a certain level using the level Factory
    private final LvlFactory levelFactory = new LvlFactory();
    private Level level;
    protected Player player;
    protected CollisionHandler collisionHandler;
    private final BoundaryHandler boundaryHandler = new BoundaryHandler();


    public LvlHandler(int lvl) {
        level = levelFactory.getLevel(lvl);
        player = new Player(5, 400, 300 );
    }

    public Level getLevel() { //returns level obj
        return level;
    }

    @Override
    public void draw(GraphicsContext pen) {
        level.summonAll(level.getProbAsteroid(), level.getLvl(), level.getProbAlien(), level.getProbPower());
        level.draw(pen);
        player.drawBul(pen);

        collisionHandler = new CollisionHandler(level, player);         //change to end screen instead
        int temp = collisionHandler.checkPlayerCollisions();
        if(temp >= 0) {
            level.getAsteroids().remove(temp);
            player.decreaseLevel();     //decrease player level
        }
        PVector temp2 = collisionHandler.checkBulletCollisions();
        if(temp2.getX() != -1 && temp2.getY() != -1) {
            player.getBullets().remove((int)temp2.getX());
            level.replaceAsteroid(temp2.getY());
        }
        PVector temp3 = collisionHandler.checkAsteroidCollisions();
        if(temp3.getX() != -1 && temp3.getY() != -1) {
            level.getPowerUps().remove((int)temp3.getX());
            level.enhanceAsteroid((int)temp3.getY());
        }
        PVector temp4 = collisionHandler.checkAlienBulletCollision();       //change to end screen instead
        if(temp4.getX() != -1 && temp4.getY() != -1) {
            player.decreaseLevel();     //decrease player level
            level.getAliens().get((int)temp4.getX()).getBullets().remove((int)temp4.getY());
        }
        PVector temp5 = collisionHandler.checkPlayerBulletCollision();
        if(temp5.getX() != -1 && temp5.getY() != -1) {
            level.getAliens().remove((int)temp5.getX());
            player.getBullets().remove((int)temp5.getY());
        }
        PVector temp6 = collisionHandler.checkAlienPowerCollision();
        if(temp6.getX() != -1 && temp6.getY() != -1) {
            level.getAliens().get((int) temp6.getY()).setSpeed();
            level.getPowerUps().remove((int)temp6.getX());
        }
        int temp7 = collisionHandler.checkPlayerPowerCollisions();
        if(temp7 >= 0) {
            level.getPowerUps().remove(temp7);
            player.setTime();
        }
         if(player.getLevel() <= 0) {
             System.out.println("Player level has decreased and it has died");
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
