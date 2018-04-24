/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Player extends BasicGameState {

    int x, y;
    float aclX = (float) 0.1;
    float aclY = (float) 0.1;
    Rectangle rec;
    boolean isOnCooldown;
    boolean isKeyDown = false;
    int cooldownTimer;
    
    public Player() {
        x = 512;
        y = 500;
    }
    
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        rec = new Rectangle(x, y, 50, 50);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.draw(rec);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        isKeyDown = false;
        if (gc.getInput().isKeyDown(Input.KEY_RIGHT)){
            if (aclX < 10) aclX += 1 * 0.5;
            isKeyDown = true;
        }
        if (gc.getInput().isKeyDown(Input.KEY_LEFT)){
            if (aclX > -10) aclX -= 1 * .5;
            isKeyDown = true;
        }
        if (gc.getInput().isKeyDown(Input.KEY_DOWN)){
            if (aclY < 10) aclY += 1 * .5;
            isKeyDown = true;
        }
        if (gc.getInput().isKeyDown(Input.KEY_UP)){
            if (aclY > -10) aclY -= 1 * .5;
            isKeyDown = true;
        }
        if (isKeyDown == false){
            if (aclX > 0) aclX -= 1 * .5;
            else aclX += 1 * .5;
            if (aclY > 0) aclY -= 1 * .5;
            else aclY += 1 * .5;
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
            if (cooldownTimer > 200) { // 500 is the amount of milliseconds to wait
                isOnCooldown = false;
            }
        } else { if (gc.getInput().isKeyDown(Input.KEY_ENTER)){
            Tiro t = new Tiro(x, y);
            t.init(gc, sbg);
            Play.tiros.add(t);
            isOnCooldown = true;
            cooldownTimer = 0;
            }
        }
        
    }           
}