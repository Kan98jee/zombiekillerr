import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Zombie extends character{
    Image left,right;
    int sx;
    boolean isLeft;
    boolean isRight;
    Zombie zom;
    public Zombie() {
        zom=this;
        x=(int)(Math.random()*3);
        if(x==0||x==1){
            x=1;
        }else{
            x=735;
        }
        y=(int)(Math.random()*140);
        if(y<140){
            y+=210;
        }else y+=140;
        //sx=0;
        width=145;
        height=150;
        left = new ImageIcon("zb11.gif").getImage();
        right = new ImageIcon("zb.gif").getImage();
        if(x<Frame.frame.getWidth()/2){
            img = right;
            if(Gamezombie.score<=750)
                sx=(int)(Math.random()*30)+30;
            else if(Gamezombie.score>500&&Gamezombie.score<=1000)
                sx=(int)(Math.random()*30)+60;
            else
                sx=(int)(Math.random()*30)+100;
            //sx=30;
        }else{
            img = left;
            if(Gamezombie.score<=650)
                sx=(int)(Math.random()*30)-30;
            else if(Gamezombie.score>500&&Gamezombie.score<=1000)
                sx=(int)(Math.random()*30)-60;
            else
                sx=(int)(Math.random()*30)-100;

            //sx=-30;
        }

        t = new Timer(350, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

				/*if(x+sx>=0&&x+width+sx<=Frame.frame.getWidth()){
					x+=sx;
				}else{
					Frame.frame.game.zombie.remove(zom);
				}*/
                x+=sx;
                //x+=sx;
                if(getBounds().intersects(Frame.frame.game.player.getBounds())){
                    //System.out.print("fff");
                    //Frame.frame.game.hearts.remove(hearts);
                    Gamezombie.x-=1;
                    //t.stop();
                    //break;

                }
            }
        });
        t.start();
    }

    void die(){
        Frame.frame.game.zombie.remove(this);
        t.stop();
    }


}