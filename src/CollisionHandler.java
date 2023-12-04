import java.util.ArrayList;

public class CollisionHandler {
    //identifies if there was a collision with anything, and the type of collision
    private Level level;
    private Player player;
    private int score;

    public CollisionHandler(Level level, Player player) {
        this.level = level;
        this.player = player;
        this.score = 0;
    }

    public void checkCollisions(){
        //checkBulletCollisions();
        checkPlayerCollisions();
    }

    public int checkPlayerCollisions() {
        ArrayList<Asteroid> asteroids = level.getAsteroids();
        for (int asteroidIndex = 0; asteroidIndex < asteroids.size(); asteroidIndex++) {
            if (player.isColliding(asteroids.get(asteroidIndex))) {
                // Decrease player's level based on asteroid level
                player.decreaseLevel(1);
                return asteroidIndex;
            }
        }
        return -1;
    }
    public PVector checkBulletCollisions() {
        ArrayList<Asteroid> asteroids = level.getAsteroids();
        ArrayList<Bullet> bullets = player.getBullets();

        for (int bulletIndex = 0; bulletIndex < bullets.size(); bulletIndex++) {
            for (int asteroidIndex = 0; asteroidIndex < asteroids.size(); asteroidIndex++) {
                if ((asteroids.get(asteroidIndex).isColliding(bullets.get(bulletIndex)))) {
                    player.incrementScore(asteroids.get(asteroidIndex).getLevel()); // Update player's score
                    return new PVector(bulletIndex, asteroidIndex);
                }
            }
        }
        return new PVector(-1, -1);
    }

    private void updateScore(Asteroid asteroid) {
        // Increment score based on asteroid level
        switch (asteroid.getLevel()) {
            case 1:
                score += 100;
                break;
            case 2:
                score += 200;
                break;
            case 3:
                score += 300;
                break;
            default:
                // In case there are other levels or default score increment
                break;
        }
        printScore();
    }

    private void printScore() {
        System.out.println("Score: " + score);
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
    public PVector checkAlienBulletCollision() {
        ArrayList<Alien> aliens = level.getAliens();
        for(int alienIndex = 0; alienIndex < aliens.size(); alienIndex++) {
            for(int bulletIndex = 0; bulletIndex < aliens.get(alienIndex).getBullets().size(); bulletIndex++) {
                if (player.isColliding(aliens.get(alienIndex).getBullets().get(bulletIndex))) {
                    player.decreaseLevel(1); // Decrease player's level by 1
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
