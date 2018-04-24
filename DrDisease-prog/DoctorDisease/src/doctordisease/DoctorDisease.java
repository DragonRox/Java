package doctordisease;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DoctorDisease extends StateBasedGame {
    
    public static int WIDTH = 1024;
    public static int HEIGHT = 768;
    public static int FPS = 60;
    public static int gameState = 1;
    public static boolean gameRunning = true;
    public static AppGameContainer app;
    
    public DoctorDisease(String gamename) {
        super(gamename);
    }
    
    public static void main(String[] args) {
        try
            {
		app = new AppGameContainer(new DoctorDisease("Dr Disease"));
		app.setDisplayMode(WIDTH, HEIGHT, false);
                app.setTargetFrameRate(FPS);
		app.start();
            }
	catch (SlickException ex)
            {
		Logger.getLogger(DoctorDisease.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new Menu(0));
        this.addState(new Play(1));
    }
}