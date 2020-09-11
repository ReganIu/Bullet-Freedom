import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Displays the boss's health bar. 
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class BossLife extends Actor
{
    /**
     * Displays the boss's health bar that constantly updates.
     */
    public void act() 
    {
        MyWorld w = (MyWorld) getWorld();
        GreenfootImage image = new  GreenfootImage(10, ((w.getBossLife()) * 2) + 1);
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
    }    
}
