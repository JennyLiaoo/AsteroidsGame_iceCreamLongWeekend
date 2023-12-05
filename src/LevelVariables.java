//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public abstract class LevelVariables {
    protected AsteroidFactory asteroidFactory = new AsteroidFactory();
    protected LevelGenerator levelGenerator = new LevelGenerator();
    protected ArrayList<GameObject> gameObjects = new ArrayList();
    protected PowerFactory powerFactory = new PowerFactory();
    protected EntityGenerator entityGenerator = new EntityGenerator();
    protected AlienFactory alienFactory = new AlienFactory();
    protected BoundaryHandler boundaryHandler = new BoundaryHandler();

    public LevelVariables() {
    }

    public void summonAll(int probAsteroid, int lvlAsteroid, int probAlien, int probPower) {
        this.summonAsteroid(probAsteroid, lvlAsteroid);
        this.summonAlien(probAlien);
        this.summonPower(probPower);
    }

    public void summonAsteroid(int prob, int lvl) {
        boolean generated = this.entityGenerator.checkIfGenerate((double)prob);
        if (generated) {
            AsteroidFactory var10001 = this.asteroidFactory;
            this.gameObjects.add(AsteroidFactory.getAsteroid(this.levelGenerator.generateLvl(lvl)));
        }

    }

    public void summonAlien(int prob) {
        boolean generated = this.entityGenerator.checkIfGenerate((double)prob);
        if (generated) {
            AlienFactory var10001 = this.alienFactory;
            this.gameObjects.add(AlienFactory.getAlien());
        }

    }

    public void summonPower(int prob) {
        boolean generated = this.entityGenerator.checkIfGenerate((double)prob);
        if (generated) {
            PowerFactory var10001 = this.powerFactory;
            this.gameObjects.add(PowerFactory.getPower());
        }

    }
}
