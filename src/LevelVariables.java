import java.util.ArrayList;

public abstract class LevelVariables {
    protected AsteroidGenerator asteroidGenerator = new AsteroidGenerator();
    protected AsteroidFactory asteroidFactory = new AsteroidFactory(); // could change to entity factory
    protected LevelGenerator levelGenerator = new LevelGenerator();
    protected AsteroidDestroyer asteroidDestroyer = new AsteroidDestroyer();
    protected ArrayList<Asteroid> entity = new ArrayList<>();
    protected ArrayList<Alien> aliens = new ArrayList<>();
    protected ArrayList<PowerUp>  powers = new ArrayList<>();
   // protected ArrayList<GameObject>  gameObjects = new ArrayList<>();
    protected PowerFactory powerFactory = new PowerFactory();
    protected PowerUpGenerator powerUpGenerator =  new PowerUpGenerator();
    protected AlienGenerator alienGenerator = new AlienGenerator();
    protected AlienFactory alienFactory = new AlienFactory();
    protected BoundaryHandler boundaryHandler= new BoundaryHandler();

    public void summonAsteroid(int prob, int lvl) {
        boolean generated = asteroidGenerator.checkIfGenerate(prob);
        if(generated) {
            entity.add(asteroidFactory.getAsteroid(levelGenerator.generateLvl(lvl)));
        }
    }
    public void summonAlien(int prob) {
        boolean generated = alienGenerator.checkIfGenerate(prob);
        if(generated) {
            aliens.add(alienFactory.getAlien());
        }
    }
    public void summonPower(int prob) { //if collide with smt, it will disappear
        boolean generated = powerUpGenerator.checkIfGenerate(prob);
        if(generated) {
            powers.add(powerFactory.getPower());
        }
    }

}
