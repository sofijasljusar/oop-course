package com.example.task10;

//import javafx.collections.FXCollections;
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

    private StockExchange stockExchange = new StockExchange(2); // Create a StockExchange instance
    private Stage stage;


    @Override // to populate listview
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stockExchange.addStock("Google", 1500);
        stockExchange.addStock("Apple", 200);
        stockExchange.addStock("Amazon", 3000);
        System.out.println(stockExchange.getAllStockNames());
        stockListView.getItems().addAll(stockExchange.getAllStockNames());
        stockListView.getItems().add("➕ Add Stock");

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
                    stage.setTitle("Stock Detail - " + selectedStock);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Observer alice = new Investor("Alice");
        Observer bob = new Investor("Bob");

        stockExchange.attach("Google", alice);
        stockExchange.attach("Google", bob);
    }
}


//    private Stage stage;
//
//    @FXML
//    private ListView<String> stockListView; // This will be used to display stock names
//    @FXML
//    private ListView<String> userListView;
//
//    private StockExchange stockExchange = new StockExchange(2); // Create a StockExchange instance
//
//    @FXML
//    public void initialize() {
//        // Sample stocks for demonstration (You can also dynamically add them in your logic)
//        stockExchange.addStock("Google", 1500);
//        stockExchange.addStock("Apple", 200);
//        stockExchange.addStock("Amazon", 3000);
//
//        // Now, populate the ListView with the names of the stocks
//        updateStockList();
//        stockListView.setOnMouseClicked(event -> {
//            String selectedStock = stockListView.getSelectionModel().getSelectedItem();
//            if (selectedStock != null) {
//                try {
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("StockDetail.fxml"));
//                    Parent root = loader.load();
//
//                    // Pass data to the detail controller
//                    StockDetailController controller = loader.getController();
//                    controller.initData(selectedStock, stockExchange);
//
//                    // Switch scene
//                    stage = (Stage) stockListView.getScene().getWindow();
//                    stage.setScene(new Scene(root));
//                    stage.setTitle("Stock Detail - " + selectedStock);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        });
//        Observer alice = new Investor("Alice");
//        Observer bob = new Investor("Bob");
//
//        stockExchange.attach("Google", alice);
//        stockExchange.attach("Google", bob);
//
//    }
//
//    // Method to update the ListView with the list of stocks
//    public void updateStockList() {
//        // Create an ObservableList to hold stock names
//        ObservableList<String> stockNames = FXCollections.observableArrayList();
//
//        // Iterate through stocks and add their names to the ObservableList
//        for (String stockName : stockExchange.getAllStockNames()) {
//            stockNames.add(stockName); // Add the name of the stock to the list
//        }
//
//        // Update the ListView with the ObservableList
//        stockListView.setItems(stockNames);
//    }
//
//    @FXML
//    private void toggleUsersPanel() {
//        boolean currentlyVisible = userListView.isVisible();
//        userListView.setVisible(!currentlyVisible); // Toggle visibility
//
//        if (!currentlyVisible) {
//            // If we're showing it now, populate the list
//            ObservableList<String> subscribers = FXCollections.observableArrayList();
//            for (String stock : stockExchange.getAllStockNames()) {
//                for (Observer o : stockExchange.getSubscribers(stock)) {
//                    if (o != null && !subscribers.contains(o.getName())) {
//                        subscribers.add(o.getName());
//                    }
//                }
//            }
//            userListView.setItems(subscribers);
//        }
//    }
//
//}
