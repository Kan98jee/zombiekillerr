import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gamezombie extends JPanel implements KeyListener{
    Image gg,hh,gg2,gg3;
    Player player;
    Timer t1,t2;
    ArrayList<Bullet> bullet;
    ArrayList<Zombie> zombie;
    ArrayList<Food> food;
    Hearts hearts;
    static int x=5;
    static int score=0;
    static int checkover=0;
    public Gamezombie() {
        // TODO Auto-generated constructor stub
        gg3 = new ImageIcon("bg3.jpg").getImage();
        gg2 = new ImageIcon("bg2.jpg").getImage();
        gg = new ImageIcon("bg1.jpg").getImage();

        hh = new ImageIcon("heart.png").getImage();

        setLayout(null);
        setSize(Frame.frame.getWidth(), Frame.frame.getHeight());
        t1 = new Timer(33,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.frame.game.repaint();
            }
        });
        t2 = new Timer(1000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zombie.add(new Zombie());
                food.add(new Food());
            }

        });
        t1.start();
        t2.start();
        addKeyListener(this);
        player = new Player();
        bullet = new ArrayList<Bullet>();
        zombie = new ArrayList<Zombie>();
        food = new ArrayList<Food>();
        hearts = new Hearts();

    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        if(score<750){
            //this.setVisible(true);
            g.drawImage(gg, 0, 0, 827, 477,this);
            //this.setVisible(true);
        }else if (score>=750&&score<1500){
            g.drawImage(gg2, 0, 0, 827, 477,this);

        }else{
            g.drawImage(gg3, 0, 0, 827, 477,this);
        }
        g.drawImage(player.getImage(), player.getX(), player.getY(),player.getWidth(),player.getHeight(),this);
        for(int i=0;i<bullet.size();i++){
            g.drawImage(bullet.get(i).getImage(), bullet.get(i).getX(), bullet.get(i).getY(),bullet.get(i).getWidth(),bullet.get(i).getHeight(),this);
        }
        for(int i=0;i<zombie.size();i++){
            g.drawImage(zombie.get(i).getImage(), zombie.get(i).getX(), zombie.get(i).getY(),zombie.get(i).getWidth(),zombie.get(i).getHeight(),this);
        }
        for(int i=0;i<food.size();i++){
            g.drawImage(food.get(i).getImage(), food.get(i).getX(), food.get(i).getY(),food.get(i).getWidth(),food.get(i).getHeight(),this);
        }
        g.drawImage(hh, 10, 10, 30, 30,this);
        g.setFont(new Font("JasmineUPC",Font.BOLD,30));
        g.setColor(Color.WHITE);
        g.drawString(" "+x, 40, 30);
        g.setFont(new Font("JasmineUPC",Font.BOLD,30));
        g.setColor(Color.WHITE);
        g.drawString("SCORE : "+score, 650, 30);

        if(x<=0){
            checkover=1;
        }
        repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            player.moveLeft();
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            player.moveRight();
        }
        else if(e.getKeyCode()==KeyEvent.VK_UP){
            player.moveUp();
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            player.moveDown();
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            bullet.add(new Bullet(player));
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_DOWN){
            player.moveStop();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public static boolean over(){
        if(checkover==1){
            return true;
        }else return false;
    }

    public void reset(){
        x=5;
        score=0;
        checkover=0;

        bullet.removeAll(bullet);
        zombie.removeAll(zombie);
        food.removeAll(food);
    }

}
