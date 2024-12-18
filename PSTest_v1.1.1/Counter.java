import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    //private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private static int value;
    //private int target;
    private String prefix;
    
    /*public Counter()
    {
        this(new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    

    public Counter(String prefix)
    {
        background = new GreenfootImage("Counter.png");  // get image from class
        background.scale(110,35);
        value = 20;
        //target = 5;
        this.prefix = prefix;
        updateImage();
        
    }
    
    
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    /* public void act() {
        
    } */
    
    public void add (int amount) {
        value += amount;
        updateImage();
    }
    
    public static int getValue() {
        return value;
    }
    
    public void updateImage() {
        
        // Create a new image with the background image size
        GreenfootImage image = new GreenfootImage(background.getWidth(), background.getHeight());
        
        // Draw the actual background image
        image.drawImage(background, 0, 0); 

        // Create the text to display
        GreenfootImage text = new GreenfootImage(prefix + value + "g", 24, Color.BLACK, new Color(0, 0, 0, 0));

        // Draw the text on top of the background image
        image.drawImage(text, (image.getWidth() - text.getWidth()) / 2, 4); // Position the text above the counter image

        setImage(image); // Set the actor's image to the new composite image
    }
}
