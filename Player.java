import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/* ****************** SCENES ********************
 *	0. intro
 *	1. howToPlay1	-	click cat to feed
 *	2. howToPlay2	-	plant coffee (how mech works)
 *	3. firstCat		-	your first cat (name it maybe?)
 *	4. play			- 	game window/
 *	5. feedWindow	-	chose cup size/coffee amount
 *	6. plantWindow	-	choose how much to plant
 *	7. shopWindow	-	buy cats, skins, automatic coffee planters???
 *	8. nextDay		-	daily update ( harvest, cat died etc)
 * 	9. game over 	-	replay button 
 */
class Player implements MouseListener
{

	int currentScene;
	int width, height;
	
	int day;
	int coffeeBeans;
	int coffeeToPlant;
	int coffeeHarvested;

	
	Cat selectedCat;
	
	
	final Font h1 = new Font("Serif", Font.ITALIC|Font.BOLD, 60);
	final Font h2 = new Font("SansSerif", Font.BOLD, 30);
	final Font h3 = new Font("SansSerif", Font.BOLD, 18);
	final Font h4 = new Font("SansSerif", Font.BOLD, 16);
	final Font h6 = new Font("SansSerif", Font.PLAIN, 13);

	private boolean PLAY, NEXT, START;		//gets you through the instructions
	private boolean REGULAR, HYPER, BACK; 	//buttons on the feed cat menu
	
	//4 very similarly named booleans, im so sorry for this
	private boolean PLANTBACK, 	//the back button on the plant menu
					PLANTMENU, 	//the button that takes you to the plant menu
					PLANT, 		//the confirm button on the plant menu
					isCoffeePlanted; 	//checks if you already planted today
	
	private boolean BUY, NEXTDAY, OKAY,REPLAY;
	
	
	
	Player(int width, int height)
	{
		this.currentScene = 0;                 
		this.width = width;
		this.height = height;
	}
	
	void intro(Graphics g)
	{
		if(PLAY)
        {
			currentScene++;
            PLAY = false;
        }
		else 
        {
			home(g);
	    
			g.setColor(new Color(114,68,35));
	
			g.setFont(h3);
	        g.drawString("WELCOME TO",335,100);
	        g.setFont(h1);
	        g.drawString("Cat Cafe", 285, 150);
	        g.setFont(h4);
	        g.drawString("Coffee beans are almost extinct and your cats need coffee.",200,195);
	        g.drawString("Can you save coffee and your cats?",264,210);
	        
	        g.fillRect(350,250,100,50); 
	        
	        g.setColor(new Color(157,217,210));
	        g.fillRect(345,245,100,50);
	        
	        g.setFont(h2);
	        g.setColor(Color.white);
	        g.drawString("PLAY", 357, 283);
	        
    
        }
        
	}
	
	public void howTo1(Graphics g) 
	{
		if(NEXT)
        {
        	currentScene++;
            NEXT = false;
        }
		g.setColor(new Color(157,217,210));
		g.fillRect(0,0,800,450);
		
		g.setColor(new Color(255,255,168));
		g.fillRoundRect(300, 80, 200, 25, 50, 50);
		g.setColor(new Color(114,68,35));		
		g.setFont(h3);
		g.drawString("FEED YOUR CATS", 320, 100);
		
		g.setFont(h4);
		g.drawString("1. Click on the cat you want to feed.", 150, 150);
		g.drawString("2. Select how much coffee you want to feed it.", 150, 170);
		g.drawString("Your cat will die if it isn't fed daily.", 100, 230);
		g.drawString("If all your cats have died, it's game over.", 100, 250);
		
        g.fillRect(350,300,100,50); 
        
        g.setColor(new Color(255,255,168));
        g.fillRect(345,295,100,50);
        
        g.setFont(h2);
        g.setColor(new Color(114,68,35));
        g.drawString("NEXT", 357, 333);
		
	}
	
