import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**holds all my classes set in the world
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1000, 800, 1); 
        //player and interacting classes
        Player player = new Player();
        addObject(player,getWidth()/1 - 700, getHeight()/2 + 300);
        
        Heart heart = new Heart();
        addObject(heart, getWidth()/1 - 400, getHeight() - 700);
        
        enemy_ghost Ghost = new enemy_ghost();
        addObject(Ghost, getWidth()/1 - 970, getHeight() - 350);
        
        //do not touch!
        
        groundPlatform ground = new groundPlatform();
        addObject(ground,getWidth()/1 - 500, getHeight()/2 + 400);
        
        //do not touch!
        
        
        platform platform1 = new platform();
        addObject(platform1, getWidth()/1 - 200, getHeight() - 60);
        
        moving_platform platform2 = new moving_platform();
        addObject(platform2, getWidth()/1 - 600, getHeight() - 300);
        
        platform platform3 = new platform();
        addObject(platform3, getWidth()/1 - 300, getHeight() - 155);
        
        platform platform4 = new platform();
        addObject(platform4, getWidth()/1 - 370, getHeight() - 235);
        
        platform platform5 = new platform();
        addObject(platform5, getWidth()/1 - 400, getHeight() - 650);
        
        platform platform6 = new platform();
        addObject(platform6, getWidth()/1 - 100, getHeight() - 350);
        
        platform platform7 = new platform();
        addObject(platform7, getWidth()/1 - 340, getHeight() - 459);
        
        platform platform8 = new platform();
        addObject(platform8, getWidth()/1 - 400, getHeight() - 550);
        
        platform platform9 = new platform();
        addObject(platform9, getWidth()/1 - 735, getHeight() - 400);
        
        platform platform10 = new platform();
        addObject(platform10, getWidth()/1 - 900, getHeight() - 450);
        
        platform platform11 = new platform();
        addObject(platform11, getWidth()/1 - 200, getHeight() - 450);
        
        platform platform12 = new platform();
        addObject(platform12, getWidth()/1 - 600, getHeight() - 350);
        
        platform platform13 = new platform();
        addObject(platform13, getWidth()/1 - 650, getHeight() - 470);
        
        platform platform14 = new platform();
        addObject(platform14, getWidth()/1 - 485, getHeight() - 550);
        
        platform platform15 = new platform();
        addObject(platform15, getWidth()/1 - 570, getHeight() - 550);
        
    }
}
