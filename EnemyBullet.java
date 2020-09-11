 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * basic bullet most enemies fire at the player
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class EnemyBullet extends Actor
{
    public int speed;
    
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EnemyBullet(int theAngle, int theSpeed)
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
