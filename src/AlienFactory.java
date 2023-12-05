/**
 * Alien Factory, generates those Aliens
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
public class AlienFactory {
    public static Alien getAlien() {
            double xPos = Math.random()*790 +10;        //randomizing aliens
            double yPos = Math.random()*590 +10;
            double angle = Math.random()*360;
            return new Alien(xPos, yPos, angle);
    }
    /**
     * randomizes direction for Alien depending on which side it is at
     * @param x, double
     * @param y, double
     * @return double
     */
    public double getAngle(double x, double y) {
        if(x <= 0) {return Math.random()*178-89;}
        else if(x >= 750) {return Math.random()*178+91;}
        else if(y >= 550) {return Math.random()*178+181;}
        else  { return Math.random()*178 +1;}
    }
}