import java.util.ArrayList;
import java.util.Scanner;

import java.io.IOException;

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

/*
class catDriver {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("NAME YOUR FIRST CAT!!");
		Player p = new Player(scan.next());
		scan.close();
		do //game loop (until you lose)
		{
			int opt;
			System.out.println("\n\nDay" + p.day++);

			
			do // day loop (until end of day)
			{
				Scanner scan2 = new Scanner(System.in);

				System.out.println("\nYou have " +p.coffeeBeans + " coffee beans");
				
				System.out.println("Chose an action");
				
				if(!Cat.isAllFed())
				System.out.println("    1. Feed cat");
				
				System.out.println("    2. Buy new cat");
				
				if(!p.isCoffeePlanted)
				System.out.println("    3. Plant coffee");
				
				System.out.println("    0. End day");
			
				System.out.println(scan2.next());
				opt = Integer.parseInt(scan2.next());
			
				switch(opt)
				{
				case 1:
					p.feedCat();
					break;
				case 2:
					p.buyCat();
					break;
				case 3:
					p.plantCoffee();
					break;
				case 0:
					p.nextDay();
				}
				scan2.close();
			}
			while(opt!=0);
			
		}
		while(!Cat.List.isEmpty() && (p.coffeeBeans>0||p.coffeeHarvested>0));
		
		System.out.print("GAME OVER");
		if(Cat.List.isEmpty())
			System.out.print("\nAll your cats died :(");
		else
			System.out.print("\nYou're bankrupt :(");
	}
	
}

class Player
{
	int day;
	int coffeeBeans;
	int coffeeHarvested;
	boolean isCoffeePlanted;
	
	Player(String firstCatName)
	{
		this.day = 1;
		this.coffeeBeans = 200;
		this.coffeeHarvested = 0;
		this.isCoffeePlanted = false;
		new Cat(firstCatName);
	}
	
	void buyCat()
	{
		if(coffeeBeans<1000)
		{
			System.out.println("You don't have enough coffee");
		}
		else
		{
			System.out.println("\nName new cat");
			Scanner scan = new Scanner(System.in);
	
			coffeeBeans-=1000;
			new Cat(scan.next());
			scan.close();
		}
	}
	void feedCat(Cat c) //check if already fed
	{
		if(coffeeBeans>50 && c.catFed == false)
		{
			coffeeBeans-=50;
			c.catFed = true;
			System.out.println("You fed " + c.name + "!!");
		}
		else if (c.catFed)
		{
			System.out.println("You already fed " + c.name + " today!");

		}
		else
		{
			System.out.println("You don't have enough coffee");
		}
	}
	void feedCat()
	{
		Scanner scan1 = new Scanner(System.in);
		
		for(int i = 0; i < Cat.List.size();i++)
		{
			System.out.println(i + ". " + Cat.List.get(i).name);
		}
		System.out.println("Enter cat number");
		
		int catNo = Integer.parseInt(scan1.next());
		feedCat(Cat.List.get(catNo));
		
		
		scan1.close();
	}
	
	void plantCoffee ()        //YOU NEED TO IMPLEMENT PLANTING ONCE A DAY MAX
	{
		Scanner scan1 = new Scanner(System.in);
		
		if (isCoffeePlanted)
		{
			System.out.println("You already planted coffee today");	
			
		}

		else
		{
			System.out.println("Enter amount of coffee to plant");
			int coffeeToPlant = Integer.parseInt(scan1.next());
		
			if(coffeeToPlant>coffeeBeans)
			{
				System.out.println("You don't have enough coffee");	
			}
		
			else
			{
				System.out.println("You planted " + coffeeToPlant + " coffee beans!");
				coffeeBeans-=coffeeToPlant;
				isCoffeePlanted=true;
				double profit = -0.5 + 0.5*Math.log10(coffeeToPlant);
				coffeeHarvested = (int)((1+profit)*coffeeToPlant);
			}
		}
		scan1.close();
	}
	void nextDay()   // add some daily updates. You harvested x coffee, you now have =. Your cat "" died
	{
		if(Cat.List.isEmpty())
		{
			System.out.print("All your cats died :(");
		}
		else
		{	
			coffeeBeans += coffeeHarvested;
			coffeeHarvested = 0;      //setting up for next day
			for(int i = 0; i < Cat.List.size();i++)
				if (!Cat.List.get(i).catFed)
				{
					System.out.println(Cat.List.get(i).name + " died :((");
					Cat.List.remove(Cat.List.get(i));

				}
				else
				{
					Cat.List.get(i).catFed = false; //setting up for next day
					isCoffeePlanted = false;
				}
		}
	}
}
*/


