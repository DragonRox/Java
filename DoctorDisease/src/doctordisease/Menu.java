package doctordisease;

import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Gabriel
 */
public class Menu extends BasicGameState {
    
    ThreadMsc t = new ThreadMsc("ThreadMusic");
    
    Image background, boxOption;
    Image[] logoGame = new Image[8];    
    Animation logo = new Animation(logoGame, 2);
    
    Celulas[] celulasLst = new Celulas [15];
    Button btBack, btStart, btOptions, btQuit, btLanguage, btSound;
    Button[] btList;
    
    Sound btClick, btReturn;
    private Music bgMusic;
    
    private Font font;
    private TrueTypeFont pixelFont;
    
    
    public Menu(int ID) {
    }        
    
    @Override
    public int getID() {
        return 1;        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("/data/fonts/pixelart.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			font = font.deriveFont(36f);
			pixelFont = new TrueTypeFont(font, true);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
       
        //bgMusic= new Music("/data/sound/Intro_Drop.ogg");
        btClick= new Sound("/data/sound/Main_Menu_Select.ogg");
        btReturn= new Sound("/data/sound/Main_Menu_Back.ogg");
        
        btStart = new Button("bt_start", 512, 550, 2, btClick, "state");
        btOptions = new Button("bt_options", 512, 600, 1, btClick, "state");
        btQuit = new Button("bt_quit", 512, 650, 3, btClick, "state");
        btBack = new Button("bt_back", 700, 650, 0, btReturn, "state");
        btLanguage = new Button("language_options", 450, 550, 1, btClick, "controle");
        btSound = new Button("sound_options", 650, 550, 2, btClick, "controle");
        btList = new Button[] {btStart, btOptions, btQuit, btBack, btLanguage, btSound};
        
        for (Button b: btList)
            b.init(gc, sbg);     
        
        for (int x = 1; x <= 8; x++){
            logoGame[(x - 1)] = new Image("data/image/MainMenu/logo_game" + x +".png");
        }
        
        logo = new Animation(logoGame, 100, true);
        
        background = new Image("data/image/MainMenu/background.png");
        boxOption = new Image("data/image/MainMenu/box_options.png");
        
        for (int x = 0 ; x < 15 ; x++){
            celulasLst[x] = new Celulas();
            celulasLst[x].init(gc, sbg);
        }
        
        DoctorDisease.gameState = getID();
        t.init(gc, sbg);
        t.start();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        for (Celulas c : celulasLst) c.render(gc, sbg, g);
      
        switch (Button.estados[0]){
            case 0:
                btStart.render(gc, sbg, g);
                btOptions.render(gc, sbg, g);
                btQuit.render(gc, sbg, g);  
                break;
            case 1:
                g.drawImage(boxOption, 100, 400);
                btLanguage.render(gc, sbg, g);
                btSound.render(gc, sbg, g);
                btBack.render(gc, sbg, g); 
                break;
            case 2:
                sbg.enterState(2);
                DoctorDisease.gameState = 2;
                break;
            case 3:
                System.exit(0);
                break;
        }       
        logo.draw(315, 30);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        for (Celulas c : celulasLst) c.update(gc, sbg, i);     
        /**
        if (!bgMusic.playing() && Button.estados[2] == 0) {
            bgMusic.play();
            DoctorDisease.app.setSoundOn(true);
        }
        else if (Button.estados[2] != 0) {
            bgMusic.pause();
            DoctorDisease.app.setSoundOn(false);
        } **/
    }
}

