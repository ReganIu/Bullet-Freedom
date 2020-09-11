import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor is the bullet that the user fires to kill enemies.
 * Also shows the explosion animation after it hits an enemy.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class PlayerBullet extends Actor
{
    monsterExplosion explosion = new monsterExplosion();
    /**
     * Act - do whatever the PlayerBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlayerBullet()
    {
        setRotation(270);
    }
    
     /**
      * Fires the bullet that causes enemy to 
      * explode if hit.
      */
    public void act() 
    {
        MyWorld w = (MyWorld) getWorld();
        move(20);
        Actor Enemy01 = getOneIntersectingObject(Enemy01.class);//returns an object that intersects the bullet 
        Actor Enemy02 = getOneIntersectingObject(Enemy02.class);
        Actor Enemy03 = getOneIntersectingObject(Enemy03.class);
        Actor Enemy04 = getOneIntersectingObject(Enemy04.class);

        if (this.getX() > 490 || this.getX() < 10 || this.getY() < 10 || this.getY() > 790)
        {
            getWorld().removeObject(this); //removes bullet if off the screen
        }
        else if (this.isTouching(Enemy01.class))
        {
            w.increaseSuperCharge(); //increases charge bar for super ability
            getWorld().addObject(explosion, Enemy01.getX(), Enemy01.getY());  //explosion animation 
            getWorld().removeObject(Enemy01); //removes enemy
            getWorld().removeObject(this); //removes player bullet
        }
        else if (this.isTouching(Enemy02.class))
        {
            w.increaseSuperCharge();
            getWorld().addObject(explosion, Enemy02.getX(), Enemy02.getY());
            getWorld().removeObject(Enemy02);
            getWorld().removeObject(this);
        }
        else if (this.isTouching(Enemy03.class))
        {
            w.increaseSuperCharge();
            getWorld().addObject(explosion, Enemy03.getX(), Enemy03.getY());
            getWorld().removeObject(Enemy03);
            getWorld().removeObject(this);
        }
        else if (this.isTouching(Enemy04.class))
        {
            w.increaseSuperCharge();
            getWorld().addObject(explosion, Enemy04.getX(), Enemy04.getY()); 
            getWorld().removeObject(Enemy04);
            getWorld().removeObject(this);
        }
    }

}
