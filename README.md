# Hacknado-CatCafe

This is a business game involving cats and coffee beans.
Coffee beans are almost extinct and your cats need coffee! Can you save the world's favorite beverage and the internet's favorite animal from extinction?

# Inspiration
This hackathon's "climate crisis" theme inspired this project. I decided to focus on the **resource management** aspect of the climate crisis and create a game in which surviving is almost impossible due to limited resources. Players should employ a strategy to ensure sufficient coffee generation before they can sustain a house full of hyper cats.

# Game Objective
The game ends when your cats die. You can buy as many cats as you'd like, but you must feed them coffee beans every day. To earn coffee beans, you can plant them (only once a day) and collect your harvest the next day. It's similar to investing money and earning a profit on it. Here the profit varies: the more you plant at a time the more profit you make. There are even negative profits (losses), so be careful!

# Game Strategy and the interesting math behind it
The more cats you have, the more difficult it is to sustain. One guaranteed way to never lose the game is to have one cat and feed it 50 coffee beans (the minimum) and plant 100 coffee beans each day. This way, you start out with 200 coffee beans every day. I used this equilibrium to build the logarithmic equation to calculate profits. 
There are beautiful mathematical puzzles that arise from this model. For example, how many days minimum would it take for you to get 8 cats? There are so many ways to do that but I'm not sure what the fastest way is. I'm sure the answer would be fascinating.

# How I built it
This project was the first time I worked with scenes and interactive buttons in Java. After developing the idea for the game, I tried to figure out the math and mechanics of the game. Then I tested out a simple text-based version of the game. After that, I started with an outline of what scenes I wanted (title screen, instructions, different menus, replay button) and worked on each one by one. I worked on the design when I needed a break from figuring out how to link my buttons to their functions. Switching tasks like this kept me fresh and helped me power through this project over the weekend.

# Challenges I ran into
I initially intended to add my own digital art for the background and objects, but I couldn't figure out how to display images. I decided to make it entirely with basic shapes, which was a fun challenge. I wish I learned how to display images but I guess I'll figure that out next time.

# What's next for Cat Cafe
I'll add options to customize the cat and name the cat. Maybe buy different kinds of cats. Include better graphics and animations. In terms of better code, I would add a class to handle buttons and use more loops and functions to make the code sleeker.
