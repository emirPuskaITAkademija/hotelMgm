package com.hotel.hotelmgm.gui.admin;

import com.hotel.hotelmgm.gui.admin.room.RoomAdminPanel;
import com.hotel.hotelmgm.gui.admin.user.UserAdminPanel;
import com.hotel.hotelmgm.gui.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Dalje moramo konstruisati administratorski ekran.
 *
 * <p>
 *     AdminScreen je BorderPane.
 *     To znači da je on kontejner koji dijeli ekran na cjeline po pravilima koja mu nalaže
 *     BorderPane.
 *     Ekran se dijeli na top, left, center, right, botom
 * </p>
 *
 */
public class AdminScreen extends BorderPane {
    private final ToggleButton userToggleButton = new ToggleButton("Korisnici");
    private final ToggleButton roomToggleButton = new ToggleButton("Sobe");
    private final Button logoutButton = new Button("Odjava");

    private UserAdminPanel userAdminPanel = new UserAdminPanel();
    private RoomAdminPanel roomAdminPanel;

    public AdminScreen(){
        ToggleGroup toggleGroup = new ToggleGroup();
        userToggleButton.setToggleGroup(toggleGroup);
        roomToggleButton.setToggleGroup(toggleGroup);

        HBox mainMenu = new HBox();
        mainMenu.setSpacing(5);
        mainMenu.setPadding(new Insets(10, 10 , 10 , 10));
        mainMenu.getChildren().addAll(userToggleButton, roomToggleButton);

        GridPane topPane = new GridPane();
        topPane.add(mainMenu, 0, 0);
        topPane.add(logoutButton, 1, 0);

        setTop(topPane);
        setCenter(userAdminPanel);

        logoutButton.setOnAction(Controller.instance().getEventBus().getLogoutEvent());
        userToggleButton.setOnAction(this::swapToUserAdminPanel);
        roomToggleButton.setOnAction(this::swapToRoomAdminPanel);
    }

    private void swapToUserAdminPanel(ActionEvent actionEvent){
        userAdminPanel = new UserAdminPanel();
        setCenter(userAdminPanel);
    }
    private void swapToRoomAdminPanel(ActionEvent actionEvent){
        roomAdminPanel = new RoomAdminPanel();
        setCenter(roomAdminPanel);
    }
}
