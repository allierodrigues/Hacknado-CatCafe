import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class Cat
{
	String name;
	boolean catFed;
	boolean hyperCat;
	boolean jumping;
	int x;
	int y;
	
	static int xPosList[] = {40,50,90,100,150,240,220,280,330,360,410,490,510,580,600,630};
	
	static ArrayList<Cat> List = new ArrayList<>();
	
	Cat()
	{
		this.catFed = false;
		this.hyperCat = false;

		List.add(this);
		this.x = xPosList[(int)(Math.random()*16)];
		this.y = 300;
	}
	Cat(String name)
	{
		this.catFed = false;
		this.hyperCat = false;

		List.add(this);
		this.name = name;
		this.x=xPosList[(int)(Math.random()*16)];
	}
	static boolean isAllFed()
	{
		for(Cat e : Cat.List)
			if(!e.catFed)
				return false;
		return true;
	}
	
	void draw(Graphics g)
	{
		g.setColor(new Color(255,152,194));
		g.fillRoundRect(x, y, 100, 75, 50, 50);
		int ear1X[] = {x,x+10,x+50};
		int ear2X[] = {x+50,x+90,x+100};
		int earsY[] = {y+20,y-20,y+20};
		
		g.fillPolygon(ear1X, earsY, 3);
		g.fillPolygon(ear2X, earsY, 3);
		g.setColor(new Color(224,255,123));
		g.fillOval(x+35, y+23, 10, 20);
		g.fillOval(x+55, y+23, 10, 20);
		
		if(!catFed) // drawing a coffee bean 
		{
			g.setColor(new Color(245,250,255));
			g.fillOval(x+100, y-20, 20, 20);
			g.fillOval(x+110, y-60, 40, 40);
			g.fillOval(x+40, y-160, 100, 100);
			
			g.setColor(new Color(192,225,255));
			g.drawOval(x+100, y-20, 20, 20);
			g.drawOval(x+110, y-60, 40, 40);
			g.drawOval(x+40, y-160, 100, 100);
			
			g.setColor(new Color(113,76,61));
			g.fillOval(x+75, y-131, 30, 40);
			g.setColor(new Color(67,45,36));
			g.fillOval(x+73, y-129, 15, 35);
			g.fillOval(x+92, y-129, 15, 35);
			
		}
		
		if(catFed)
		{
			g.setColor(Color.white);
			g.fillOval(x+45, y+45, 10, 10);
			g.setColor(new Color(255,152,194));
			g.fillRect(x+20, y+35, 60, 15);
			
		}
		
		if(hyperCat)
		{			
			if(jumping && y > 200)
				y--;
			else if(jumping && y == 200)
				jumping = false;
			else if (!jumping && y < 300)
				y++;
			else if(!jumping && y == 300)
				jumping = true;
		}

	}
}