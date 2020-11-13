import javax.swing.JFrame;

public class Frame extends JFrame{
    static Frame frame;
    Play play;
    Howto howto;
    Gamezombie game;
    Endgame end;
    public Frame() {
        frame=this;
        setTitle("Zombie Killer");
        setSize(827, 477);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        play = new Play();
        // TODO Auto-generated constructor stub
        add(play);
        setVisible(true);
    }

    public static void main(String[] args){
        new Frame();
    }
}
