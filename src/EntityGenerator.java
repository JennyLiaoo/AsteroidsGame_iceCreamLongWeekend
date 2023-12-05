//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class EntityGenerator {
    public EntityGenerator() {
    }

    public boolean checkIfGenerate(double prob) {
        double temp = Math.random() * 1000.0 + 1.0;
        return temp < prob;
    }
}
