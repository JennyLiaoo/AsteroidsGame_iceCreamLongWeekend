public class PowerUpGenerator {
    public boolean checkIfGenerate(double prob) {

        double temp = Math.random()*2000+1;
        if(temp < prob) {
            return true;
        }
        else  {
            return false;
        }
    }
}
