import greenfoot.*; 
//import greenfoot.GreenfootSound;

/**
 * Write a description of class enemy_ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy_ghost extends Actor
{
    private int dX = -3;
    
    /**
     * Act - do whatever the enemy_ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(dX);
        findPlayer();
        edgeOfWorld();
    }
    
    /**
     * detects contact with the player and removes thems and end the enitre game
     */
    public void findPlayer()
    {
        if(isTouching(Player.class))
        {
            loseSound();
        }
    }
    
    /**
     * moves back and forth in the world when it hits the edge
     */
    public void edgeOfWorld()
    {
        if(getX() <= 0 || getX() >= getWorld().getWidth()-1)
        {
            dX = -dX;
        }
    }
    
    /**
     * if player loses this sound will play
     */
    public void loseSound()
    {
        GreenfootSound sound = new GreenfootSound("lose.wav");
        sound.setVolume(70);
        sound.play();
    }
    
}
