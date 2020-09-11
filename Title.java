import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Introductory screen to the game
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class Title extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("backgroundmusic.mp3");
    Instructions instruction = new Instructions(backgroundMusic);
    PlayButton playButton = new PlayButton();
    
    
    private int imageCount = 0;
    private GreenfootImage bgImage = new GreenfootImage("maxresdefault.jpg");
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {          
        super(500, 800, 1); 
        prepare();
    }    
    
    public void prepare(){           
        addObject(playButton, 250, 550);
        Logo logo = new Logo();
        addObject(logo, 250, 200);
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(50);
    }
    
    /**
     * Game begins when play button is pressed.
     */
    public void act(){
        if (Greenfoot.mouseClicked(playButton)){
            Greenfoot.setWorld(instruction);
        }
        imageCount += 3; //speed of moving background
        drawBackgroundImage();
        
    }
    
    /**
     * Draws the moving background image.
     */
    public void drawBackgroundImage(){ // plays background image animation
       if(imageCount > bgImage.getHeight()) imageCount -= bgImage.getHeight();
       int temp = imageCount;
       getBackground().drawImage(bgImage, 0, temp);
       getBackground().drawImage(bgImage, 0, temp - bgImage.getHeight());
    }
}
