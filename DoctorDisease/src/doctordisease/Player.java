package doctordisease;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.*;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Player {

    int x, y;
    float aclX = (float) 0.1;
    float aclY = (float) 0.1;
    Rectangle rec;
    boolean isOnCooldown;
    boolean isKeyDown = false;
    int cooldownTimer;
    static List<Tiro> tiros = new ArrayList <Tiro>();
    BasicCommand attack = new BasicCommand("attack");
    
    
    public Player() {
        x = 512;
        y = 500;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        rec = new Rectangle(x, y, 50, 50);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.draw(rec);
        for (Tiro t: tiros){
            t.render(gc, sbg, g);
        }  
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        for (Tiro t : tiros){
            t.update();
        }      
        
        if (x >= 0 && x <= 1000) x += Math.round(aclX);
        else {if (x < 0) {
                x += (x * -1);
                aclX = (float) 0.1;
            }
            if (x > 1000) {
                x -= (x - 1000) + 1;
                aclX = (float) 0.1;
            }
        }
        if (y >= 0 && y <= 700)  y += Math.round(aclY);
        else {if (y < 0) {
                y += (y * -1);
                aclY = (float) 0.1;
            }
            if (y > 700) {
                y -= (y - 700) + 1;
                aclY = (float) 0.1;
            }
        }       
        rec.setX(x);
        rec.setY(y);
        
        if (isOnCooldown) {
            cooldownTimer += delta;
            if (cooldownTimer > 200) {
                isOnCooldown = false;
            }
        }      
    }
    
    public void attack() throws SlickException{
        if (isOnCooldown == true){
            tiros.add(new Tiro(x,y));
            isOnCooldown = true;
            cooldownTimer = 0;
        }
    }             
}