
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener,KeyListener{

    private class Tile
    {
        //cooridnates for snake
        int x;
        int y;
        Tile(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
     int boardwidth,boardheight;
    int tileSize=25; 
    
    //Snake 
    Tile snakeHead;
    ArrayList<Tile> snakeBody;
    
    //Food
    Tile food;
    
    // game Logic
    Timer gameLoop;
    int velocityX;
    int velocityY;
    boolean gameOver=false;
    
    //Random Cooridnate Food
    Random random;
            
    Panel(int boardwidth,int boardheight)
    {
        this.boardheight=boardheight;
        this.boardwidth=boardwidth;
        setPreferredSize(new Dimension(this.boardwidth,this.boardheight));
        setBackground(Color.black);
        
        snakeHead=new Tile(5,5);
        snakeBody=new ArrayList<Tile>();
        
        food =new Tile(10,10);
        random=new Random();
        placeFood();
        velocityX=0;
        velocityY=0;
        
        gameLoop = new Timer(100,this);
        gameLoop.start();
        addKeyListener(this);
        setFocusable(true);
    }
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    
    
    public void draw(Graphics g)
    {
        //Food 
        g.setColor(Color.red);
        g.fillRect(food.x * tileSize,food.y * tileSize, tileSize, tileSize);
        
        //Snake Head
        g.setColor(Color.green);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
        
       //Snake Body
       for(int i=0;i<snakeBody.size();i++)
       {
           Tile snakePart=snakeBody.get(i);
           g.fillRect(snakePart.x * tileSize, snakePart.y * tileSize, tileSize, tileSize);
       }
       
       //Score
       g.setFont(new Font("Arial",Font.PLAIN,16));
       if(gameOver)
       {
           g.setColor(Color.red);
           g.drawString("Game Over " + String.valueOf(snakeBody.size()),tileSize -16,tileSize);
       }
       else
       {
           g.drawString("Score" + String.valueOf(snakeBody.size()), tileSize-16,tileSize);
       }
       
    }
    
 
   public void placeFood()
   {
       food.x = random.nextInt(boardwidth/ tileSize);
       food.y = random.nextInt(boardheight/tileSize);
   }
   
   public boolean collision(Tile tile1,Tile tile2)
   {
       return tile1.x==tile2.x && tile1.y==tile2.y ;
   }
   
   public void move()
   {
       //eat food
       if(collision(snakeHead,food))
       {
           snakeBody.add(new Tile(food.x,food.y));
           placeFood();
       }
       
       //Snake Body
       for(int i=snakeBody.size()-1;i>=0;i--)
       {
           Tile snakePart =snakeBody.get(i);
           if(i==0)
           {
               snakePart.x=snakeHead.x;
               snakePart.y=snakeHead.y;
           }
           else
           {
               Tile prevSnakePart =snakeBody.get(i-1);
               snakePart.x=prevSnakePart.x;
               snakePart.y=prevSnakePart.y;
           }
       }
       
       
       //Snake Head
       snakeHead.x+=velocityX;
       snakeHead.y+=velocityY;
       
       // Game Over Condition
       for(int i=0;i<snakeBody.size();i++)
       {
           Tile snakePart =snakeBody.get(i);
           //Collision check
           if(collision(snakeHead,snakePart))
           {
               gameOver=true;
           }
                   
       }
       if(snakeHead.x *tileSize <0 || snakeHead.x *tileSize >boardwidth || snakeHead.y * tileSize<0 || snakeHead.y * tileSize>boardheight)
       {
           gameOver=true;
       }
       
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if(gameOver)
        {
            gameLoop.stop();
        }
    }
     @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_UP && velocityY!=1)
       {
           velocityX=0;
           velocityY=-1;
       }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN && velocityY!=-1)
        {
            velocityX=0;
            velocityY=1;
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT && velocityX != 1)
        {
            velocityX=-1;
            velocityY=0;
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT && velocityX!=-1)
        {
            velocityX=1;
            velocityY=0;
        }
            
    }

    @Override
    public void keyReleased(KeyEvent e) {}
   
}
