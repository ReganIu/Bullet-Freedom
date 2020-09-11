import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Victory screen that appears once the boss has been defeated, allows user to play again
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Victory extends World
{
    HomeButton home = new HomeButton();
    private GreenfootSound backgroundMusic;
    /**
     * Constructor for objects of class Victory.
     * 
     */
    public Victory(GreenfootSound backgroundMusic) // plays background music
    {    
        super(500, 800, 1); 
        this.backgroundMusic = backgroundMusic;
        prepare();
    }
    
    public void prepare(){
        addObject(home, 250, 600);
    }
    
    /**
     * Creates new title screen if user 
     * clicks on the home button.
     */
    public void act(){
        if(Greenfoot.mouseClicked(home)){
            Greenfoot.setWorld(new Title());
            backgroundMusic.stop();
        }
    }
}
