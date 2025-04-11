package com.example.task10;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserMessagesController {
    private Stage stage;
    private Scene scene;
    private StockExchange stockExchange;

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
