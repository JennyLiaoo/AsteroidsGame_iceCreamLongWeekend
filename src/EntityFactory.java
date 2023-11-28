public class EntityFactory {
    public static Entity getEntity(String entityName, int level) {
        if(entityName.equals("Power")) {
            return AsteroidFactory.getAsteroid(level);
        }
        else if(entityName.equals("Alien")) {
            return AlienFactory.getAlien();
        }
        else {
            return AsteroidFactory.getAsteroid(level);
        }
    }
}
