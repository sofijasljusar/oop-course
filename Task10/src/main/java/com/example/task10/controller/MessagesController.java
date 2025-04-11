package com.example.task10.controller;

import com.example.task10.model.Observer;
import com.example.task10.model.StockExchange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MessagesController {
    private Stage stage;
    private Scene scene;
    private StockExchange stockExchange;
    private Observer currentUser;

    @FXML
    private ListView<String> messagesList;



    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public void setUser(Observer user) {
        this.currentUser = user;

        messagesList.getItems().setAll(user.getMessages());
    }

    public void back(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDetail.fxml"));
        Parent root = loader.load();

        UserDetailController controller = loader.getController();
        controller.initData(currentUser.getName(), stockExchange);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
