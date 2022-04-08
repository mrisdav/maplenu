package com.mrisa.maplenudesk;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class HomeActivity {
    @FXML
    private ToggleButton menuToggleButton;

    public void initialize() {
        menuToggleButton.setSelected(true);
    }
}