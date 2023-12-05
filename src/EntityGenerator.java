/**
 * Checks if an entity will generate based on level probability
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
public class EntityGenerator {
    /**
     * Checks if an entity will generate based on a given probability determined by each level
     * @param prob, double
     * @return boolean
     */
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
