import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class Endgame extends JPanel{
    Gamezombie g = new Gamezombie();
    Image en;
    //JButton b = new JButton(new ImageIcon("back.png"));
    public Endgame(){
        en = new ImageIcon("endd.jpg").getImage();
        setLayout(null);
        setSize(Frame.frame.getWidth(), Frame.frame.getHeight());

        //b.setBounds(650, 350, 145, 56);
        //add(b);
		/*b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Frame.frame.remove(Frame.frame.end);
				if(Frame.frame.play==null){
					Frame.frame.play= new Play();
				}
				Frame.frame.add(Frame.frame.play);
				//Frame.frame.game.requestFocusInWindow();
				Frame.frame.repaint();
				//Gamezombie.reset();
				g.reset();
			}
		});*/
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                Frame.frame.remove(Frame.frame.end);
                System.exit(0);
        		/*if(Frame.frame.howto==null){
        			Frame.frame.howto=new Howto();
        		}
        		Frame.frame.add(Frame.frame.howto);
				Frame.frame.repaint();*/
            }
        });
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(en, 0, 0, 827, 477, this);

        g.setFont(new Font("outrun future",Font.BOLD,34));
        g.setColor(Color.RED);
        g.drawString("SCORE : "+Gamezombie.score, Frame.frame.getWidth()/2-100, Frame.frame.getHeight()/2+30);

    }

}