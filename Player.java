import greenfoot.*; 

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed = 7;
    private int vSpeed = 0;
    private int acceleration = 1;
    private int jumpStrength = 14;
    private GreenfootImage image1;
    private GreenfootImage image2;
    
    /**
     * the images the player can switch from.
     */
    public Player()
    {
        image1 = new GreenfootImage("player.png");
        image2 = new GreenfootImage("winC.png");
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkKeys();
        fall();
        onGround();
        checkFall();
        playerInteraction();
        playerReset();
    }
    
    /**
     * checks the keys to see if they are being pressed to allow player movement
     */
    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            moveRight();
        }
        
        if (Greenfoot.isKeyDown("left"))
        {
            moveLeft();
        } 
        
        if (Greenfoot.isKeyDown("space") && onGround() )         
        {
            jump();
        }
        
        if (Greenfoot.isKeyDown("space") && onPlatform())
        {
            jump();
        }
        
        if (Greenfoot.isKeyDown("space") && onMovingPlatform())
        {
            jump();
        }
        
    }
    
    /**
     * basic player movement right
     */
    public void moveRight()
    {
        setLocation (getX() + speed, getY());
    }
    
    /**
     * basic player movement left
     */
    public void moveLeft()
    {
        setLocation (getX() - speed, getY());
    }
    
    /**
     * fall method. detects different types of platforms to see if the player needs to fall.
     */
    public void fall()
    {
        detectPlatform();
        detectPlatformMoving();
        setLocation (getX(), getY() + vSpeed);
        vSpeed += acceleration;
    }
    
    /**
     * jump and fall 
     */
    public void jump()
    {
       vSpeed = -jumpStrength;
       fall();
    }
    
    /**
     * detects if the player is on the groundplatform
     */
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, groundPlatform.class);
        return under != null;
    }
    
    /**
     * will prevent the player from falling through the platform
     */
    public boolean onPlatform()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, platform.class);
        return under != null;
    }
    
    /**
     * will prevent the player from falling through the moving platform
     */
    public boolean onMovingPlatform()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, moving_platform.class);
        return under != null;
    }
    
    /**
     * detects the moving platform
     */
    public void detectPlatformMoving()
    {
        for (int i = 0; i < vSpeed; i++)
        {
            Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2 + i, moving_platform.class);
            if (under != null)
            {
                vSpeed = i;
            }
        }
        
    }
    
    /**
     * detects the platforms 
     */
    public void detectPlatform()
    {
        for (int i = 0; i < vSpeed; i++)
        {
            Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2 + i, platform.class);
            if (under != null)
            {
                vSpeed = i;
            }
        }
        
    }
    
    /**
     * checks the fall to see if the player is on the ground
     */
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    
    /**
     * if the player touches the heart it will remove it and play the win sound and set the image to the human form.
     */
    public void playerInteraction()
    {
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            winSound();
            win();
            Greenfoot.stop();
        }
    }
    
    /**
     * sets the sound for go along with the playerInteraction of when the player wins
     */
    public void winSound()
    {
        GreenfootSound sound = new GreenfootSound("win.wav");
        sound.setVolume(70);
        sound.play();
    }
    
    /**
     * sets the image too the human form if the player gets the heart
     */
    public void win()
    {
       setImage(image2); 
    }
    
    /**
     * respawns the player at the desinated location
     */
    public void playerReset()
    {
        if(isTouching(enemy_ghost.class))
        {
            setLocation(100,655);
        }
    }
}
