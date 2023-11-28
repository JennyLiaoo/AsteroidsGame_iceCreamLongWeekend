public class AlienFactory {

    public static Alien getAlien() {

            double xPos = Math.random()*790 +10;
            double yPos = Math.random()*590 +10;
            double angle = Math.random()*360;
            return new Alien(xPos, yPos, angle);


    }

    public double getAngle(double x, double y) {      //if hit wall
        if(x <= 0) {
            return Math.random()*178-89;
        }
        else if(x >= 750) {
            return Math.random()*178+91;
        }
        else if(y >= 550) {
            return Math.random()*178+181;
        }
        else  { //if
            return Math.random()*178 +1;
        }
    }
}