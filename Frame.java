import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

public class Frame extends JFrame {
    private Image raster;
    private Graphics rGraphics;
    private final int width;
    private final int height;


    public Frame(int width, int height){
        this.width = width;
        this.height = height;
        

        this.setSize(width,height);

    }

	public void setup(){        
        raster = this.createImage(width, height);
        rGraphics = raster.getGraphics();
    }

    public void draw() {
    	Player p = new Player(width, height);
    	addMouseListener(p); 
    	
        while(true)
        {
        	switch(p.currentScene)
        	{
        	case 0: 
        		p.intro(rGraphics);
        		break;
        	case 1:
        		p.howTo1(rGraphics);
        		break;
        	case 2:
        		p.howTo2(rGraphics);
        		break;
        	case 3:
        		p.gameSetup(rGraphics);
        		break;
        	case 4:
        		p.play(rGraphics);
        		break;
        	case 5:
        		p.feedCat(rGraphics);
        		break;
        	case 6:
        		p.plant(rGraphics);
        		break;
        	case 7:
        		//shop
        	case 8:
        		p.nextDay(rGraphics);
        		break;
        	case 9: 
        		p.gameOver(rGraphics);
        	}
        
            getGraphics().drawImage(raster,0,0,getWidth(),getHeight(),null);

            try{Thread.sleep(1);}catch(Exception e){}
        }
    }
}
