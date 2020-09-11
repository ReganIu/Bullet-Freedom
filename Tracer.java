import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * During the level creation part,this actor keeps 
 * track of the wave number the user is on,
 * as well as the number of enemies 
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Tracer extends Actor
{
    String num = "";
    String selector;
    Color transparent = new Color (0,0,0,0); //transparent color
    
    public Tracer(String select)
    {
        selector = select;
    }
    
    /**
     * Checks wave number, enemy count while creating levels,
     * as well as the wave number and live count while in game.
     */
    public void act() 
    {
        if (selector.equals("i")) //checks wave number during level creation process
        {
            num = Integer.toString(((MyWorld) getWorld()).getI() + 1);
            setImage (new GreenfootImage("Waves: " + num, 30, Color.CYAN, transparent));
        }
        else if (selector.equals("j")) //checks number of enemies on screen during level creation process
        {
          num = Integer.toString(((MyWorld) getWorld()).getJ());
          setImage (new GreenfootImage("Enemies: " + num, 30, Color.CYAN, transparent));
        }
        else if (selector.equals("ingamei")) //checks wave number while in game
        {
            num = Integer.toString(((MyWorld) getWorld()).getI());
            setImage (new GreenfootImage(num, 30, Color.CYAN, transparent));
        }
        else if (selector.equals("lives")) //checks number of lives while in game
        {
            num = Integer.toString(((MyWorld) getWorld()).getLives());
            setImage (new GreenfootImage(num, 30, Color.CYAN, transparent));
        }
        
    }    
}
