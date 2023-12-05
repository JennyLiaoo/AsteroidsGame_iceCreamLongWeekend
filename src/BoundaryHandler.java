/**
 * Handles entities which reach their boundaries
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
public class BoundaryHandler {
    public double checkX(double x) {        //checks x position
        if(x >= 800) {
            x = -50;
        }
        else if(x <= -50) {                 //checks y position
            x = 800;
        }
        return x;
    }
    public double checkY(double y) {
        if(y >= 600) {
            y = -50;
        }
        else if(y <= -50) {
            y = 600;
        }
        return y;
    }

    /**
     * checks all objects and their boundaries
     * @param a, GameObject
     * @return boolean
     */
    public boolean checkObjects(GameObject a) {
        if(a instanceof Alien) {
            return checkAlien((Alien) a);
        }
        if(a.getPos().getX() >= 1200 || a.getPos().getY() >= 1000 || a.getPos().getX() <= -400 || a.getPos().getY() <= -400) {
            return true;
        }
        return false;
    }

    /**
     * Aliens have special boundaries :) they do not go off screen
     * @param a, Alien
     * @return boolean
     */
    public boolean checkAlien(Alien a) {
        if(a.getPos().getX() > 750 || a.getPos().getY() > 550 || a.getPos().getX() < 0 || a.getPos().getY() < 0) {
            return true;
        }
        return false;
    }
}
