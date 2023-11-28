public class LevelGenerator {
    private int min;
    private int max;
    private int range;

    public LevelGenerator() {
        min = 1;
        max = 3;
        range = max-min+1;
    }
    public int generateLvl(int lvl) {       //advanced levels have higher lvl rates
        if(lvl == 1) {
            return (int)(Math.random()*range)+min;
        }
        else if (lvl == 2) {
            min = 2;
            range = 2;
            return (int)(Math.random()*range)+min;
        }
        else if (lvl == 3) {
            min = 3;
            range = 0;
            return (int)(Math.random()*range)+min;
        }
        return 1;

    }

}
