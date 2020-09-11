import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The second enemy that the user can add to their game
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Enemy02 extends Actor
{
    int rand;
    public SimpleTimer s = new SimpleTimer(); //timer

    /**
     * Constructor that randomizes the rotation of this actor
     */
    public Enemy02()
    {
        s.mark();
        if (Greenfoot.getRandomNumber(2) == 0)
            setRotation(45);
        else
            setRotation(135);
    }

    /**
     * This enemy fires 3 bullets as it travels
     * towards the bottom of the screen, exploding
     * once it reachs at certain point.
     */
    public void act() 
    {
        move(2);
        bounce(); //bounces off of the edges of the screen
        explode();      
        if (s.millisElapsed() > 1000) //fires peridiocally
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
            int bulletAim = 135 - (25 * i);
            EnemyBullet b = new EnemyBullet(bulletAim, 2);
            world.addObject(b, this.getX(), this.getY());
            b.move(50);
        }
    }
    
    /**
     * Bounces off the edges of the world
     */
    public void bounce()
    {
        if (this.getX() <= 10)
        {
            rand = Greenfoot.getRandomNumber(60);
            setRotation(rand);
        }
        else if (this.getX() >= 490)
        {
            rand = Greenfoot.getRandomNumber(60);
            setRotation(rand + 90);
        }
    }

    /**
     * If this actor exceeds too far down 
     * on the screen, it explodes into a 
     * circle of bullets.
     */
    public void explode()
    {
        if (this.getY() > 700)
        {
            World world = (MyWorld)getWorld();
            for(int i=0; i<20;i++)
            {
                EnemyBullet b = new EnemyBullet((360/20)*i, 3); 
                world.addObject(b, this.getX(), this.getY());
            }
            world.removeObject(this);
        }

    }

}
