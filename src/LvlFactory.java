//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class LvlFactory {
    public LvlFactory() {
    }

    public static Level getLevel(int level) {
        if (level == 1) {
            return new LevelOne();
        } else if (level == 2) {
            return new LevelTwo();
        } else {
            return (Level)(level == 3 ? new LevelThree() : new LevelOne());
        }
    }
}
