public class PVector {
    private double x;       //tracks xPos
    private double y;       //tracks yPos
    public PVector() {       //initial Vector position is 0, 0
        this.setPos(0, 0);
    }
    public PVector(double xPos, double yPos) {       //set position of object when created
        this.setPos(xPos, yPos);
    }
    public void setPos(double xPos, double yPos) {  //set position when needed
        x = xPos;
        y = yPos;
    }
    public void add(double xAdd, double yAdd) {     //when moving at constant velocity in some direction
        x += xAdd;
        y += yAdd;
    }
    public void mult(double xyMul) {                //moving at constant acceleration at xyMul
        x *= xyMul;
        y *= xyMul;
    }
    public double getSize() {                        //returns size of vector based on xpos and ypos using pythagorean
        return Math.abs(Math.sqrt(x*x + y*y));
    }
    public void setSize(double S) {
        double currentSize = this.getSize();
        if(currentSize==0) {        //check if vector is 0
            setPos(S, 0);
        }
        else{
            this.mult(1/currentSize);       //handles if previous vector exists
            this.mult(S);                          //changes vector size
        }
    }
    public double getAngle() {return Math.toDegrees(Math.atan2(this.y, this.x));}
    public void setAngle(double angle) {      //angle in deg  //find new values of x and y, given fixed value of size
        double size = this.getSize();
        while (angle <= 0) {
            double temp = Math.abs(angle);
            angle = 360 - temp;
        }
        while (angle >=360) {
            angle -= 360;
        }
        double angleinRad = Math.toRadians(angle);
        if (angle >= 0 && angle < 90) {
            x = Math.abs(size * Math.cos(angleinRad));
            y = Math.abs(size * Math.sin(angleinRad));
        }
        else if (angle >= 90 && angle < 180) {
            x = -Math.abs(size * Math.cos(angleinRad));
            y = Math.abs(size * Math.sin(angleinRad));
        }
        if (angle >= 180 && angle < 270) {
            x = -Math.abs(size * Math.cos(angleinRad));
            y = -Math.abs(size * Math.sin(angleinRad));
        }
        if (angle >= 270 && angle < 360) {
            x = Math.abs(size * Math.cos(angleinRad));
            y = -Math.abs(size * Math.sin(angleinRad));
        }
    }
    public double getX() {return x;}
    public double getY() {return y;}

}
