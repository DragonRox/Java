/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctordisease;

/**
 *
 * @author verratti.gfv
 */
public class PlayerListener {
    
}
        /**
        if (type == "state"){
            button = new MouseOverArea(gc, buttonImg[0], x - (buttonImg[0].getWidth()/2), y, buttonImg[0].getWidth(), buttonImg[0].getHeight(),  new ComponentListener() {
                @Override            
                public void componentActivated(AbstractComponent arg0) {
                    Menu.estadosMenu[0] = var;
                    }
                });
            button.setMouseOverImage(buttonImg[1]);
            }
        
        if (type == "controle"){
            button = new MouseOverArea(gc, imgButton, x - (buttonImg[0].getWidth()/2), y, buttonImg[0].getWidth(), buttonImg[0].getHeight(),  new ComponentListener() {            
                @Override
                public void componentActivated(AbstractComponent arg0) {
                    Menu.estadosMenu[var] += 1;
                    if (Menu.estadosMenu[var] > 1) Menu.estadosMenu[var] = 0;

                    if (Menu.estadosMenu[var] == 0) {
                        button.setNormalImage(buttonImg[0]);
                        button.setMouseOverImage(buttonImg[0]);
                    }
                    else {
                        button.setNormalImage(buttonImg[1]);
                        button.setMouseOverImage(buttonImg[1]);
                    }
                }      
                });                
            }
        */