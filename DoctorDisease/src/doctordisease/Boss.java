/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Gabriel
 */
public class Boss {
    
    final int idle = 0;
    final int randomBullets = 1;
    final int comboBullets = 2;
    int x, y, hp, time, rand, attack;
    static List<HitBoxBoss> blasters = new ArrayList <HitBoxBoss>();
    static List<TiroBoss> bullets = new ArrayList <TiroBoss>();
    SpriteSheet blasterSheet;
    Image boss, core;
    boolean onPause = false;
    
    public Boss() {
        hp = 1000;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        blasters.add(new HitBoxBoss(248, 175));
        blasters.add(new HitBoxBoss(440,183));
        blasters.add(new HitBoxBoss(636, 183));
        blasters.add(new HitBoxBoss(828, 175));
        blasters.parallelStream().forEach(hitbox -> hitbox.blaster.setAutoUpdate(false));
        boss = new Image("data/image/Fase01/body1-1.png");
        core = new Image("data/image/Fase01/core1-1.png");
    
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(boss, 240, 0);
        g.drawImage(core, 484, 64);
        blasters.forEach(blasters -> {
            g.draw(blasters.hitbox);
            g.drawAnimation(blasters.blaster, blasters.x2, blasters.y);
        });
        bullets.forEach(bullets ->{
            g.draw(bullets.hitbox);
            g.drawAnimation(bullets.bullet, bullets.x, bullets.y);
        });
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        time += i;
        if (time % 50 == 0) {
            core.rotate(90);
        }
        if (time >= 0) {
            attack = comboBullets;
            time -= 200;
        }
        
        switch (attack){
            case idle:
                break;
            case randomBullets:
                this.randomBullets();
                break;
            case comboBullets:
                this.comboBullets();
                break;
        }
        
        blasters.forEach(blasters -> {
            try {
                blasters.update();
                if (blasters.blaster.getFrame() == 5 && blasters.onAttack){
                    Boss.bullets.add(new TiroBoss(blasters.x,blasters.y, blasters.ang));
                    blasters.onAttack = false;
                }    
            } catch (SlickException ex) {
                Logger.getLogger(Boss.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bullets.forEach(bullets ->{
            try {
                bullets.intersect(Play.guts);
            } catch (SlickException ex) {
                Logger.getLogger(Boss.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bullets.removeIf(bullets -> bullets.bullet.isStopped());
        System.out.println(time);
    }
    
    public void pause() {
        blasters.forEach(blasters -> {
            blasters.blaster.setAutoUpdate(false);
        });
    }
    
    public void randomBullets() throws SlickException {
        if (time % 25 == 0){
        rand = (int) (Math.random() * 4);
        if (blasters.get(rand).onAttack == false) {
        blasters.get(rand).attack();
        }
        }
    }
    
    public void comboBullets() throws SlickException {
        if (time < -150){
            blasters.get(1).attack(); blasters.get(2).attack();
        }
        if (time > -150 && time < - 100){
            blasters.get(0).attack(); blasters.get(3).attack();
        }
        if (time > -100 && time <- 50){
            blasters.get(1).attack(); blasters.get(2).attack();
            blasters.get(0).attack(); blasters.get(3).attack();
        }
    }
}
