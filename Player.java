import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This the main character class, where the user has the ability
 * to control the movement the actor,to fire bullets, and kill enemies.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Player extends Actor
{
    SimpleTimer attackTimer = new SimpleTimer(); //timer for firing rate
    SimpleTimer invulnTimer = new SimpleTimer(); //timer for invulnerability
    GreenfootSound jonahSound = new GreenfootSound("jonahgun.wav"); //firing sound
    GreenfootSound reganSound = new GreenfootSound("regangun.wav"); //firing sound
    int randomSound; //variable that determines which sound is going to be played

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player()
    {
        attackTimer.mark(); //marks the current time so that we can use the function millisElaspsed afterwards
    }
    
    /**
     * Allows user to move character, fire and use special ability. 
     * Also checks if this actor gets hit by enemy bullets.
     */
    public void act() 
    {
        moveCharacter(); //calls the move function for this actor
        randomSound = Greenfoot.getRandomNumber(2); 
        touchingBullet(); //checks if user gets hit by bullets or not
        fire(); //calls the fire method
        specialAbility(); // calls the special ability method
    }   

    /**
     * This method is to check if our actor is 
     * touching any of the enemies bullets, 
     * causing the user to lose a life and gain
     * invulnerability for a short period of time.
     */
    public void touchingBullet() 
    {
        MyWorld w = (MyWorld) getWorld(); //reference to the world
        if (invulnTimer.millisElapsed() > 3000) 
        //the if statement above is to show the period
        //of invulnerability after getting hit/touching an enemy.
        {
            setImage("NewPlayer.png");
            //checks if player is touching enemy's bullets 
            if (isTouching(EnemyBullet.class))
            {
                w.loseLives(); //calls the "loseLives()" function in the MyWorld class
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
                removeTouching(EnemyBullet.class);
            }
            else if (isTouching(MetalBullet.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
                removeTouching(LargerBullet.class);
            }
            else if (isTouching(LargerBullet.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
                removeTouching(MetalBullet.class);
            }
            else if (isTouching(BossBullet.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
                removeTouching(MetalBullet.class);
            }
            //checks if player is touching enemy.
            if (isTouching(Enemy01.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
            }
            else if (isTouching(Enemy02.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
            }
            else if (isTouching(Enemy03.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
            }
            else if (isTouching(Enemy04.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
            }
            else if (isTouching(Enemy05.class))
            {
                w.loseLives();
                invulnTimer.mark();
                setImage("DamagedPlayer.png");
            }
        }   
    }

    /**
     * Moves the Actor by pressing WASD keys.
     */
    public void moveCharacter()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 4);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 4, getY());

        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+4);

        }
        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 4, getY());
        }
    }

    /**
     * This is the firing mechanism for the actor
     */
    public void fire()
    {
        if (Greenfoot.isKeyDown("space") && attackTimer.millisElapsed() > 500)
        {

            if (randomSound == 0) 
            {
                jonahSound.play();
                jonahSound.setVolume(80);
            }
            else if (randomSound == 1)
            {
                reganSound.play();
                reganSound.setVolume(80);
            }

            PlayerBullet b = new PlayerBullet();
            getWorld().addObject(b, this.getX(), this.getY()-30);
            attackTimer.mark(); 
        }
    }

    /**
     * Code below is for the special ability of the actor
     */
    public void specialAbility()
    {
        MyWorld w = (MyWorld) getWorld(); //reference to the world
        if (Greenfoot.isKeyDown("control"))
        {
            if (w.getSuperCharge() == 20)
            {
                SuperMove s = new SuperMove();
                getWorld().addObject(s, this.getX(), this.getY()); //adds the super ability move
                w.resetSuperCharge(); //resets the charge bar for the super ability
            }
        }
    }
}
