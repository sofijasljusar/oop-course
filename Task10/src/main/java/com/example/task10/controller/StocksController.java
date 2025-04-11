package com.example.task10.controller;

//import javafx.collections.FXCollections;
import com.example.task10.model.Broker;
import com.example.task10.model.Investor;
import com.example.task10.model.Observer;
import com.example.task10.model.StockExchange;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class StocksController implements Initializable {
    @FXML // fxml injection to add listview
    private ListView<String> stockListView;
    @FXML
    private ListView<String> userListView;

    private StockExchange stockExchange = StockExchange.getInstance();
    private Scene scene;
    private Stage stage;



    @Override // to populate listview
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (stockExchange.getAllStockNames().isEmpty()) {
            stockExchange.addStock("Google", 1500);
            stockExchange.addStock("Apple", 200);
            stockExchange.addStock("Amazon", 3000);

            Observer alice = new Investor("Alice");
            Observer bob = new Broker("Bob");

            stockExchange.attach("Google", alice);
            stockExchange.attach("Apple", bob);
        }

        refreshStockList();

        // Redirect to Stock detail page
        stockListView.setOnMouseClicked(event -> {
            String selectedStock = stockListView.getSelectionModel().getSelectedItem();
            if (selectedStock != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("StockDetail.fxml"));
                    Parent root = loader.load();

                    // Pass data to the detail controller
                    StockDetailController controller = loader.getController();
                    if (selectedStock.equals("➕ Add Stock")) {
                        controller.initForNewStock(stockExchange);
                    } else {
                        controller.initData(selectedStock, stockExchange);
                    }

                    // Switch scene
                    stage = (Stage) stockListView.getScene().getWindow();
                    stage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Redirect to User detail page
        userListView.setOnMouseClicked(event -> {
            String selectedUser = userListView.getSelectionModel().getSelectedItem();
            if (selectedUser != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDetail.fxml"));
                    Parent root = loader.load();

                    // Pass data to the detail controller
                    UserDetailController controller = loader.getController();
                    if (selectedUser.equals("➕ Add User")) {
                        controller.initForNewUser(stockExchange);
                    } else {
                        controller.initData(selectedUser, stockExchange);
                    }

                    // Switch scene
                    stage = (Stage) stockListView.getScene().getWindow();
                    scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                    stage.setScene(scene);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }
    public void refreshStockList() {
        stockListView.getItems().clear();
        stockListView.getItems().addAll(stockExchange.getAllStockNames());
        stockListView.getItems().add("➕ Add Stock");
    }
    @FXML
    private void toggleUsersPanel() {
        boolean currentlyVisible = userListView.isVisible();
        userListView.setVisible(!currentlyVisible);

        if (!currentlyVisible) {
            ObservableList<String> subscribers = FXCollections.observableArrayList();
            for (String stock : stockExchange.getAllStockNames()) {
                for (Observer o : stockExchange.getSubscribers(stock)) {
                    if (o != null && !subscribers.contains(o.getName())) {
                        subscribers.add(o.getName());
                    }
                }
            }
            userListView.getItems().clear();
            userListView.getItems().addAll(subscribers);
            userListView.getItems().add("➕ Add User");

        }
    }
}