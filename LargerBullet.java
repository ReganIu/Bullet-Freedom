import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet spawned by specific enemies that is harder to dodge, angle and speed paramaters determine where the bullet will travel and how fast it travels
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class LargerBullet extends Actor
{
    public int speed;
    
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public LargerBullet(int theAngle, int theSpeed)
    {
        setRotation(theAngle);
        speed = theSpeed;
    }
    public void act() 
    {
        move(speed);
        if (this.getX() > 490 || this.getX() < 10 || this.getY() < 10 || this.getY() > 790)
        {
            getWorld().removeObject(this);
        }
    } 
}
