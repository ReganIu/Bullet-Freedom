import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets the image that corresponds to each enemy, including the boss.
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class EnemySelector extends Actor
{
    boolean active;
    int ID;
    /**
     * Act - do whatever the EnemySelector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EnemySelector(int mID, boolean a)
    {
        ID = mID;
        active = a;
        if (ID == 01)
            setImage("enemy01.png");
        else if (ID == 02)
            setImage("enemy02.png");
        else if (ID == 03)
            setImage("enemy03.png");
        else if (ID == 04)
            setImage("enemy04.png");
        else if (ID == 05)
            setImage("boss.png");
    }

    public void act() 
    {

        if (Greenfoot.mouseClicked(this))// if a key is pressed, set variable which records monsterID to that monster
        {
            ((MyWorld) getWorld()).setMonsterID(ID);
        }

    }    
}
