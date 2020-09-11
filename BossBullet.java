import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bullet the boss fires during the bullet rain ability, it works the same as other bullets with a difffernt hitbox
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class BossBullet extends Actor
{
    public int speed;
    
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BossBullet(int theAngle, int theSpeed)
    {
        setRotation(theAngle);
        speed = theSpeed;
    }
    public void act() 
    {
        move(speed);
        if (this.getX() > 490 || this.getX() < 10 || this.getY() < 10 || this.getY() > 795)
        {
            getWorld().removeObject(this);
        }
    } 
}
