import javax.swing.WindowConstants;

public class catDriver {
    public static void main(String[] arg) 
    {
        Frame sim = new Frame(800,450); //width,height
        
        sim.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sim.setVisible(true);
        sim.setup();
        sim.draw();
    }
}
