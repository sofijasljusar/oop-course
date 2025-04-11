package com.example.task10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.List;

public class UserDetailController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label nameLabel;

    @FXML
    private Label roleLabel;


    private StockExchange stockExchange;


    public void initData(String userName, StockExchange stockExchange) {
        this.stockExchange = stockExchange;

        nameLabel.setText(userName);

        String role = "Unknown";
        for (String stock : stockExchange.getAllStockNames()) {
            for (Observer observer : stockExchange.getSubscribers(stock)) {
                if (observer.getName().equals(userName)) {
                    role = observer.getClass().getSimpleName();
                    break;
                }
            }
        }
        roleLabel.setText(role);

    }



    public void back(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Stocks.fxml"));
        Parent root = loader.load();

        // Get the existing controller
        StocksController stocksController = loader.getController();
        stocksController.setStockExchange(stockExchange); // ✅ inject current stock exchange
        stocksController.refreshStockList(); // Optional: refresh UI

        // Set the scene
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
