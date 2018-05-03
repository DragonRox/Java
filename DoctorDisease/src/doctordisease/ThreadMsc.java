/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ThreadMsc implements Runnable {

    private Thread t;
    private final String threadName;
    private Music introDrop;
    private Music bgMusic;
    
    ThreadMsc (String name) {
        threadName = name;
        System.out.println("Thread criado");
    }
    
    @Override
    public void run() {
        while (DoctorDisease.gameRunning){
            switch (DoctorDisease.gameState){
                case 0:
                    if(!introDrop.playing())introDrop.play();
                    break;
                case 1:
                    introDrop.stop();
                    if (!bgMusic.playing() && Button.estados[2] == 0) {
                        bgMusic.play();
                        DoctorDisease.app.setSoundOn(true);
                    }
                    else if (Button.estados[2] != 0) {
                        bgMusic.pause();
                        DoctorDisease.app.setSoundOn(false);
                    }      
                    break;
                case 2:
                    bgMusic.stop();
                    break;
            }
        }
    }
    
    public void start() {
        if (t == null){
            t = new Thread (this, threadName);
            t.start();
        }
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        introDrop = new Music("/data/sound/Intro_Pre_Drop.ogg");
        bgMusic= new Music("/data/sound/Intro_Drop.ogg");
    }
   
}
