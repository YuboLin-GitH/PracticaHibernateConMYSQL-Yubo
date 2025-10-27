module com.yubo.practicahibernateconmysqlyubo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.yubo.practicahibernateconmysqlyubo to javafx.fxml;
    exports com.yubo.practicahibernateconmysqlyubo;
}