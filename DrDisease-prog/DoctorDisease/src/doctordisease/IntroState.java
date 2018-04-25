package doctordisease;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import static org.newdawn.slick.Input.KEY_ENTER;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class IntroState extends BasicGameState {

    ThreadMsc tMusic = new ThreadMsc("Thread da musica");

    private int time;
    private boolean tr=false;
    private int state;
    
    //private Music introDrop;
    private SpriteSheet imgIntro;
    private Animation intro;
    private Image logoTeam, logoFatec;
    
    public IntroState(int state){
        
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //introDrop = new Music("/data/sound/Intro_Pre_Drop.ogg");
        state=0;
        logoTeam = new Image("/data/image/intro/logo_team.png");
        logoFatec = new Image("/data/image/intro/logo_fatec.png");
        imgIntro = new SpriteSheet("/data/image/intro/intro.png",470,320);
        intro= new Animation(imgIntro,130);
        intro.setAutoUpdate(true);
        intro.stopAt(30);
        tMusic.start();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        switch(state){
            case 0:
                logoTeam.drawCentered(512, 384);
                break;
            case 1:
                logoFatec.drawCentered(512, 384);
                break;
            case 2:
                intro.draw(512-(intro.getWidth()/2),384-(intro.getHeight()/2));
                break;
        }
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
       //if(!introDrop.playing())introDrop.play();
       Input input=gc.getInput();
       time+=delta;
       if(state==0)if(input.isKeyPressed(KEY_ENTER)||time>1000)state=1;
       if(state==1)if(input.isKeyPressed(KEY_ENTER)||time>2500)state=2;
       //if(state==2)if(input.isKeyPressed(KEY_ENTER)); NÃO CONSEGUI IMPLEMENTAR ISTO, CORTE DA INTRO (Flavio)
       if(intro.isStopped() && tr==false) {
           sbg.enterState(1,new FadeOutTransition(new Color (255,0,0)) ,new FadeInTransition(new Color (255,0,0)));
           tr=!tr;
       }
    }
    
    @Override
    public int getID() {
        return 0;
    }
    
}