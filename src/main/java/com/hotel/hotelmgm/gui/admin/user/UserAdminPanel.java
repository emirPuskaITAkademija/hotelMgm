package com.hotel.hotelmgm.gui.admin.user;


import com.hotel.hotelmgm.business.model.Privilege;
import com.hotel.hotelmgm.business.model.User;
import com.hotel.hotelmgm.business.service.privilege.PrivilegeServiceFactory;
import com.hotel.hotelmgm.business.service.privilege.PrivilegeServiceLocal;
import com.hotel.hotelmgm.business.service.user.UserServiceFactory;
import com.hotel.hotelmgm.business.service.user.UserServiceLocal;
import com.hotel.hotelmgm.commons.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

/**
 * <li>Naslov ili title</li>
 * <li>Table prikazati korisnike</li>
 * <li>Forma ispod tabele za unos korisnika</li>
 */
public class UserAdminPanel extends VBox {

    private ObservableList<User> userObservableList;

    private Label titleLabel = new Label(Constants.ADMIN_PANEL_TITLE);
    private TableView<User> userTableView = new TableView<>();

    private TextField usernameTextField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private TextField nameTextField = new TextField();
    private TextField surnameTextField = new TextField();
    private ChoiceBox<Privilege> privilegeChoiceBox = new ChoiceBox<>();

    private Button addUserButton = new Button("Dodaj");
    private Button deleteUserButton = new Button("Obriši");


    public UserAdminPanel(){
        titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10 , 10 , 10));

        TableColumn<User, String> usernameColumn = new TableColumn<>("Korisničko ime");
        usernameColumn.setMinWidth(150);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));

        TableColumn<User, String> nameColumn = new TableColumn<>("Ime");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));

        TableColumn<User, String> surnameColumn = new TableColumn<>("Prezime");
        surnameColumn.setMinWidth(100);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));

        TableColumn<User, String> privilegeTableColumn = new TableColumn<>("Privilegija");
        privilegeTableColumn.setMinWidth(150);
        privilegeTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("privilege"));
        /*
          Vežem se na izvor podataka. Pravimo upit na bazu.
         */
        List<User> userList = UserServiceFactory.USER_SERVICE.get().findAll();
        userObservableList = FXCollections.observableList(userList);
        userTableView.setItems(userObservableList);
        userTableView.getColumns().addAll(usernameColumn, nameColumn, surnameColumn, privilegeTableColumn);

        getChildren().addAll(titleLabel, userTableView, getForm());
    }

    private HBox getForm(){
        HBox formHBox = new HBox();
        formHBox.setSpacing(3);
        List<Privilege> privileges = PrivilegeServiceFactory.SERVICE.get().findAll();
        ObservableList<Privilege> observablePrivileges = FXCollections.observableArrayList(privileges);
        privilegeChoiceBox.setItems(observablePrivileges);

        usernameTextField.setPromptText("Korisničko ime..");
        passwordField.setPromptText("Lozinka...");
        nameTextField.setPromptText("Ime..");
        surnameTextField.setPromptText("Prezime..");
        addUserButton.setOnAction(this::onAddUserButtonAction);
        deleteUserButton.setOnAction(this::onDeleteButtonAction);
        formHBox.getChildren().addAll(
                usernameTextField,
                passwordField,
                nameTextField,
                surnameTextField,
                privilegeChoiceBox,
                addUserButton,
                deleteUserButton);
        return formHBox;
    }

    private void onDeleteButtonAction(ActionEvent actionEvent) {
        User selectedUser = userTableView.getSelectionModel().getSelectedItem();
        UserServiceLocal userServiceLocal = UserServiceFactory.USER_SERVICE.get();
        userServiceLocal.removeById(selectedUser.getId());
        userObservableList.remove(selectedUser);
    }

    /**
     *
     * @param actionEvent
     */
    private void onAddUserButtonAction(ActionEvent actionEvent){
        if(validate()){
            User user = new User();
            user.setUsername(usernameTextField.getText());
            user.setPassword(passwordField.getText());
            user.setName(nameTextField.getText());
            user.setSurname(surnameTextField.getText());
            user.setPrivilege(privilegeChoiceBox.getSelectionModel().getSelectedItem());
            UserServiceLocal userServiceLocal = UserServiceFactory.USER_SERVICE.get();
            userServiceLocal.create(user);
            userObservableList.add(user);
            clearInputs();
        }
    }

    private boolean validate(){
        if(nameTextField.getText().isBlank()){
            return false;
        }
        return true;
    }

    private void clearInputs(){
        usernameTextField.clear();
        passwordField.clear();
        nameTextField.clear();
        surnameTextField.clear();
        privilegeChoiceBox.getSelectionModel().select(0);
    }
}
