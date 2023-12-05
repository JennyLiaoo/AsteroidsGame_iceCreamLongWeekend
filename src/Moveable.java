/**
 * All moveable objects must implement these:
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
public interface Moveable {     //how everything moves
    public PVector getPos();
    public double getAngle();
    public void move();
}
