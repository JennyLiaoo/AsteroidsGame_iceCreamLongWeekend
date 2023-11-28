public class LevelThree extends Level{
    public static final int probAsteroid = 15;
    public static final int probPower = 3;
    public static final int probAlien = 3;
    public int getLvl() {
        return 3;
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
