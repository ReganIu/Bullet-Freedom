import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * An actor that the Enemy05 creates in order to spawn a flurry of bullets
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class TornadoHelper extends Actor
{
    World world = (MyWorld)getWorld();
    SimpleTimer delay = new SimpleTimer();
    int deathCount = 0;
    Color transparent = new Color (0,0,0,0);
    /**
     * Act - do whatever the TornadoHelper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void prepare()
    {
        delay.mark();
       
    }    
    public void act() 
    {
        if (delay.millisElapsed() > 200)
        {
            delay.mark();
            deathCount++;
            for (int i = 0; i < 8; i++)
            {
                World world = (MyWorld)getWorld();
                int bulletAim = (i * 25);
                MetalBullet b = new MetalBullet(bulletAim, 3);
                world.addObject(b, this.getX(), this.getY());

            }
        }
        if (deathCount > 7)
        {
            getWorld().removeObject(this);
        }
    }    
}
