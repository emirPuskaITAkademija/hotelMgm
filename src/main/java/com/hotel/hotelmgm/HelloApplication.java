package com.hotel.hotelmgm;

import com.hotel.hotelmgm.commons.Constants;
import com.hotel.hotelmgm.gui.controller.Controller;
import com.hotel.hotelmgm.gui.login.LoginScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * U našem informacionom sistemu imamo dva nivoa pristupa:
 * <li>1. administrator</li>
 * Mogućnost dodavanja ili brisanje sobe
 * <li>2. employee</li>
 * Mogućnost da kreira rezervacije za goste hotela.
 *
 * <p>
 *     GUI:
 *     <li>1. container BorderPane, VBox, HBox, GridPane..</li>
 *     <li>2. kontrole  Button,CheckBox, ChoiceBox, ...</li>
 * </p>
 *
 * <p>
 *     Ekrani koje moramo imati:
 *     <li>1. LoginScreen</li>
 *     <li>2. AdminScreen</li>
 *     <li>3. UserScreen</li>
 * </p>
 * Komponente:
 * <li>1. GUI</li>
 * <li>2. Controller</li>
 * <li>3. Model -> entities </li>
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        LoginScreen loginScreen = new LoginScreen();
        Controller.instance().setPrimaryStage(stage);
        Controller.instance().setLoginScreen(loginScreen);

        Scene scene = new Scene(loginScreen, 650, 180);
        stage.setTitle(Constants.LOGIN_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}