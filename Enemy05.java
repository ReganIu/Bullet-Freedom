import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This actor is the final boss that the user must face against
 * at the end of all of the waves.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Enemy05 extends Actor
{
    SimpleTimer attackTimer = new SimpleTimer();
    int randAttack;
    int resetTime = 3000;
    int alt;
    private GreenfootSound backgroundMusic;
    
    /**
     * Constructor that takes in the backgroundMusic as parameters
     */
    public Enemy05 (GreenfootSound backgroundMusic)
    {
        this.backgroundMusic = backgroundMusic;
    }

    public void prepare()
    {
        attackTimer.mark();//marks the time so we can use millisElapsed
    }

    /**
     * Determines which attack the boss will perform
     * using the getRandomNumber function. Also checks
     * if this actor gets hit by one of the players attacks
     */
    public void act() 
    {
        MyWorld w = (MyWorld) getWorld();      
        randomMove();            
        hitByBullet();
        hitBySpecial();
        die();        
    }    

    /**
     * Randomizes the next attack for boss.
     */
    public void randomMove()
    {
        if (attackTimer.millisElapsed() > resetTime)
        {   
            randAttack = Greenfoot.getRandomNumber(3);
            if (randAttack == 0)
            {
                tornado();
            }
            else if (randAttack == 1)
            {
                lazer();
            }
            else if (randAttack == 2)
            {
                bulletRain();
            }
        }
    }

    /**
     * Checks if hit by player bullet, then increases
     * super ability charge bar for player
     */
    public void hitByBullet()
    {
        MyWorld w = (MyWorld) getWorld();
        if (isTouching(PlayerBullet.class)) 
        {
            w.decreaseBossLife();
            w.increaseSuperCharge();
            removeTouching(PlayerBullet.class);
        }
    }

    /**
     * checks if it is hit by the user's special ability
     */
    public void hitBySpecial()
    {
        MyWorld w = (MyWorld) getWorld();
        if (isTouching(SuperMove.class)) 
        {
            w.decreaseBossLife();
        }
    }

    /**
     * Checks the lives of the boss,
     * and removes boss if it loses all
     * of its health.
     */
    public void die()
    {
        MyWorld w = (MyWorld) getWorld();
        if (w.getBossLife() < 1) //removes boss if it loses all its health
        {
            getWorld().removeObject(this);             
        }
    }

    /**
     * One of the three attacks for the boss
     * This attack creates a pathway the user must navigate
     * through in order to survive.
     */
    public void bulletRain()
    {
        World world = (MyWorld)getWorld();
        attackTimer.mark();
        resetTime = 28000;
        BulletRainHelper b = new BulletRainHelper();
        world.addObject (b, 250, 100);
    }

    /**
     * One of the three attacks for the boss.
     * This lazer covers up half of the screen and 
     * kills the user if s/he remains in this actor
     * when it turns red.
     */
    public void lazer()
    {
        World world = (MyWorld)getWorld();
        attackTimer.mark();
        resetTime = 8000;
        LazerWarning lazer = new LazerWarning(backgroundMusic);
        if (Greenfoot.getRandomNumber(2) > 0)
        {
            world.addObject(lazer, 125, 400);
        }
        else
        {
            world.addObject(lazer, 375, 400);
        }

    }

    /**
     * One of the three attacks for the boss.
     * Creates a flurry of bullets that the 
     * user must dodge to survive
     */
    public void tornado()
    {   
        World world = (MyWorld)getWorld();
        attackTimer.mark();
        resetTime = 5000;
        int rand = Greenfoot.getRandomNumber(3);

        if (rand == 0)
        {
            TornadoHelper t = new TornadoHelper();
            world.addObject (t, 250, 100);
        }
        else if (rand == 1)
        {
            TornadoHelper t = new TornadoHelper();
            TornadoHelper t2 = new TornadoHelper();
            world.addObject (t, 167, 100);
            world.addObject (t2, 333, 100);
        }
        else if (rand == 2)
        {
            TornadoHelper t = new TornadoHelper();
            TornadoHelper t2 = new TornadoHelper();
            TornadoHelper t3 = new TornadoHelper();
            world.addObject (t, 125, 100);
            world.addObject (t2, 250, 100);
            world.addObject (t3, 375, 100);
        }
    }

}
