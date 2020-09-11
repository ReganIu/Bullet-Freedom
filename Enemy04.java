import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The fourth enemy that the user can add to their game 
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Enemy04 extends Actor
{
    public SimpleTimer s = new SimpleTimer();

    /**
     * The enemy fires in a straight
     * line at a periodic interval
     */
    public void act() 
    {
        if (s.millisElapsed() > 2000) //fires periodically
        {
            fire();
            s.mark();
        }
    }  
    
    /**
     * The fire function for the enemy. 
     */
    public void fire()
    {
        World world = (MyWorld)getWorld();
        LargerBullet b = new LargerBullet(90, 4);
        world.addObject(b, this.getX(), this.getY());
        b.move(50);
    }
}
