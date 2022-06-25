package com.hotel.hotelmgm.gui.event;

import com.hotel.hotelmgm.business.model.Privilege;
import com.hotel.hotelmgm.business.model.User;
import com.hotel.hotelmgm.business.service.user.UserServiceFactory;
import com.hotel.hotelmgm.gui.admin.AdminScreen;
import com.hotel.hotelmgm.gui.controller.Controller;
import com.hotel.hotelmgm.gui.login.LoginScreen;
import com.hotel.hotelmgm.gui.user.UserScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 * <p>
 * LoginEvent je implementacija EventHandler<ActionEvent> i upravo zbog toga
 * njega možemo povezati sa loginButton instancom koja se nalazi unutar LoginScreen.
 * Na taj način će akcija click eventa dovesti do toga da se poziva handle metoda definirana u ovoj klasi.
 * </p>
 */
public class LoginEvent implements EventHandler<ActionEvent> {
    /**
     * Klik na login button mora dovesti do pokušaja logovanja korisnika u aplikaciju.
     * Postoje sljedeći scenariji:
     * <li>1. Korisnik kliknuo na loginButton a nije unio username, password</li>
     * <li>2. Korisnik je unio nesipravan username i password</li>
     *
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        Controller controller = Controller.instance();
        LoginScreen loginScreen = controller.getLoginScreen();
        String username = loginScreen.getUsernameTextField().getText();
        String password = loginScreen.getPasswordField().getText();
        if (username == null || username.isBlank()) {
            loginScreen.getMessageLabel().setText("Nije vam dozvoljeno prazan unos korisničkog imena");
            return;
        }
        if (password == null || password.isEmpty()) {
            loginScreen.getMessageLabel().setText("Nije vam dozvoljeno prazan unos lozinke");
            return;
        }
        /**
         * Mogućnosti
         * <li>1. Korisnik ispravno unio usernam i password -> user != null</li>
         * <li>2. Korsinik neispravno unio -> user == null</li>
         */
        User user = UserServiceFactory.USER_SERVICE.get().login(username, password);
        if (user == null) {
            controller.getLoginScreen().getMessageLabel().setText("Nesipravna kombinacija korisničkog imena i lozinke");
            return;
        } else {
            //ektraktujem informacije iz korisničke instance user
            Privilege privilege = user.getPrivilege();
            controller.setLoggedUser(user);

            if ("admin".equals(privilege.getName())) {
                AdminScreen adminScreen = new AdminScreen();
                Scene scene = new Scene(adminScreen, 650, 300);
                controller.getPrimaryStage().setTitle("Admin: " + user.getName());
                controller.getPrimaryStage().setScene(scene);
            } else {
                UserScreen userScreen = new UserScreen();
                Scene scene = new Scene(userScreen, 650, 300);
                controller.getPrimaryStage().setTitle("Employee: " + user.getName());
                controller.getPrimaryStage().setScene(scene);
            }
        }
    }
}
