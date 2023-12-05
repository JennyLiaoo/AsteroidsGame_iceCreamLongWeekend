//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class PVector {
    private double x;
    private double y;

    public PVector() {
        this.setPos(0.0, 0.0);
    }

    public PVector(double xPos, double yPos) {
        this.setPos(xPos, yPos);
    }

    public void setPos(double xPos, double yPos) {
        this.x = xPos;
        this.y = yPos;
    }

    public void add(double xAdd, double yAdd) {
        this.x += xAdd;
        this.y += yAdd;
    }

    public void mult(double xyMul) {
        this.x *= xyMul;
        this.y *= xyMul;
    }

    public double getSize() {
        return Math.abs(Math.sqrt(this.x * this.x + this.y * this.y));
    }

    public void setSize(double S) {
        double currentSize = this.getSize();
        if (currentSize == 0.0) {
            this.setPos(S, 0.0);
        } else {
            this.mult(1.0 / currentSize);
            this.mult(S);
        }

    }

    public double getAngle() {
        return Math.toDegrees(Math.atan2(this.y, this.x));
    }

    public void setAngle(double angle) {
        double size;
        double angleinRad;
        for(size = this.getSize(); angle <= 0.0; angle = 360.0 - angleinRad) {
            angleinRad = Math.abs(angle);
        }

        while(angle >= 360.0) {
            angle -= 360.0;
        }

        angleinRad = Math.toRadians(angle);
        if (angle >= 0.0 && angle < 90.0) {
            this.x = Math.abs(size * Math.cos(angleinRad));
            this.y = Math.abs(size * Math.sin(angleinRad));
        } else if (angle >= 90.0 && angle < 180.0) {
            this.x = -Math.abs(size * Math.cos(angleinRad));
            this.y = Math.abs(size * Math.sin(angleinRad));
        }

        if (angle >= 180.0 && angle < 270.0) {
            this.x = -Math.abs(size * Math.cos(angleinRad));
            this.y = -Math.abs(size * Math.sin(angleinRad));
        }

        if (angle >= 270.0 && angle < 360.0) {
            this.x = Math.abs(size * Math.cos(angleinRad));
            this.y = -Math.abs(size * Math.sin(angleinRad));
        }

    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