	public void howTo2(Graphics g) 
	{
		
		if(START)
        {
        	currentScene++;
            START = false;
        }
		
		g.setColor(new Color(157,217,210));
		g.fillRect(0,0,800,450);
		
		g.setColor(new Color(255,255,168));
		g.fillRoundRect(300, 80, 200, 25, 50, 50);
		g.setColor(new Color(114,68,35));		
		g.setFont(h3);
		g.drawString("GROW COFFEE", 333, 100);
		
		g.setFont(h4);
		g.drawString("1. Click on PLANT COFFEE.", 150, 150);
		g.drawString("2. Select how much coffee you want to plant.", 150, 170);
		g.drawString("3. Click on NEXT DAY and recieve your harvest.", 150, 190);

		g.drawString("You can only plant once a day. Plant more to get larger profits!", 100, 250);
		
		g.setFont(h6);
		g.drawString("nerd info: the amount of coffee harvested is a logarithmic function of how much is planted. this comes from the idea that the more", 30, 420);
		g.drawString("plants you have in an ecosystem, the more plants will grow. in reality, it's more complicated than one logarithm, obviously.", 30, 435);
		 
		
        g.fillRect(350,300,100,50); 
        
        g.setColor(new Color(255,255,168));
        g.fillRect(345,295,100,50);
        
        g.setFont(h2);
        g.setColor(new Color(114,68,35));
        g.drawString("START", 345, 333);
		
		
	}
	
	public void gameSetup(Graphics g)
	{
		
		day = 1;
		new Cat();
		coffeeBeans = 200;
		coffeeHarvested = 0;
		currentScene++;
		
		/*
		home(g);
		g.setColor(new Color(255,192,255,128));
		g.fillRoundRect(50, 50, 700, 350, 50, 50);
		
		//name your first cat
		*/

	}
	
	public void play(Graphics g)
	{
		if(PLANTMENU)
        {
        	currentScene++;
            PLANTMENU = false;
        }
		if(NEXTDAY)
		{
			day++;
			NEXTDAY = false;
			
			currentScene = 8;
			if(Cat.List.isEmpty())
				currentScene = 9;
		}
		if(BUY)
		{
			BUY = false;
			if(coffeeBeans>=500)			
			{
				new Cat();
				coffeeBeans-=500;
			}
		}
		
		home(g);
		for(Cat e:Cat.List)
			e.draw(g);
		
		g.setColor(new Color(241,172,95));
		g.fillRoundRect(50, 47, 200, 25, 50, 50);
		g.fillRoundRect(550, 47, 200, 25, 50, 50);
		
		
		g.setFont(h3);
		g.setColor(new Color(113,76,61));
		g.drawString(" coffee beans: " + coffeeBeans, 60, 65);
		g.drawString(" day " + day, 560, 65);
		
		g.fillRect(55, 90, 200, 50);
		g.fillRect(625, 390, 120, 40);
		g.fillRect(605, 90, 150, 70);
		
		g.setColor(new Color(152,255,194));
		g.fillRect(50, 85, 200, 50);
				
		g.setColor(new Color(157,217,210));
		g.fillRect(620, 385, 120, 40);
		
		g.setColor(new Color(255,152,194));		
		g.fillRect(600, 85, 150, 70);
		
		g.setFont(h3);
		g.setColor(new Color(113,76,61));
		g.drawString("PLANT COFFEE", 80, 115);
		g.drawString("NEXT DAY", 635, 412);
		g.drawString("BUY CAT", 635, 110);
		g.setFont(h4);
		g.drawString("- 500 coffee beans", 605, 135);
	}

