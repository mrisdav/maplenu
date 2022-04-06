package com.mrisa.maplenudesk;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeActivity {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}