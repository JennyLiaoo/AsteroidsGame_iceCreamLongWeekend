/**
 * Holds each level's variables and levels
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
import java.util.ArrayList;

public abstract class LevelVariables {
    protected AsteroidFactory asteroidFactory = new AsteroidFactory(); // could change to entity factory
    protected LevelGenerator levelGenerator = new LevelGenerator();
    protected ArrayList<GameObject>  gameObjects = new ArrayList<>();
    protected PowerFactory powerFactory = new PowerFactory();
    protected EntityGenerator entityGenerator =  new EntityGenerator();
    protected AlienFactory alienFactory = new AlienFactory();
    protected BoundaryHandler boundaryHandler= new BoundaryHandler();

    /**
     * Summons all entities
     * @param probAsteroid, int
     * @param probAlien, int
     * @param probPower, int
     */
    public void summonAll(int probAsteroid, int lvlAsteroid, int probAlien, int probPower) {
        summonAsteroid(probAsteroid, lvlAsteroid);
        summonAlien(probAlien);
        summonPower(probPower);
    }

    /**
     * Summons asteroids
     * @param prob, int
     * @param lvl, int
     */
    public void summonAsteroid(int prob, int lvl) {
        boolean generated = entityGenerator.checkIfGenerate(prob);
        if(generated) {
            gameObjects.add(asteroidFactory.getAsteroid(levelGenerator.generateLvl(lvl)));
        }
    }
    /**
     * Summons aliens
     * @param prob, int
     */
    public void summonAlien(int prob) {
        boolean generated = entityGenerator.checkIfGenerate(prob);
        if(generated) {
            gameObjects.add(alienFactory.getAlien());
        }
    }

    /**
     * Summons powers
     * @param prob, int
     */
    public void summonPower(int prob) { //if collide with smt, it will disappear
        boolean generated = entityGenerator.checkIfGenerate(prob);
        if(generated) {
            gameObjects.add(powerFactory.getPower());
        }
    }
}