	public void feedCat(Graphics g)
	{
		if(BACK)
		{
			BACK = false;
			currentScene = 4;				
		}
		
		g.setColor(new Color(255,152,194));
		g.fillRect(0, 0, width, height);
		
		g.setColor(new Color(67,45,36));
		g.fillRoundRect(300, 80, 200, 25, 50, 50);
		g.setColor(new Color(255,255,168));		
		g.setFont(h3);
		g.drawString("FEED YOUR CAT", 327, 100);
		
		g.fillRoundRect(50, 150, 300, 150, 50, 50);
		g.fillRoundRect(450, 150, 300, 150, 50, 50);
		
		g.setColor(new Color(67,45,36));
		g.drawString("Regular", 100, 200);
		g.drawString("Hyper", 500, 200);
		
		g.setFont(h4);
		g.drawString("- 50 coffee beans",200,200);
		g.drawString("-100 coffee beans",600,200);
		
		g.setFont(h6);
		g.drawString("imagine there's a happy cat here",100,250);
		g.drawString("imagine there's a hyper cat here",500,250);
		
        g.fillRect(350,350,100,50);
        
        g.setColor(new Color(255,255,168));
        g.fillRect(345,345,100,50);
        
        g.setFont(h2);
        g.setColor(new Color(114,68,35));
        g.drawString("BACK", 352, 383);
        
		if(REGULAR)
		{
			if(coffeeBeans<50)
			{
				g.setFont(h3);
				g.drawString("you don't have enough coffee",270,330);				
			}
			else if(selectedCat!=null)
			{
				coffeeBeans-=50;
				selectedCat.catFed = true;
				selectedCat = null;
				REGULAR = false;
				currentScene--;				
			}
		}
		if(HYPER)
		{
			if(coffeeBeans<100)
			{
				g.setFont(h3);
				g.drawString("you don't have enough coffee",270,330);				
			}
			else if(selectedCat!=null)
			{
				coffeeBeans-=100;
				selectedCat.catFed = true;
				selectedCat.hyperCat = true;
				
				selectedCat = null;
				HYPER = false;
				currentScene--;				
			}
		}
	}
	
	void plant(Graphics g)
	{
		PLANTMENU = false;
		if(PLANTBACK)
		{
			PLANTBACK = false;
			currentScene = 4;	
			
		}
		else if(PLANT) //maybe implement a please enter more than zero?
		{
			coffeeBeans -= coffeeToPlant;
			double profit = -0.5 + 0.5*Math.log10(coffeeToPlant);
			coffeeHarvested = (int)((1+profit)*coffeeToPlant);
			
			isCoffeePlanted = true;
			PLANT = false;
			
			currentScene = 4;
		}
		else if (isCoffeePlanted)
		{
			g.setColor(new Color(152,255,194));
			g.fillRect(0, 0, width, height);
			
			g.setColor(new Color(67,45,36));	
			g.drawString("You have already planted today", 200, 200);
			g.fillRect(350, 350, 100, 50);
	        
			g.setColor(new Color(255,255,168));
	        g.fillRect(345,345,100,50);
	        
	        g.setFont(h2);

	        g.setColor(new Color(114,68,35));
	        g.drawString("BACK", 352, 383);
		
		}
		else
		{
			g.setColor(new Color(152,255,194));
			g.fillRect(0, 0, width, height);
			
			g.setColor(new Color(67,45,36));
			g.fillRoundRect(300, 80, 200, 25, 50, 50);
			g.setColor(new Color(255,255,168));		
			g.setFont(h3);
			g.drawString("PLANT COFFEE", 327, 100);
			
			g.setColor(new Color(241,172,95));
			g.fillRoundRect(50, 120, 200, 25, 50, 50);
						
			
			g.setColor(new Color(67,45,36));			
			g.drawString("Coffee beans: " + coffeeBeans, 70, 140);
			g.drawString("Number of coffee beans selected: " + coffeeToPlant, 140, 200);
			
			drawNumberButton(g, -10);
			drawNumberButton(g, 50);
			drawNumberButton(g, 110);
			drawNumberButton(g, 170);
			drawNumberButton(g, 230);		
			
			g.setFont(h2);
			g.setColor(new Color(67,45,36));
			g.drawString(""+(coffeeToPlant/10000)%10, 510, 200);
			g.drawString(""+(coffeeToPlant/1000)%10, 570, 200);
			g.drawString(""+(coffeeToPlant/100)%10, 630, 200);
			g.drawString(""+(coffeeToPlant/10)%10, 690, 200);
			g.drawString(""+coffeeToPlant%10, 750, 200);
			
			g.setColor(new Color(67,45,36));	
			g.fillRect(325, 250, 150, 80);
			g.fillRect(350, 350, 100, 50); 
	        
			g.setColor(new Color(36,127,67));
		    g.fillRect(320, 245, 150, 80);
		        
	        g.setColor(new Color(255,255,168));
	        g.fillRect(345,345,100,50);
	        
	        g.setFont(h2);
	        g.setColor(Color.white);	        
	        g.drawString("PLANT",346, 295);
	        g.setColor(new Color(114,68,35));
	        g.drawString("BACK", 352, 383);
		}
        
	}
	
