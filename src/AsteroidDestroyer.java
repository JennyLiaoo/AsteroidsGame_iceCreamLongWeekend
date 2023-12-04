public class AsteroidDestroyer {
    public Asteroid replaceAsteroid(int level, PVector pos) {

        double angle = Math.random()*360;
        return new Asteroid(level-1, pos.getX(), pos.getY(), angle);

    }
    public Asteroid enhanceAsteroid(int level, PVector pos, double angle) {
        return new Asteroid(level+1, pos.getX(), pos.getY(), angle); //always give me 0? angle
    }
}
