import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player extends character{
    Player player;
    Image left,right;
    int sx,sy;
    boolean isLeft;
    public Player() {
        player = this;
        x=400;
        y=300;
        sx=0;
        sy=0;
        width=85;
        height=120;
        img = left = new ImageIcon("jmleft.png").getImage();
        right = new ImageIcon("jmright.png").getImage();
        isLeft=true;
        t = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(x+sx>=0&&x+width+sx<=Frame.frame.getWidth()){
                    x+=sx;
                }
                if(y>350)
                    y=350;
                if(y<220)
                    y=220;
                y+=sy;
            }
        });
        t.start();
    }

    void moveLeft(){
        sx=-40;
        img=left;
        isLeft=true;
    }
    void moveRight(){
        sx=40;
        img=right;
        isLeft=false;
    }
    void moveUp(){
        sy=-10;
    }
    void moveDown(){
        sy=10;
    }
    void moveStop(){
        sx=0;
        sy=0;
    }

}