	void nextDay(Graphics g)
	{
		
		NEXTDAY = false;
		
		g.setColor(new Color(255,255,168));
		g.fillRect(0, 0, width, height);
		
		g.setColor(new Color(67,45,36));
		g.drawString("DAY "+ day, 100,100);
		
		g.setFont(h3);
		
		int i = 0;
		for(Cat c : Cat.List)	
		{
			if (!c.catFed)
			{
				g.drawString("Another cat died", 150, 190+i);
				Cat.List.remove(c);
				i+=20;
				break;
			}
		}
		
		g.drawString("You harvested " + coffeeHarvested + " coffeeBeans", 150, 150);

		g.drawString("You now have " + (int)(coffeeBeans+coffeeHarvested) + " coffeeBeans", 150, 170);
		
		
		if(OKAY)
		{
			OKAY = false;
					
			coffeeBeans+=coffeeHarvested;
			coffeeHarvested = 0;
			isCoffeePlanted = false;
			coffeeToPlant = 0;
			
			for(Cat c : Cat.List)	
			{
				if (!c.catFed)
				{					
					Cat.List.remove(c);
					break;
				}
			}
			for(Cat c : Cat.List)	
			{
				c.catFed = false;
				c.hyperCat = false;
				c.y = 300;
			}
			
			if(Cat.List.isEmpty())
				currentScene = 9;
			else
				currentScene = 4;			
		}
		

				
		
		g.setColor(new Color(67,45,36));	
		g.fillRect(350, 350, 100, 50);
        
		g.setColor(new Color(255,255,168));
        g.fillRect(345,345,100,50);
        
        g.setFont(h2);

        g.setColor(new Color(114,68,35));
        g.drawString("OKAY", 352, 383);
		
	}

	void gameOver(Graphics g)
	{
		if(REPLAY)
		{
			REPLAY = false;
			currentScene = 0;
		}
		
		g.setColor(Color.pink);
		g.fillRect(0, 0, width, height);
		
		g.setColor(new Color(67,45,36));
		g.drawString("GAME OVER", 100,100);
		
		g.setFont(h4);
		g.drawString("You survived for " + (day-1) + "day(s).", 100,150);
		g.setFont(h3);
		g.drawString("Play again?", 100,200);
		
		g.setColor(new Color(67,45,36));	
		g.fillRect(340, 350, 120, 50);
        
		g.setColor(new Color(255,255,168));
        g.fillRect(335, 345, 120, 50);
        
        g.setFont(h2);

        g.setColor(new Color(114,68,35));
        g.drawString("REPLAY", 334, 383);
		
		
	}
	
	void home(Graphics g)
	{		
        g.setColor(new Color(254,218,121));
        g.fillRect(0,0,width,height);
        for (int i = 0 ; i < width; i+=50)
        	for (int j = 0; j < 0.7*height; j+=50)
        	{	
        		g.setColor(new Color(255,255,168));	
        		g.fillRect(i, j, 45, 45);
        		g.setColor(new Color(255,255,148));
        		g.fillRect(i, j, 5, 45);
        		g.setColor(new Color(255,255,208));	
        		g.fillRect(i, j, 45, 5);
        		g.setColor(new Color(255,255,188));	
        		g.fillRect(i+40, j, 5, 45);
        		g.setColor(new Color(255,245,148));	
        		g.fillRect(i, j+40, 40, 5);     		


        	}
        g.setColor(new Color(241,172,75));
		g.fillRect(0,(int)(0.75*height),width,10);	      
    }
    
	void drawNumberButton(Graphics g, int x)
	{
		g.setColor(new Color(67,45,36));
		
		g.fillRoundRect(500+x, 135, 50, 30, 50, 50);
		g.fillRoundRect(500+x, 215, 50, 30, 50, 50);
			
		g.setColor(new Color(255,255,168));			
		int buttonsX[] = {510+x,525+x,540+x};
		int upY[] = {155,140,155};
		int downY[] = {225,240,225};			
		g.fillPolygon(buttonsX, upY, 3);
		g.fillPolygon(buttonsX, downY, 3);
		
	}
    
	
    
