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

import java.io.IOException;
import java.util.List;

public class StockDetailController {
    private Stage stage;
    private Scene scene;
    private Parent root;

//    @FXML
//    private Label stockNameLabel;
//
//    @FXML
//    private Label priceLabel;
//
    @FXML
    private Label subscribersLabel;

    @FXML
    private TextField stockNameField;

    @FXML
    private TextField stockPriceField;

    private StockExchange stockExchange;
    private String stockName;
    private boolean isNew = false;

    public void initData(String stockName, StockExchange stockExchange) {
        this.stockName = stockName;
        this.stockExchange = stockExchange;


        Stock stock = stockExchange.getStockByName(stockName);
        List<Observer> subs = stockExchange.getSubscribers(stockName);

//        stockNameLabel.setText("Stock: " + stock.getName());
//        priceLabel.setText("Price: $" + stock.getPrice());
        stockNameField.setText(stock.getName());
        stockPriceField.setText(String.valueOf(stock.getPrice()));
        stockNameField.setEditable(false);
        subscribersLabel.setText("Subscribers: " + subs.size());

    }

    public void initForNewStock(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
        isNew = true;
        stockNameField.setEditable(true);
    }

    @FXML
    public void onSaveClicked() {
        String name = stockNameField.getText().trim();
        double price = Double.parseDouble(stockPriceField.getText());

        if (isNew) {
            stockExchange.addStock(name, price);
        } else {
            stockExchange.updateStockPrice(name, price);
        }


    }

    @FXML
    public void onDeleteClicked() {
        if (!isNew) {
            String name = stockNameField.getText().trim();
            stockExchange.deleteStock(name);
        }
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
