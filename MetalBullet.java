import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bullet that the boss fires during the "tornado" 
 * attack moves.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class MetalBullet extends Actor
{
    public int speed;
    public int angle;
    SimpleTimer drop = new SimpleTimer();
    
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MetalBullet(int theAngle, int theSpeed)
    {
        drop.mark();
        setRotation(theAngle);
        speed = theSpeed;
    }
    
    /**
     * Moves the bullet at the speed given by user and
     * removes bullet if it is at the edge of screen.
     */
    public void act() 
    {
        move(speed);
        if (this.getX() > 490 || this.getX() < 10 || this.getY() < 10 || this.getY() > 790)
        {
            getWorld().removeObject(this);
        }
        if (drop.millisElapsed() > 1000)
        {
            setRotation(90);
        }
        
    }
}
