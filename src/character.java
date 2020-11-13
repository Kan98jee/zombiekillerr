import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Timer;

public abstract class character {
    int x,y,width,height;
    Image img;
    Timer t;
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    int getWidth(){
        return width;
    }
    int getHeight(){
        return height;
    }
    Image getImage(){
        return img;
    }
    Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
}