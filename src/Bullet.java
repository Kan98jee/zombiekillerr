import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bullet extends character{
    int sx,sy;
    static Image imgL = new ImageIcon("Bulletl.gif").getImage();
    static Image imgR = new ImageIcon("Bulletr.gif").getImage();
    Bullet bullet;
    public Bullet(Player player) {
        // TODO Auto-generated constructor stub
        bullet=this;
        x=player.getX();
        y=player.getY();
        width=24;
        height=12;

        if(player.isLeft){
            sx=-50;
            img=imgL;
        }else
        {
            sx=50;
            img=imgR;
        }
        t = new Timer(33, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                x+=sx;
                y+=sy;
//				if(x+sx>=0&&x+width+sx<=Frame.frame.getWidth())

                for(int i=0;i<Frame.frame.game.zombie.size();i++){
                    if(Frame.frame.game.zombie.get(i).getBounds().intersects(getBounds())){
                        Frame.frame.game.zombie.get(i).die();
                        Frame.frame.game.bullet.remove(bullet);
                        Gamezombie.score+=50;
                        t.stop();
                        break;
                    }
                }
                for(int i=0;i<Frame.frame.game.food.size();i++){
                    if(Frame.frame.game.food.get(i).getBounds().intersects(getBounds())){
                        Frame.frame.game.food.get(i).die();
                        Frame.frame.game.bullet.remove(bullet);
                        Gamezombie.x+=1;
                        t.stop();
                        break;
                    }
                }
            }
        });
        t.start();
    }
    public Bullet() {
        Player p=new Player();
        new Bullet(p);
    }
}