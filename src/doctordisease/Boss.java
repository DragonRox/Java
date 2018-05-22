/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.GL11;
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
    int x, y, hp, rand, attack;
    long lastCall, nowCall, time;
    static List<HitBoxBoss> blasters = new ArrayList <HitBoxBoss>();
    static List<TiroBoss> bullets = new ArrayList <TiroBoss>();
    SpriteSheet blasterSheet;
    Image boss;
    BossCore core;
    boolean onPause = false;
    
    public Boss() {
        hp = 1000;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        lastCall = System.currentTimeMillis();
        blasters.add(new HitBoxBoss(248, 175));
        blasters.add(new HitBoxBoss(440,183));
        blasters.add(new HitBoxBoss(636, 183));
        blasters.add(new HitBoxBoss(828, 175));
        blasters.parallelStream().forEach(hitbox -> hitbox.blaster.setAutoUpdate(false));
        boss = new Image("data/image/Fase01/body1-1.png");
        core = new BossCore();
        core.init(gc, sbg);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(boss, 240, 0);
        core.render(gc, sbg, g);
        /*
        blasters.forEach(blasters -> {
            g.draw(blasters.hitbox);
            g.drawAnimation(blasters.blaster, blasters.x2, blasters.y);
        });
        bullets.forEach(bullets ->{
            g.draw(bullets.hitbox);
            g.drawAnimation(bullets.bullet, bullets.x, bullets.y);
        });
        */
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        System.out.println(GL11.glGetInteger(GL11.GL_MAX_TEXTURE_SIZE));
        /*
        nowCall = System.currentTimeMillis();
        time = nowCall - lastCall;
        System.out.println(time);
        
        if (time >= 1000) { // select attack
            attack = comboBullets;
            lastCall = System.currentTimeMillis();
        } // select attack
        
        switch (attack) {
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
        */
    }
    
    public void pause() {
        blasters.forEach(blasters -> {
            blasters.blaster.setAutoUpdate(false);
        });
    }
    
    public void dispause() {
        blasters.forEach(blasters -> {
            if (blasters.onAttack == true) blasters.blaster.setAutoUpdate(true);
        });
    }
    
    public void randomBullets() throws SlickException {
        if (time % 10 == 0){
            rand = (int) (Math.random() * 4);
            if (blasters.get(rand).onAttack == false) {
                blasters.get(rand).attack();
            }
        }
    }
    
    public void comboBullets() throws SlickException {
        if (time < -200){
            blasters.get(1).attack(); blasters.get(2).attack();
        }
        if (time > -150 && time < - 100){
            blasters.get(0).attack(); blasters.get(3).attack();
        }
        if (time > -50 && time <- 0){
            blasters.get(1).attack(); blasters.get(2).attack();
            blasters.get(0).attack(); blasters.get(3).attack();
        }
    }
    
    public void flowerBullets() throws SlickException {
        if (time % 25 == 0){
        }     
    }
}
