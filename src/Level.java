import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class Level extends LevelVariables{   //contains all the requirements each level must have (i,e entities)
    protected double playerX = 0;
    protected double playerY = 0;


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
    public void replaceAsteroid(double tempIndex) { //if gun collide with asteroid return true, index of asteroid in array
        int index = (int)tempIndex;
        if(entity.get(index).getLevel() != 1) {
            entity.add(asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos()));
            entity.add(asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos()));
        }
        entity.remove(index);
    }
    public void enhanceAsteroid(int index) { //if gun collide with asteroid return true, index of asteroid in array
        if(entity.get(index).getLevel() != 3) {
            entity.add(asteroidDestroyer.enhanceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos(), entity.get(index).getAngle()));
            entity.remove(index);
        }
        else {
            int counter = 0;
            while (counter < 3) {
                entity.add(asteroidFactory.getAsteroid(entity.get(index).getPos().getX(), entity.get(index).getPos().getY()));
                counter++;
            }
        }
    }
    public void draw(GraphicsContext pen) {
        for(int i = 0; i < entity.size(); i++) {
            entity.get(i).move();
            entity.get(i).draw(pen);
            if(boundaryHandler.checkAsteroid(entity.get(i))) {
                entity.remove(i);
                i--;
            }

        }
        for(int i = 0; i < powers.size(); i++) {
            powers.get(i).draw(pen);
        }
        for(int i = 0; i < aliens.size(); i++) {        //angles prob incorrect, keep making new aliens
            aliens.get(i).move();
            aliens.get(i).draw(pen);
            if(boundaryHandler.checkAlien(aliens.get(i))) {
                aliens.get(i).setAngle(alienFactory.getAngle(aliens.get(i).getPos().getX(), aliens.get(i).getPos().getY()));
                aliens.get(i).move();
                aliens.get(i).shoot(playerX, playerY);
            }
        }



    }
    public void setPlayerPos(double x, double y) {
        playerX = x;
        playerY = y;
    }
    public abstract int getLvl();
    public abstract int getProbAsteroid();
    public abstract int getProbPower();
    public abstract int getProbAlien();
    public ArrayList<Asteroid> getAsteroids() {
        return entity;
    }
    public ArrayList<PowerUp> getPowerUps() {
        return powers;
    }
    public ArrayList<Alien> getAliens() {
        return aliens;
    }

}