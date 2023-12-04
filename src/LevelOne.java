import javafx.scene.canvas.GraphicsContext;
public class LevelOne extends Level{        //contains all the information about a specific level, (i,e probability of generating things.)
    public static final int probAsteroid = 15;
    public static final int probPower = 3;
    public static final int probAlien = 0;

    @Override
    public int getLvl() {return 1;}

    public int getProbAsteroid() {
        return probAsteroid;
    }
    public int getProbPower() {
        return probPower;
    }
    public int getProbAlien() {
        return probAlien;
    }

}