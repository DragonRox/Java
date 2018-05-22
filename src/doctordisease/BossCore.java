/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

import org.newdawn.slick.Animation;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author verratti.gfv
 */
public class BossCore {
    
    BigImage bigCoreIdle;
    SpriteSheet sheetCoreIntro1;
    Animation coreIntro1;    
    SpriteSheet sheetCoreIntro2;
    Animation coreIntro2;
    SpriteSheet sheetCoreIdle;
    Animation coreIdle;
    SpriteSheet sheetCoreAttackReset;
    Animation coreAttackReset;
    SpriteSheet sheetCoreAttackCharge;
    Animation coreAttackCharge;
    SpriteSheet sheetCoreAttackSet;
    Animation coreAttackSet;
    SpriteSheet sheetCoreAttackCd;
    Animation coreAttackCd;
    SpriteSheet sheetCoreAttackShot;
    Animation coreAttackShot;

    public BossCore() {
    }
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        sheetCoreIntro1 = new SpriteSheet("data/image/Fase01/core-1-1-intro-pt1.png", 128, 156);
        coreIntro1 = new Animation(sheetCoreIntro1, 100);
        sheetCoreIntro2 = new SpriteSheet("data/image/Fase01/core-1-1-intro-pt2.png", 128, 156);
        coreIntro2 = new Animation(sheetCoreIntro2, 100);
        
        bigCoreIdle = new BigImage("data/image/Fase01/core-1-1-idle.png");
        sheetCoreIdle = new SpriteSheet(bigCoreIdle, 128, 156);
        coreIdle = new Animation(sheetCoreIdle, 100);
        sheetCoreAttackReset = new SpriteSheet("data/image/Fase01/core-1-1-atk-reset.png", 128, 156);
        coreAttackReset = new Animation(sheetCoreAttackReset, 100);
        sheetCoreAttackCharge = new SpriteSheet("data/image/Fase01/core-1-1-atk-charge.png", 128, 156);
        coreAttackCharge = new Animation(sheetCoreAttackCharge, 100);
        sheetCoreAttackSet = new SpriteSheet("data/image/Fase01/core-1-1-atk-set.png", 128, 156);
        coreAttackSet = new Animation(sheetCoreAttackSet, 100);
        sheetCoreAttackCd = new SpriteSheet("data/image/Fase01/core-1-1-atk-cd.png", 128, 156);
        coreAttackCd = new Animation(sheetCoreAttackCd, 100);
        sheetCoreAttackShot = new SpriteSheet("data/image/Fase01/core-1-1-atk-shot.png", 128, 156);
        coreAttackShot = new Animation(sheetCoreAttackShot, 100);   
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawAnimation(coreIdle, 50, 50);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }
    
    
}
