public class LevelTwo extends Level{
    public static final int probAsteroid = 30;
    public static final int probPower = 5;
    public static final int probAlien = 1;
    public int getLvl() {
        return 2;
    }

    @Override
    public int getProbAsteroid() {
        return probAsteroid;
    }

    @Override
    public int getProbPower() {
        return probPower;
    }

    @Override
    public int getProbAlien() {
        return probAlien;
    }
}
