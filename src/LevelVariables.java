import java.util.ArrayList;

public abstract class LevelVariables {
    protected AsteroidGenerator asteroidGenerator = new AsteroidGenerator();
    protected AsteroidFactory asteroidFactory = new AsteroidFactory(); // could change to entity factory
    protected LevelGenerator levelGenerator = new LevelGenerator();
    protected AsteroidDestroyer asteroidDestroyer = new AsteroidDestroyer();
    protected ArrayList<Asteroid> entity = new ArrayList<>();
    protected ArrayList<Alien> aliens = new ArrayList<>();
    protected ArrayList<PowerUp>  powers = new ArrayList<>();
    protected PowerFactory powerFactory = new PowerFactory();
    protected PowerUpGenerator powerUpGenerator =  new PowerUpGenerator();
    protected AlienGenerator alienGenerator = new AlienGenerator();
    protected AlienFactory alienFactory = new AlienFactory();
    protected BoundaryHandler boundaryHandler= new BoundaryHandler();

}
