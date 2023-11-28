import java.util.ArrayList;
public class BoundaryHandler {
    /*
    public ArrayList<Asteroid> checkAsteroids(ArrayList<Asteroid> asteroids) {
        for(int i = 0; i < asteroids.size(); i++) {

        }
    }

     */
    public double checkX(double x) {
        if(x >= 800) {
            x = -50;
        }

        else if(x <= -50) {
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
    public boolean checkAsteroid(Asteroid a) {
        if(a.getPos().getX() >= 1200 || a.getPos().getY() >= 1000 || a.getPos().getX() <= -400 || a.getPos().getY() <= -400) {
            return true;
        }
        return false;
    }
    public boolean checkAlien(Alien a) {
        if(a.getPos().getX() > 750 || a.getPos().getY() > 550 || a.getPos().getX() < 0 || a.getPos().getY() < 0) {
            return true;
        }
        return false;
    }


}
