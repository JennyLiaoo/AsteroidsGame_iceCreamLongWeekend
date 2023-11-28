public interface Collideable {

    /**
     * Checks if this object is colliding with another Collideable object.
     * @return true if there is a collision, false otherwise.
     */
    boolean isColliding(GameObject other);

}