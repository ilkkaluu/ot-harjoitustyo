package kalapassi.ui;

import java.io.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class KalapassiUi extends Application {

    public void start(Stage stage) throws IOException {
        GridPane startGrid = new GridPane();
        startGrid.setPadding(new Insets(10, 10, 10, 10));
        startGrid.setMinSize(300, 300);
        startGrid.setVgap(10);
        startGrid.setHgap(10);

        Text logTitle = new Text("Kalapassi v. 0.1");                        //start screen components
        logTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        Text newUserText = new Text("No account yet?");

        Hyperlink createUserLink = new Hyperlink();
        createUserLink.setText("Register");

        Text usernameText = new Text("Username:");

        TextField accNameFeed = new TextField();
        accNameFeed.setPrefColumnCount(10);

        Button loginBtn = new Button();
        loginBtn.setText("Login");

        Button quitBtn = new Button();
        quitBtn.setText("Quit");

        //--
        startGrid.add(logTitle, 0, 0);
        startGrid.add(usernameText, 0, 1);
        startGrid.add(accNameFeed, 1, 1);                                            //start screen & login screen components
        startGrid.add(loginBtn, 1, 2);
        startGrid.add(newUserText, 0, 3);
        startGrid.add(createUserLink, 1, 3);
        startGrid.add(quitBtn, 1, 5);

        Text logNotification = new Text("");
        startGrid.add(logNotification, 0, 2);

        Pane root = new Pane();
        root.getChildren().add(startGrid);

        Scene loginScene = new Scene(root, 400, 250);

        Text welcome = new Text("");

        stage.setTitle("Kalapassi v. 0.1");
        stage.setScene(loginScene);
        stage.show();
        
        quitBtn.setOnAction((ActionEvent stop) -> {
            System.out.println("Application shutting down.");
            stop();
        });
    }
    
    @Override
    public void stop() {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
