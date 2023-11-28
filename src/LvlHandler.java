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
        player = new Player(1, 400, 300 );
    }

    public Level getLevel() { //returns level obj
        return level;
    }

    public void replaceAsteroid() {
        level.replaceAsteroid(0);
    }       //need index of collided/enhanced asteroid
    public void enhanceAsteroid() {
        level.enhanceAsteroid(0);
    }
    @Override
    public void draw(GraphicsContext pen) {


        level.summonAsteroid(level.getProbAsteroid(), level.getLvl());
        level.summonPower(level.getProbPower());
        level.summonAlien(level.getProbAlien());
        level.draw(pen);
        player.drawBul(pen);
        //collision stuff
        collisionHandler = new CollisionHandler(level, player);         //change to end screen instead
        int temp = collisionHandler.checkPlayerCollisions();
        if(temp >= 0) {
            level.getAsteroids().remove(temp);
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
            level.getAliens().get((int)temp4.getX()).getBullets().remove((int)temp4.getY());
            level.getAliens().remove((int)temp4.getX());

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
