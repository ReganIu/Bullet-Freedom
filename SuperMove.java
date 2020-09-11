import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The super ability actor, can be spawned when the supercharge variable is 20 in the world class, this can wipe bullets off the screen and kill enemies
 * Due to technical limitations and how many actors can be recognized in one period of act, it will not destroy all bullets when there is an excess of bullets.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class SuperMove extends Actor
{
    /**
     * Act - do whatever the SuperMove wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void prepare()
    {

    }

    public void act() 
    {
        MyWorld w = (MyWorld) getWorld();
        setRotation(270);
        move(20);
        
        if (this.isTouching(Enemy01.class))
        {
            removeTouching(Enemy01.class);
        }
        if (this.isTouching(Enemy02.class))
        {
            removeTouching(Enemy02.class);
        }
        if (this.isTouching(Enemy03.class))
        {
            removeTouching(Enemy03.class);
        }
        if (this.isTouching(Enemy04.class))
        {
            removeTouching(Enemy04.class);
        }
        if (this.isTouching(LargerBullet.class))
        {
            removeTouching(LargerBullet.class);
        }
        if (this.isTouching(EnemyBullet.class))
        {
            removeTouching(EnemyBullet.class);
        }
        if (this.isTouching(MetalBullet.class))
        {
            removeTouching(MetalBullet.class);
        }
        if (this.isTouching(LazerWarning.class))
        {
            removeTouching(LazerWarning.class);
        }
        if (this.isTouching(BossBullet.class))
        {
            removeTouching(BossBullet.class);
        }
        if (this.getY() < 10)
        {
            getWorld().removeObject(this);
        }
    }    
}
