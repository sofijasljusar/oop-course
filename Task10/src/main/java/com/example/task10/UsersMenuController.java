//package com.example.task10;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.ListView;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//public class UsersMenuController {
//
//    @FXML
//    private ListView<String> userListView;
//
//    private StockExchange stockExchange; // no longer static
//
//    public void setStockExchange(StockExchange se) {
//        this.stockExchange = se;
//    }
//
//    @FXML
//    public void initialize() {
//        if (stockExchange == null) {
//            System.out.println("StockExchange is null!");
//            return;
//        }
//
//        ObservableList<String> subscribers = FXCollections.observableArrayList();
//
//        for (String stock : stockExchange.getAllStockNames()) {
//            for (Observer o : stockExchange.getSubscribers(stock)) {
//                if (o != null && !subscribers.contains(o.getName())) {
//                    subscribers.add(o.getName());
//                }
//            }
//        }
//
//        userListView.setItems(subscribers);
//    }
//}
