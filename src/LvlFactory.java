public class LvlFactory {        //creates the level object of a certain level (i.e levelOne, levelTwo...)
    public static Level getLevel(int level) {
        if(level == 1) {
            return new LevelOne();
        }
        else if(level == 2) {
            return new LevelTwo();
        }
        else if(level == 3) {
            return new LevelThree();
        }
        else {
            return new LevelOne();
        }
    }
}
