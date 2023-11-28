public class AsteroidFactory {

    public static Asteroid getAsteroid(int lvl) {
        int side = (int)(Math.random()*3+1);    //side of which the asteroid is generated on the screen (hidden)
        if(side==1) {
            double xPos = Math.random()*1400 - 200;
            double yPos = Math.random()* 100 - 200;
            double angle = Math.random()*180;
            return new Asteroid(lvl, xPos, yPos, angle);
        }
        else if(side==2) {
            double xPos = Math.random()*200 +800;
            double yPos = Math.random()* 1000 - 200;
            double angle = Math.random()*180 +90;
            return new Asteroid(lvl, xPos, yPos, angle);
        }else if(side==3) {
            double xPos = Math.random()*1200 - 200;
            double yPos = Math.random()* 200 + 600;
            double angle = Math.random()* 180 + 180;
            return new Asteroid(lvl, xPos, yPos, angle);
        } else {
            double xPos = Math.random()*200 -200;
            double yPos = Math.random()*1000 -200;
            double angle = Math.random()*180 - 90;
            return new Asteroid(lvl, xPos, yPos, angle);
        }

    }

    public static Asteroid getAsteroid(double x, double y) {
        double angle = Math.random()*360;
        return new Asteroid(1, x, y, angle);
    }



}
