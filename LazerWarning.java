import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Actor is spawned by the boss, after a couple seconds, it will kill the player if they are ontop of this actor
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class LazerWarning extends Actor
{
    SimpleTimer explode = new SimpleTimer();
    private GreenfootSound backgroundMusic;
    /**
     * Constructor that takes in the backgroundMusic as parameters
     */
    public LazerWarning (GreenfootSound backgroundMusic)
    {
        this.backgroundMusic = backgroundMusic;
    }
        
    public void prepare()
    {
        explode.mark();
    }
    
    /**
     * Spawns the laser attack move performed by the boss
     */
    public void act() 
    {
        if (explode.millisElapsed() > 2000)
        {
            setImage("Explosion.png");
            if(isTouching(Player.class))
            {
                Greenfoot.setWorld(new GameOver(backgroundMusic)); //game over if Player actor touches the lazer
                removeTouching(Player.class);
            }
        }
        if (explode.millisElapsed() > 5000)
        {
            getWorld().removeObject(this);
        }
    }    
}