    @Override
	public void mouseClicked(MouseEvent e) 
	{
    
    	int x = e.getX();
		int y = e.getY();
		
		if(currentScene == 0)
		{
			if((x>350)&&(x<450)&&(y>250)&&(y<300))
			{	
				PLAY=true;	
			}
		}
		else if(currentScene == 1)
		{
			if((x>350)&&(x<450)&&(y>300)&&(y<350))
			{	
				NEXT=true;	
			}
		}
		else if(currentScene == 2)
		{
			if((x>350)&&(x<450)&&(y>300)&&(y<350))
			{	
				START=true;	
			}
		}
		
		else if((currentScene == 4) && (x>50) && (x<250)&&(y>85)&&(y<135))
		{
			currentScene+=2;
			PLANTMENU = true;
		}
		else if((currentScene == 4) && (y>300)&&(y<375))
		{
			for(Cat c: Cat.List)
			{
				if((!c.catFed)&&(x>c.x)&&(x<c.x+100))
				{					
					currentScene++;
					selectedCat = c;
					break;
				}
			}
		}
		else if((currentScene == 4) && (x>620) && (x<740) && (y>385) && (y<425))
		{
			NEXTDAY = true;
		}
		else if((currentScene == 4) && (x>600) && (x<750) && (y>85) && (y<155))
		{
			BUY = true;
		}
		else if((currentScene == 5))
		{
			//50, 150, 300, 250
			if((x>50)&&(x<350)&&(y>150)&&(y<300))
				REGULAR = true;
			if((x>450)&&(x<750)&&(y>150)&&(y<300))
				HYPER = true;
			if((x>345)&&(x<445)&&(y>345)&&(y<395))
				BACK = true;
		}
		
		
		else if((currentScene == 6))
		{
			if((x>345)&&(x<445)&&(y>345)&&(y<395))
				PLANTBACK = true;
			else if((x>490)&&(x<540)&&(y>135)&&(y<165)&&(coffeeToPlant+10000<=coffeeBeans))
				coffeeToPlant+=10000;
			else if((x>550)&&(x<600)&&(y>135)&&(y<165)&&(coffeeToPlant+1000<=coffeeBeans))
				coffeeToPlant+=1000;
			else if((x>610)&&(x<660)&&(y>135)&&(y<165)&&(coffeeToPlant+100<=coffeeBeans))
				coffeeToPlant+=100;
			else if((x>670)&&(x<720)&&(y>135)&&(y<165)&&(coffeeToPlant+10<=coffeeBeans))
				coffeeToPlant+=10;
			else if((x>730)&&(x<780)&&(y>135)&&(y<165)&&(coffeeToPlant+1<=coffeeBeans))
				coffeeToPlant+=1;
			
			else if((x>490)&&(x<540)&&(y>215)&&(y<245)&&(coffeeToPlant-10000>=0))
				coffeeToPlant-=10000;
			else if((x>550)&&(x<600)&&(y>215)&&(y<245)&&(coffeeToPlant-1000>=0))
				coffeeToPlant-=1000;
			else if((x>610)&&(x<660)&&(y>215)&&(y<245)&&(coffeeToPlant-100>=0))
				coffeeToPlant-=100;
			else if((x>670)&&(x<720)&&(y>215)&&(y<245)&&(coffeeToPlant-10>=0))
				coffeeToPlant-=10;
			else if((x>730)&&(x<780)&&(y>215)&&(y<245)&&(coffeeToPlant-1>=0))
				coffeeToPlant-=1;
			
			
			else if((x>325)&&(x<475)&&(y>250)&&(y<330))
				PLANT = true;
				
		}
		
		else if((currentScene == 8) && (x>350) && (x<450) && (y>350) &&(y<400))
		{
			OKAY = true;

		}
		else if((currentScene == 9) && (x>350) && (x<450) && (y>350) &&(y<400))
		{
			REPLAY = true;

		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
