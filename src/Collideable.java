/**
 * Collision interface for all collideable objects
 *
 * @author  Jenny Liao
 * @version 4.0
 * @since   2023-12-4
 */
public interface Collideable {
    /**
     * Checks if this object is colliding with another GameObject, implemented by all collideable objects
     * @param other, Gameobject
     * @return boolean
     */
    boolean isColliding(GameObject other);
}