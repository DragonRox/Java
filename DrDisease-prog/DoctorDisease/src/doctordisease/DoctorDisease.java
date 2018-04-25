package doctordisease;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DoctorDisease extends StateBasedGame {
    
    // atributos do nosso app/jogo
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    public static final int FPS = 60;
    public static int gameState = 0;
    public static boolean gameRunning = true;
    public static AppGameContainer app;
    
    public DoctorDisease(String gamename) {
        super(gamename);
    }
    
    public static void main(String[] args) {
        try // parte responsável por criar a estrutura/corpo do jogo
            {
		app = new AppGameContainer(new DoctorDisease("Dr Disease"));
		app.setDisplayMode(WIDTH, HEIGHT, true);
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
        // adiciona os states do jogo
        this.addState(new IntroState(0));
        this.addState(new Menu(1));
        this.addState(new Play(2));
    }
    
}
