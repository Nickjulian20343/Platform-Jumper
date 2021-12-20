import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class moving_platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class moving_platform extends Actor
{
    private int direction = 3;  
    
    /**
     * code took from user sinlessclown
     * act method
     */
    public void act() 
    { 
        move(); 
        movePlayer();
    }
    
    /**
     * code took from  user sinlessclown
     * detects the direction of the platform and makes it move back and forth
     */
    private void move() 
    {  
        if (direction < 0 && getX() <= getImage().getWidth() / 2
        || direction > 0 && getX() >= getWorld().getWidth() - getImage().getWidth() / 2) 
        {
        direction = -direction;
        }
        setLocation(getX()+direction, getY());
    }
    
    /**
     * code took from user sinlessclown
     * will make the player move back and forth on the platform if they are on it.
     */
    private void movePlayer()
    {
      setLocation(getX(), getY()-1);
      Actor player = getOneIntersectingObject(Player.class);
      if (player != null) player.setLocation(player.getX()+direction, player.getY());
      setLocation(getX(), getY()+1);
    }
}