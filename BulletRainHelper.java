import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor is a helper actor for one of
 * the three attacks for the boss.`
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class BulletRainHelper extends Actor
{   
    int deathCount = 0;
    SimpleTimer delay = new SimpleTimer();

    public void prepare()
    {
        // choose a number, make a hole of 2 units, 1 forward and 1 backward     
        delay.mark();
    }
    
    /**
     * Creates the pathway out of bullets
     * that the user has to navigate through
     */
    public void act() 
    {
        if (delay.millisElapsed() > 2000)
        {
            delay.mark();
            deathCount++;
            int hole = Greenfoot.getRandomNumber(20);
            
            for (int i = 0; i < 20; i++)
            {
                
                if (i != hole && i != (hole - 1) && i != (hole+1))
                {
                    World world = (MyWorld)getWorld();
                    BossBullet b = new BossBullet(90,2);
                    world.addObject(b, 13 + (i * 25), 105);
                }
            }
        }
        if (deathCount > 7)
        {
            getWorld().removeObject(this);
        }
    }    
}
