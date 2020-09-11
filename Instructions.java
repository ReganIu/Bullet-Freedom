import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions page; inform user on the basics of how to play, in case they have not read
 * the README file, which contains a detailed explanation of the game.
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Instructions extends World
{
    private GreenfootSound backgroundMusic;
    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions(GreenfootSound backgroundMusic)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 800, 1); 
        this.backgroundMusic = backgroundMusic;
    }
    
    /**
     * Game beings if enter is pressed.
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.delay(5);
            Greenfoot.setWorld(new MyWorld(backgroundMusic));
        }
    }
}
