import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class TutorialButton extends Actor
{

    /**
     * Act - do whatever the TutorialButton wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            World background2 = new Background2();
            Greenfoot.setWorld(background2);
        }
    }
}
