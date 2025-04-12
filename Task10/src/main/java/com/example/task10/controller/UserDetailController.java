package com.example.task10.controller;

import com.example.task10.model.Broker;
import com.example.task10.model.Investor;
import com.example.task10.model.Observer;
import com.example.task10.model.StockExchange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class UserDetailController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Observer currentUser;

    @FXML
    private Button messagesButton;

    @FXML
    private TextField nameField;

    @FXML
    private Label roleLabel;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private Label stocksLabel;

    @FXML
    private Button saveButton1;

    @FXML
    private Button saveButton2;

    @FXML
    public ListView<String> userStocksList;

    private StockExchange stockExchange;
    private boolean isNew = false;



    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        userStocksList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                String selected = userStocksList.getSelectionModel().getSelectedItem();
                if (selected != null && selected.startsWith("➕")) {
                    showAttachStockDialog();
                }
            }
        });

        userStocksList.setCellFactory(lv -> {
            var cell = new javafx.scene.control.ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };

            cell.setOnContextMenuRequested(e -> {
                if (!cell.isEmpty() && !cell.getItem().startsWith("➕")) {
                    javafx.scene.control.ContextMenu contextMenu = new javafx.scene.control.ContextMenu();
                    javafx.scene.control.MenuItem detach = new javafx.scene.control.MenuItem("❌ Detach from stock");
                    detach.setOnAction(evt -> detachStock(cell.getItem()));
                    contextMenu.getItems().add(detach);
                    contextMenu.show(cell, e.getScreenX() - 50, e.getScreenY());
                }
            });

            return cell;
        });
    }

    private void showAttachStockDialog() {
        javafx.scene.control.ChoiceDialog<String> dialog = new javafx.scene.control.ChoiceDialog<>();
        dialog.setTitle("Add Stock");
        dialog.setHeaderText("Choose stock to follow:");

        List<String> allStocks = stockExchange.getAllStockNames();
        String user = nameField.getText().trim();

        // Filter only stocks not already subscribed to
        for (String stock : allStocks) {
            List<Observer> subs = stockExchange.getSubscribers(stock);
            if (subs.stream().noneMatch(o -> o.getName().equals(user))) {
                dialog.getItems().add(stock);
            }
        }

        dialog.getItems().sort(String::compareTo);

        dialog.showAndWait().ifPresent(selectedStock -> {

            attachStock(selectedStock);
        });
    }

    // BUG fixed - user was searched here by name in system, but system only saves active users (1+ stocks),
    // so passed observer object and put search by name to dialogue
    // aha, move not working line to a different place XD
    // passing - nope , global - yes! :D
    private void attachStock(String stockName) {
        String userName = nameField.getText().trim();

        if (currentUser != null) {
            try {
                stockExchange.attach(stockName, currentUser);
            } catch (IllegalStateException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ліміт досягнуто");
                alert.setHeaderText("Не можна додати підписника, ліміт досягнуто для акції " + stockName);
                alert.getButtonTypes().setAll(ButtonType.OK);
                alert.show();
            }
            refreshStockList(userName);
        }
    }

    private void detachStock(String stockName) {
        String userName = nameField.getText().trim();

        if (currentUser != null) {
            stockExchange.detach(stockName, currentUser);
            refreshStockList(userName);
        }
    }

    private void refreshStockList(String userName) {
        userStocksList.getItems().clear();

        for (String stock : stockExchange.getAllStockNames()) {
            for (Observer observer : stockExchange.getSubscribers(stock)) {
                if (observer.getName().equals(userName)) {
                    userStocksList.getItems().add(stock);
                    break;
                }
            }
        }
        userStocksList.getItems().add("➕ Add stock");

    }



    public void initData(String userName, StockExchange stockExchange) {
        this.stockExchange = stockExchange;
        this.currentUser = stockExchange.getUserByName(userName);

        messagesButton.setVisible(true);
        roleComboBox.setVisible(false);
        roleLabel.setVisible(true);

        nameField.setText(userName);
        nameField.setEditable(false);
        refreshStockList(userName);

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

    public void initForNewUser(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
        isNew = true;
        saveButton1.setVisible(true);
        nameField.setEditable(true);

        roleComboBox.setVisible(true);
        roleLabel.setVisible(false);
        stocksLabel.setVisible(false);
        userStocksList.setVisible(false);

    }
    @FXML
    public void onSaveClicked() {
        String name = nameField.getText().trim();
        String role = roleComboBox.getValue();

        Observer user;
        if (role.equalsIgnoreCase("Investor")) {
            currentUser = new Investor(name);
        } else if (role.equalsIgnoreCase("Broker")) {
            currentUser = new Broker(name);
        }
        saveButton1.setVisible(false);
        saveButton2.setVisible(true);
        stocksLabel.setVisible(true);
        userStocksList.setVisible(true);
        roleComboBox.setVisible(false);
        roleLabel.setText(role);
        roleLabel.setVisible(true);

        refreshStockList(name);

    }
    @FXML
    public void onConfirmClicked(ActionEvent e) throws IOException {
        int followedStockCount = userStocksList.getItems().size() - 1;
        if (followedStockCount < 1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Please select at least one stock to follow.");

            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.show();
        } else {
            back(e);
        }

    }

    public void back(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/task10/Stocks.fxml"));
        Parent root = loader.load();

        StocksController stocksController = loader.getController();
        stocksController.setStockExchange(stockExchange);
        stocksController.refreshStockList();

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/task10/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void openMessages(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/task10/UserMessages.fxml"));
        Parent root = loader.load();

        MessagesController controller = loader.getController();
        controller.setStockExchange(stockExchange);
        controller.setUser(currentUser);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/task10/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
}
