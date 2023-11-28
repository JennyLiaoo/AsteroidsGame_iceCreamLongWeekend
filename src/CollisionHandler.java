import java.util.ArrayList;

public class CollisionHandler {
    //identifies if there was a collision with anything, and the type of collision
    private Level level;
    private Player player;

    public CollisionHandler(Level level, Player player) {
        this.level = level;
        this.player = player;
    }

    public void checkCollisions(){
        //checkBulletCollisions();
        checkPlayerCollisions();
    }

    public int checkPlayerCollisions() { //player with asteroid
        ArrayList<Asteroid> asteroids = level.getAsteroids();
        // Check player collision with asteroids
        for (int asteroidIndex = 0; asteroidIndex < asteroids.size(); asteroidIndex++) {
            if (player.isColliding(asteroids.get(asteroidIndex))) {
                return asteroidIndex;
            }
        }
        return -1;
    }
    public PVector checkBulletCollisions() { //bullet with asteroid
        ArrayList<Asteroid> asteroids = level.getAsteroids();
        ArrayList<Bullet> bullets = player.getBullets();
        // Check bullet collision with asteroids
            for(int bulletIndex = 0; bulletIndex < bullets.size(); bulletIndex++) {
                for (int asteroidIndex = 0; asteroidIndex < asteroids.size(); asteroidIndex++) {
                if ((asteroids.get(asteroidIndex).isColliding(bullets.get(bulletIndex)))) {
                    return new PVector(bulletIndex, asteroidIndex);
                }
            }
        }
        return new PVector(-1, -1);
    }
    public PVector checkAsteroidCollisions() { //asteroid with power ups
        ArrayList<Asteroid> asteroids = level.getAsteroids();
        ArrayList<PowerUp> powers = level.getPowerUps();
        // Check bullet collision with asteroids
        for(int powersIndex = 0; powersIndex < powers.size(); powersIndex++) {
            for (int asteroidIndex = 0; asteroidIndex < asteroids.size(); asteroidIndex++) {
                if ((asteroids.get(asteroidIndex).isColliding(powers.get(powersIndex)))) {
                    return new PVector(powersIndex, asteroidIndex);
                }
            }
        }
        return new PVector(-1, -1);
    }
    public PVector checkAlienBulletCollision() { //alien bullet with player
        ArrayList<Alien> aliens = level.getAliens();
        for(int alienIndex = 0; alienIndex < aliens.size(); alienIndex++) {
            for(int bulletIndex = 0; bulletIndex < aliens.get(alienIndex).getBullets().size(); bulletIndex++) {
                if (player.isColliding(aliens.get(alienIndex).getBullets().get(bulletIndex))) {
                    return new PVector(alienIndex, bulletIndex);
                }
            }
        }
        return new PVector(-1, -1);
    }


    private void handlePlayerAsteroidCollision(int asteroidIndex) {
        // Logic for handling player-asteroid collision
        // Possible game over or damage to the player
        gameOver();
    }

    private void gameOver() {
        // Logic to end the game
        System.out.println("Game Over!");
    }

    private void handlePlayerPowerUpCollision(int powerUpIndex) {
        // Logic for handling player-powerUp collision
        PowerUp powerUp = level.getPowerUps().get(powerUpIndex);
        applyPowerUpEffect(powerUp);
        level.getPowerUps().remove(powerUpIndex);
    }
    private void applyPowerUpEffect(PowerUp powerUp) {
    }

}
