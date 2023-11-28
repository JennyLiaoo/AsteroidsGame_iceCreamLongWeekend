import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject implements Collideable, Drawable{
    protected PVector position;
    protected Image picture;
    protected int size;

    public abstract void draw(GraphicsContext pen);
    public int getSize() {return size;}
    public PVector getPos() {
        return position;
    }


}
