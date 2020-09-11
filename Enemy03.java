import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The third enemy that the user can add to their game
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Enemy03 extends Actor
{
    public SimpleTimer s = new SimpleTimer(); //timer

    /**
     * Fires in a motion that is similar
     * to a sprinkler.
     */
    public void act() 
    {        
        turn(2);     
        if(getRotation() == 180) turn(-180); //goes back to starting rotation after done shooting
        
        if (s.millisElapsed() > 400) //fires periodically
        {
            fire();
            s.mark();
        }
    }    

    /**
     * The firing function for the enemy.
     */
    public void fire()
    {
        World world = (MyWorld)getWorld();
        for (int i = 0; i < 5; i++)
        {
            int bulletAim = 45 - (22*i);
            EnemyBullet b = new EnemyBullet(getRotation()+bulletAim, 4);
            world.addObject(b, this.getX(), this.getY());
            b.move(50);
        }
    }
}
