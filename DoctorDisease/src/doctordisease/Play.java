/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.state.*;

/**
 *
 * @author saita
 */
public class Play extends BasicGameState implements InputProviderListener {
    
    public final int ID = 2;
    Player guts;
    private Command attack = new BasicCommand("attack");
    InputProvider provider;
    String message; 
   
    public Play(int state){    
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        guts = new Player();
        guts.init(gc, sbg);
        provider = new InputProvider(gc.getInput());
        provider.addListener(this);
        provider.bindCommand(new KeyControl(Input.KEY_SPACE), attack);
    }
   
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        guts.render(gc, sbg, g);    
    }
   
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        guts.update(gc, sbg, delta);           
    }
    
    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void controlPressed(Command cmnd) {
        message = "Pressed: "+ cmnd;
        System.out.println(message);
    }

    @Override
    public void controlReleased(Command cmnd) {

    }
    
}