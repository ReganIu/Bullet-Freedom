import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * This actor constantly updates to 
 * show the charging of the special ability.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class SuperBar extends Actor
{
    
    /**
     * Shows the charging process for the special ability
     * used by the Player class. Flashes green when the 
     * special ability is ready to be used, and cyan otherwise.
     */
    public void act() 
    {
        MyWorld w = (MyWorld) getWorld();
        GreenfootImage image = new  GreenfootImage(10, ((w.getSuperCharge()) * 10) + 1);
        if (w.getSuperCharge() > 19)
        image.setColor(Color.GREEN);
        else
        image.setColor(Color.CYAN);
        image.fill();
        setImage(image);
    }    
}
