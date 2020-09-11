import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animates the explosion of the enemies.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class monsterExplosion extends Actor
{
    private GreenfootImage img1 = new GreenfootImage ("monsterexplosion.gif"); //1st animation
    private GreenfootImage img2 = new GreenfootImage ("monsterexplosion2.gif"); //2nd animation
    GreenfootSound explosionSound = new GreenfootSound("explosionsound.mp3");
    private int timer = 1;
    /**
     * Act - do whatever the MonsterExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateExplosion();
    }   

    /**
     * This is the animation for the explosion.
     */
    public void animateExplosion()
    {
        explosionSound.play();
        explosionSound.setVolume(40);
        if (timer == 1) 
        {
            setImage(img1);
        } 
        else if (timer == 2)
        {
            setImage(img2);
        }
        else if (timer == 3)
        {
            getWorld().removeObject(this);
        }
        timer++;
    } 
}
