import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Food extends character{
    Image left,right;
    int sx;
    boolean isLeft;
    boolean isRight;
    Food food;
    public Food() {
        food=this;
        x=(int)(Math.random()*3);
        if(x==0||x==1){
            x=1;
        }else{
            x=735;
        }
        y=(int)(Math.random()*100);
        if(y<100){
            y+=210;
        }else y+=100;
        //sx=0;
        width=50;
        height=55;
        left = new ImageIcon("wtml.png").getImage();
        right = new ImageIcon("wtml.png").getImage();
        if(x<Frame.frame.getWidth()/2){
            img = right;
            if(Gamezombie.score<=500)
                sx=(int)(Math.random()*80)+70;
            else if(Gamezombie.score>650&&Gamezombie.x<=1500)
                sx=(int)(Math.random()*80)+100;
            else
                sx=(int)(Math.random()*80)+120;
            //sx=30;
        }else{
            img = left;
            if(Gamezombie.score<=500)
                sx=(int)(Math.random()*80)-70;
            else if(Gamezombie.score>650&&Gamezombie.x<=1500)
                sx=(int)(Math.random()*80)-100;
            else
                sx=(int)(Math.random()*80)-120;

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

            }
        });
        t.start();
    }

    void die(){
        Frame.frame.game.food.remove(this);
        t.stop();
    }


}