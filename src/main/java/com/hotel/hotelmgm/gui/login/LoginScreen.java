package com.hotel.hotelmgm.gui.login;

import com.hotel.hotelmgm.gui.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * LoginScreen - GridPane kontejner
 * <p>
 * UI controls -> korisniku da se loguje
 * </p>
 */
public class LoginScreen extends GridPane {

    private final Label usernameLabel = new Label("Korisničko ime:");
    private final TextField usernameTextField = new TextField();
    private final Label passwordLabel = new Label("Lozinka:");
    private final PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Prijava");
    private final Button cancelButton = new Button("Odustani");
    private final Label messageLabel = new Label();

    public LoginScreen(){
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(25, 25, 25, 25));
        add(usernameLabel, 0,0);
        add(usernameTextField, 1, 0);
        add(passwordLabel, 0, 1);
        add(passwordField, 1, 1);

        FlowPane buttonPane = new FlowPane();
        buttonPane.setAlignment(Pos.CENTER_RIGHT);
        buttonPane.getChildren().addAll(loginButton, cancelButton);
        add(buttonPane, 1, 2);
        add(messageLabel, 1, 3);

        loginButton.setOnAction(Controller.instance().getEventBus().getLoginEvent());
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }
}
