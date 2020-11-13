import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.*;

import javax.swing.*;
//import sun.audio.*;
class Play extends JPanel{
    private Timer timer = new Timer( 10, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(Gamezombie.over()){
                gover();
            }
        }
    });
    JButton p = new JButton(new ImageIcon("playy.jpg"));
    JButton howto = new JButton(new ImageIcon("howtoplay.jpg"));

    Image bg;




    public Play(){
        bg=new ImageIcon("bghorror1.jpg").getImage();
        setLayout(null);
        setSize(Frame.frame.getWidth(), Frame.frame.getHeight());
        p.setBounds(663, 190, 95, 50);
        howto.setBounds(6, 182, 120, 50);
        add(p);
        add(howto);
        p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Event handling เป็น ActionListener สำหรับกดไปหน้าเล่นเกมส
                timer.start();
                Frame.frame.remove(Frame.frame.play);
                if(Frame.frame.game==null){
                    Frame.frame.game=new Gamezombie();
                }
                Frame.frame.add(Frame.frame.game);
                Frame.frame.game.requestFocusInWindow();
                Frame.frame.repaint();
            }
        });
        howto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){ //MouseAdapterสำหรับกดไปหน้า How to play
                Frame.frame.remove(Frame.frame.play);
                if(Frame.frame.howto==null){
                    Frame.frame.howto=new Howto();
                }
                Frame.frame.add(Frame.frame.howto);
                Frame.frame.repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, 827, 477,this);

    }

    public void gover (){
        Frame.frame.remove(Frame.frame.game);
        if(Frame.frame.end==null){
            Frame.frame.end=new Endgame();
        }
        timer.stop();
        Frame.frame.add(Frame.frame.end);
        Frame.frame.end.requestFocusInWindow();
        Frame.frame.repaint();
    }


}