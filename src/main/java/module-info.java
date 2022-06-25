module com.hotel.hotelmgm {
    requires javafx.controls;
    requires java.naming;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.persistence;
    requires java.xml.bind;
    requires java.sql;
    requires java.sql.rowset;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;

    opens com.hotel.hotelmgm to javafx.fxml;
    opens com.hotel.hotelmgm.business.model to org.hibernate.orm.core;

    exports com.hotel.hotelmgm;
    exports com.hotel.hotelmgm.business.model;
}