import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Once user has lost, they are taken here so that they may restart the game
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class GameOver extends World
{
    HomeButton home = new HomeButton();
    private GreenfootSound backgroundMusic;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(GreenfootSound backgroundMusic)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 800, 1); 
        this.backgroundMusic = backgroundMusic;
        prepare();
    }
    
    public void prepare(){
        addObject(home, 250, 600);
    }
    
    /**
     * Brings the user back to title screen if
     * the home button is pressed.
     */
    public void act(){
        if(Greenfoot.mouseClicked(home)){
            Greenfoot.setWorld(new Title());
           backgroundMusic.stop();
        }
    }
}
