public class AlienGenerator {
    public boolean checkIfGenerate(double prob) {
        double temp = Math.random()*1000+1;
        if(temp < prob) {
            return true;
        }
        else  {
            return false;
        }
    }
}
