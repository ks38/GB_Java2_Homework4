module ru.knyazevvb.newfxapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.knyazevvb.fxapp to javafx.fxml;
    exports ru.knyazevvb.fxapp;
}