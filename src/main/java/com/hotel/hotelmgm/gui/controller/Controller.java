package com.hotel.hotelmgm.gui.controller;

import com.hotel.hotelmgm.business.model.User;
import com.hotel.hotelmgm.gui.admin.AdminScreen;
import com.hotel.hotelmgm.gui.event.EventBus;
import com.hotel.hotelmgm.gui.login.LoginScreen;
import com.hotel.hotelmgm.gui.user.UserScreen;
import javafx.stage.Stage;

/**
 * Koja je moja svrha postojanja ?
 *
 * <p>
 * On je taj koji pamti ko je trenutno logovan u aplikaciji.
 * On je ta koji pamti koji je ekran trenutno prikazan u aplikaciji.
 * On je taj koji radi poveznicu između koriničkih akcija i UI kontrola.
 * </p>
 *
 */
public class Controller {

    /******** STATIC**********/
    public static Controller INSTANCE = null;

    public static Controller instance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }

    /*********** Definicija strukture klase *************/

    private Stage primaryStage;
    private LoginScreen loginScreen;
    private UserScreen userScreen;
    private AdminScreen adminScreen;
    private User loggedUser;
    private final EventBus eventBus = new EventBus();

    private Controller() {
        //SINGLETON
        System.out.println("Kreiran controller objekat...");
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public LoginScreen getLoginScreen() {
        return loginScreen;
    }

    public void setUserScreen(UserScreen userScreen) {
        this.userScreen = userScreen;
    }

    public UserScreen getUserScreen() {
        return userScreen;
    }

    public void setAdminScreen(AdminScreen adminScreen) {
        this.adminScreen = adminScreen;
    }

    public AdminScreen getAdminScreen() {
        return adminScreen;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
