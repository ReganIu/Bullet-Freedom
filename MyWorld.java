import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Main world where users can create their levels and play them
 * 
 * Jonah Reeves, Cody Chiu, Regan Iu
 * January 18/ 2018
 */
public class MyWorld extends World
{
    int monsterID = 1;
    String[][] waves = new String[9][9];
    int[][] xQuard = new int [9][9];
    int[][] yQuard = new int [9][9];
    int superCharge = 10; // holds value for the super ability, which is increased by hitting enemies
    int lives = 3;
    int i = 0;
    int j = 0;
    int bossLife = 100;
    MouseInfo mouse = Greenfoot.getMouseInfo();
    boolean gameStart = false;
    public SimpleTimer spaceTimer = new SimpleTimer(); //timer for moving the background
    String currentMonster;
    int currentX;
    int currentY;
    String current;

    private int imageCount = 0;
    private GreenfootImage bgImage = new GreenfootImage("gamebackground.png");
    private GreenfootSound backgroundMusic;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(GreenfootSound backgroundMusic) // resets the background music, makes sure ship doesnt get covered by other game elements
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 800, 1); 
        prepare();
        this.backgroundMusic = backgroundMusic;
        setPaintOrder(Player.class, Enemy05.class, BossLife.class, SuperBar.class, Tracer.class, BossLifeUI.class, inGameUI.class);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        UI ui = new UI();
        addObject(ui ,250,711);
        spaceTimer.mark();

        EnemySelector first = new EnemySelector(01, true);
        EnemySelector second = new EnemySelector(02, true);
        EnemySelector third = new EnemySelector(03, true);
        EnemySelector fourth = new EnemySelector(04, true);

        Tracer t1 = new Tracer("i");
        Tracer t2 = new Tracer("j");

        addObject(first, 133,740);
        addObject(second, 215,740);
        addObject(third, 297, 740);
        addObject(fourth, 377, 740);

        addObject(t1, 67, 689);
        addObject(t2, 418, 687);

    }
    
    /**
     * Before the game has started, the user can place enemies into the 2D array.
     */
    public void act()
    {
        if (gameStart == false)
        {
            if (Greenfoot.mouseClicked(this))
            {
                mouse = Greenfoot.getMouseInfo();
                if (mouse != null && j < 9)
                {
                    waves[i][j] = Integer.toString(monsterID); //on click, the enemy type and location will be stored for future refrence
                    xQuard[i][j] = mouse.getX();
                    yQuard[i][j] = mouse.getY();

                    j++;

                    EnemyPlaceholder placeholder = new EnemyPlaceholder (monsterID); // this will show an image of where the dropped enemy is
                    addObject(placeholder, mouse.getX(), mouse.getY());

                    current = waves[0][0];

                }
            }
            if (Greenfoot.isKeyDown("space") && i < 8 && spaceTimer.millisElapsed() > 300) //saves the current wave and increases to the next one
            {
                removeObjects(getObjects(EnemyPlaceholder.class));
                i++;
                j = 0;
                spaceTimer.mark();
            }
            if (Greenfoot.isKeyDown("enter")) // starts the game itself
            {
                gameStart = true;
                List objects = getObjects(null);
                removeObjects(objects);
                j = 0;
                i = 0;
                Player p = new Player();
                inGameUI igui = new inGameUI();
                Tracer t3 = new Tracer("ingamei");
                Tracer t4 = new Tracer("lives");
                SuperBar s = new SuperBar();

                addObject(igui, 250, 400);
                addObject(p, 250, 700);
                addObject(t3,268, 17);
                addObject(t4, 100, 17);
                addObject(s, 26, 398);
            }
        }
        else if (gameStart)
        {

            if ((getObjects(Enemy01.class)).size() == 0 && (getObjects(Enemy02.class)).size() == 0 && (getObjects(Enemy03.class)).size() == 0 && (getObjects(Enemy04.class)).size() == 0 && (getObjects(Enemy05.class)).size() == 0)
            {
                if(waves[i][0] != null) // if the next wave has atleast one enemy in it
                {
                    if(getObjects(SuperMove.class).size() > 0){
                        removeObjects(getObjects(SuperMove.class));
                    }
                    WaveComplete complete = new WaveComplete();
                    if(i>0){
                        addObject(complete, 250, 400);
                    }
                    Greenfoot.delay(15);
                    removeObject(complete);

                    spawnWave(i); // check for any enemies, spawn next wave if this one dead
                    i++;
                }
                else if(getBossLife() == 0){
                    Greenfoot.setWorld(new Victory(backgroundMusic));
                }
                else
                {
                                                           
                    for(int i = 0; i < 5; i++){
                        BossIncoming bi = new BossIncoming();
                        addObject(bi, 250, 400);
                        Greenfoot.delay(10);
                        removeObject(bi);
                        Greenfoot.delay(10);
                    }
                    
                    Enemy05 boss = new Enemy05(backgroundMusic);
                    //boss coming sound effect
                    addObject(boss, 250, 130);
                    BossLifeUI bLifeUI = new BossLifeUI();
                    addObject(bLifeUI, 472,398);
                    BossLife blife = new BossLife();
                    addObject (blife, 474, 398);
                }
            }    
            
        }
        if (lives == 0)
        {
            // defeat screen
            Greenfoot.setWorld(new GameOver(backgroundMusic));

        }
        imageCount += 5; //speed of moving background
        drawBackgroundImage();
    }
    
    /**
     * Spawns the next wave once all current enemies are dead
     */
    public void spawnWave(int wave) 
    {
        for (int b = 0; b < 9; b++)
        {
            if (waves[wave][b] != null)
            {
                currentMonster = waves[wave][b];
                currentX = xQuard[wave][b];
                currentY = yQuard[wave][b];

                if (currentMonster.equals("1"))
                {
                    Enemy01 e = new Enemy01();
                    addObject (e, currentX, currentY);
                }
                else if (currentMonster.equals("2"))
                {
                    Enemy02 e = new Enemy02();
                    addObject (e, currentX, currentY);
                }
                else if (currentMonster.equals("3"))
                {
                    Enemy03 e = new Enemy03();
                    addObject (e, currentX, currentY);
                }
                else if (currentMonster.equals("4"))
                {
                    Enemy04 e = new Enemy04();
                    addObject (e, currentX, currentY);
                }
                else if (currentMonster.equals("5"))
                {
                    Enemy05 e = new Enemy05(backgroundMusic);
                    addObject (e, currentX, currentY);
                }
            }
        }
    }

    /**
     * Player loses a life.
     */
    public void loseLives() 
    {
        lives--;
    }
    
    /**
     * Returns the lives of the player.
     */
    public int getLives()
    {
        return lives;
    }
    
    /**
     * Sets what monster is placed when you click
     */
    
    public void setMonsterID(int monid)// 
    {
        monsterID = monid;
    }
    
    /**
     * Returns a boolean value to check if game has started. 
     */
    public boolean getGameStart()
    {
        return gameStart;
    }
    
    /**
     * Increases the charge bar for the special ability for the player.
     */
    public void increaseSuperCharge()
    {
        if (superCharge < 20)
            superCharge++;
    }
    
    /**
     * Returns the values for the special ability.
     */
    public int getSuperCharge()
    {
        return superCharge;
    }
    
    /**
     * Resets the special ability after use.
     */
    public void resetSuperCharge()// once super is used, resets it back to 0
    {
        superCharge = 0;
    }
    
    /**
     * Returns the boss's health.
     */
    public int getBossLife()
    {
        return bossLife;
    }
    
    /**
     * Decreases the boss's health.
     */
    public void decreaseBossLife()
    {
        bossLife--;
    }
    
    /**
     * Gets wave number.
     */
    public int getI() 
    {
        return i;
    }
    
    /**
     * Gets the enemy count.
     */
    public int getJ() 
    {
        return j;
    }
    
    /**
     * Returns current monster.
     */
    public String traceID()
    {
        return currentMonster;
    }
    
    /**
     * Returns the current String value associated with 
     * the variable current.
     */
    public String traceCurrent()
    {
        return current;
    }

    /** 
     * Draws the background image.
     */
    public void drawBackgroundImage(){
        if(imageCount > bgImage.getHeight())          imageCount -= bgImage.getHeight();
        int temp = imageCount;
        getBackground().drawImage(bgImage, 0, temp);
        getBackground().drawImage(bgImage, 0, temp - bgImage.getHeight());
    }
}
