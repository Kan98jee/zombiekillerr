import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Howto extends JPanel{
    Image bg;
    //JLabel back;
    JButton p = new JButton(new ImageIcon("backk.jpg"));
    public Howto() {
        // TODO Auto-generated constructor stub
        bg = new ImageIcon("howtoo.jpg").getImage();
        setLayout(null);
        setSize(Frame.frame.getWidth(), Frame.frame.getHeight());
        //setSize(827, 477);
		/*back = new JLabel("BACK");
		back.setBounds(0,0,50,50);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Frame.frame.remove(Frame.frame.howto);
				Frame.frame.add(Frame.frame.play);
				Frame.frame.repaint();
			}
		});
		add(back);*/
        p.setBounds(650, 370, 145, 56);
        add(p);
        p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("PLAY");
                Frame.frame.remove(Frame.frame.howto);
                if(Frame.frame.play==null){
                    Frame.frame.play=new Play();
                }
                Frame.frame.add(Frame.frame.play);
                Frame.frame.play.requestFocusInWindow();
                Frame.frame.repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, 827, 477,this);
        //g.fillRect(0, 0, getWidth(), getHeight());
    }
}