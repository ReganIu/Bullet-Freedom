import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clicking this actor during the building period will change what monster is placed by left clicking
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class EnemyPlaceholder extends Actor
{
    int ID;
    /**
     * Determines which enemy is picked during the building process
     * of the game.
     */
    public EnemyPlaceholder(int mID)
    {
        ID = mID;
        
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
}
