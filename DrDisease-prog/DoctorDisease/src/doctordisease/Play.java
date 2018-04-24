/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author saita
 */
public class Play extends BasicGameState {
    
    public final int ID = 2;
    
    Player guts;
    Iterator it;
    Tiro t;
    static List<Tiro> tiros = new ArrayList <Tiro>();
    
    public Play(int state){    
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        guts = new Player();
        guts.init(gc, sbg);
        it = tiros.iterator();
    }
   
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("O jogo começou", 500, 500);
        guts.render(gc, sbg, g);
        for (Iterator<Tiro> iter = tiros.iterator();
            iter.hasNext();){
            Tiro t = iter.next();
            t.render(gc, sbg, g);
        }        
    }
   
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        guts.update(gc, sbg, delta);
        for (Iterator<Tiro> iter = tiros.iterator();
            iter.hasNext();){
            Tiro t = iter.next();
            t.update(gc, sbg, delta);
            if (t.y < -10) {
                iter.remove();
            }
        }             
    }
    
    @Override
    public int getID() {
        return 2;
    }
    
}