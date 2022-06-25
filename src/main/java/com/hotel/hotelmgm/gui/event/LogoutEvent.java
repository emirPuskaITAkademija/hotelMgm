package com.hotel.hotelmgm.gui.event;

import com.hotel.hotelmgm.commons.Constants;
import com.hotel.hotelmgm.gui.controller.Controller;
import com.hotel.hotelmgm.gui.login.LoginScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 * Klik na logoutButton će pozvati blok koda našeg LogoutEvent.
 * <p>
 *     Šta moramo uraditi kako bi se pravilno izlogovali iz aplikacije ?
 *     <li>1. setLoggedUsed na null</li>
 *     <li>2. swap uraditi ekrana na sceni i formirati novu scenu sa login ekranom</li>
 * </p>
 */
public class LogoutEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Controller.instance().setLoggedUser(null);
        Controller.instance().getPrimaryStage().setTitle(Constants.LOGIN_TITLE);
        LoginScreen loginScreen = new LoginScreen();
        Controller.instance().setLoginScreen(loginScreen);
        Scene scene = new Scene(loginScreen, 650, 180);
        Controller.instance().getPrimaryStage().setScene(scene);
    }
}
