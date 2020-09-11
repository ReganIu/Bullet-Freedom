import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The first enemy that the user can add to their game 
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Enemy01 extends Actor
{
    int rand;
    public SimpleTimer s = new SimpleTimer(); //timer
    /**
     * Constructor that marks the time so millisElapsed can be used.
     */
    public Enemy01()
    {
        s.mark();
    }

    public void act() 
    {
        move(2);
        movement(); //calls the movement function
        if (s.millisElapsed() > 1000) //fires periodically
        {
            fire();
            s.mark();
        }
    }
    
     /**
      * The fire function for the enemy
      */
    public void fire()
    {
        World world = (MyWorld)getWorld(); //reference to MyWorld
        for (int i = 0; i < 3; i++)
        {
            int bulletAim = 135 - (45 * i);
            EnemyBullet b = new EnemyBullet(bulletAim, 2);
            world.addObject(b, this.getX(), this.getY());
            b.move(50);
        }
    }
    
    /**
     * The movement function for the enemy,
     * causes it to "bounce" off at the edges
     * of the world.
     */
    public void movement ()
    {
        if (this.getX() <= 10)
        {
            rand = Greenfoot.getRandomNumber(90);
            if (Greenfoot.getRandomNumber(2) == 0)
                setRotation(rand);

            else
                setRotation(rand + 270);
        }
        else if (this.getX() >= 490)
        {
            rand = Greenfoot.getRandomNumber(90);
            if (Greenfoot.getRandomNumber(2) == 0)
                setRotation(rand + 90);

            else
                setRotation(rand + 180);
        }

        if (this.getY() < 10)
        {
            rand = Greenfoot.getRandomNumber(120) + 30;
            setRotation(rand);
        }
        else if (this.getY() > 550)
        {
            rand = Greenfoot.getRandomNumber(120) + 210;
            setRotation(rand);
        }
    }
}
