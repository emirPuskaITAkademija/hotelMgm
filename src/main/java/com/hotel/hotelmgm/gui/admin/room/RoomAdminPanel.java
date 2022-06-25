package com.hotel.hotelmgm.gui.admin.room;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * <li>Title</li>
 * <li>Room table overview</li>
 * <li>Form for room manage</li>
 */
public class RoomAdminPanel extends VBox {

    private final Label roomTitleLabel = new Label("Upravljanje sobama u hotelu");

    public RoomAdminPanel(){
        roomTitleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10 , 10 , 10));

        getChildren().addAll(roomTitleLabel);
    }
}
