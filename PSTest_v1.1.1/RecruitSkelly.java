import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class RecruitSkelly extends Crewmen
{
    RangedUpgrade rangeUpgrade =  new  RangedUpgrade();
    ArmouredUpgrade armorUpgrade =  new  ArmouredUpgrade();
    GreenfootImage img = new GreenfootImage("RecruitSkelly_idle1.png");
    GreenfootImage img2 = new GreenfootImage("RecruitSkelly_idle1Highlighted.png");
    private int healthPoints = 100;
    private long lastActionTime = 0; 
    private GifImage gif = new GifImage("SmokeScreen.gif");
    /**
     * 
     */
    public RecruitSkelly()
    {
        img.scale(125, 125);
        img2.scale(125,125);
        
    }
    
    
    
    /**
     * Act - do whatever the RecruitSkelly wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(img);
        Background world = (Background) getWorld();
        Counter counter = world.getCounter();
        if (Greenfoot.mouseMoved(getWorld())) {
            setImage(img);
        }
        if (Greenfoot.mouseMoved(this)) {
            setImage(img2);
        }
        if (counter.getValue() >= Upgrades.upgradeValue) {
           if (Greenfoot.mouseClicked(this)) {
            getWorld().addObject(rangeUpgrade, getX(), getY() + 25);
            getWorld().addObject(armorUpgrade, getX(), getY() -25);
            } 
        } 
        else if (counter.getValue() < Upgrades.upgradeValue) {
            if (Greenfoot.mouseClicked(this)) {
                NotEnoughGold text = new NotEnoughGold("Not enough gold!", 60);
                getWorld().addObject(text, getX(), getY() - 50);
            }
        }
        isFighting();
        isDead();
    }
    protected void isFighting(){
        if(isTouching(Enemies.class)){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastActionTime >= 1200){
                healthPoints -= enemyDamage;
                lastActionTime = currentTime;
            }
        }
    }
    protected void isDead(){
        if(healthPoints <= 0){
         getWorld().removeObject(this);
        }
    }
}
