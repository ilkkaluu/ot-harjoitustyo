package kalapassi.ui;

import java.io.*;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

        Text logTitle = new Text("Kalapassi v. 0.3");                        //start screen components
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

        //----
        
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

        stage.setTitle("Kalapassi v. 0.3");
        stage.setScene(loginScene);
        stage.show();

        //----
        
        GridPane registerGrid = new GridPane();
        registerGrid.setPadding(new Insets(10, 10, 10, 10));
        registerGrid.setMinSize(300, 300);
        registerGrid.setVgap(10);
        registerGrid.setHgap(10);

        Text nameText = new Text("Your name: ");
        TextField nameTextField = new TextField();
        Text regText = new Text("Set username (a-z)");
        TextField regTextField = new TextField();
        Button regBtn = new Button();
        regBtn.setText("Create an account");
        Button backToLogin = new Button();
        backToLogin.setText("Cancel");

        registerGrid.add(nameText, 0, 1);                                       //register components
        registerGrid.add(nameTextField, 1, 1);
        registerGrid.add(regText, 0, 3);
        registerGrid.add(regTextField, 1, 3);
        registerGrid.add(regBtn, 1, 5);
        registerGrid.add(backToLogin, 1, 6);

        Text regNotificationName = new Text("");
        Text regNotificationUsername = new Text("");

        registerGrid.add(regNotificationName, 1, 2);
        registerGrid.add(regNotificationUsername, 1, 4);

        Pane regPane = new Pane();
        regPane.getChildren().add(registerGrid);

        Scene regScene = new Scene(regPane, 450, 250);

        //----
        
        GridPane menu = new GridPane();
        Scene menuScene = new Scene(menu, 500, 400);                            //menu components

        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setMinSize(300, 300);
        menu.setVgap(5);
        menu.setHgap(5);

        Text menuText = new Text("MAIN MENU");
        menuText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        welcome.setFont(Font.font("Impact", FontWeight.NORMAL, 14));
        Text tutorial = new Text("Here you can: \n- add caught fish \n- follow your stats \n- receive points from the caught fish");
        Button addCatch = new Button("Add a catch");
        Button stats = new Button("Personal statistics");
        Button leaderboard = new Button("Leaderboards");

        Button logout = new Button("Logout");

        Button quit = new Button("Quit");

        menu.add(menuText, 0, 0);
        menu.add(welcome, 0, 1);
        menu.add(tutorial, 0, 2);
        menu.add(addCatch, 0, 4);
        menu.add(stats, 0, 5);
        menu.add(leaderboard, 0, 6);
        menu.add(logout, 4, 4);
        menu.add(quit, 4, 6);

        //----
        
        GridPane catchMenu = new GridPane();
        Scene catchScene = new Scene(catchMenu, 500, 400);

        catchMenu.setPadding(new Insets(10, 10, 10, 10));                        //caught fish menu
        catchMenu.setMinSize(300, 300);
        catchMenu.setVgap(5);
        catchMenu.setHgap(5);

        Text catchText = new Text("CATCH MENU");
        catchText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Text catchHelp = new Text("Add a caught fish by choosing a species from the menu");
        Button confirmCatch = new Button("Confirm");
        Button back2main = new Button("Cancel");

        ObservableList<String> fishes
                = FXCollections.observableArrayList(
                        "Grayling",
                        "Perch",
                        "Rainbow trout",
                        "Roach",
                        "Trout"
                );
        final ComboBox fishBox = new ComboBox(fishes);

        catchMenu.add(catchText, 0, 0);
        catchMenu.add(catchHelp, 0, 5);
        catchMenu.add(fishBox, 0, 10);
        catchMenu.add(confirmCatch, 0, 15);
        catchMenu.add(back2main, 0, 20);

        //----
        
        BorderPane statMenu = new BorderPane();                                 //personal stat screen components
        VBox statMenuLeft = new VBox();
        statMenuLeft.setSpacing(10);
        statMenuLeft.setPadding(new Insets(10));
        Button toTopTen = new Button("To leaderboards");
        Button toStats = new Button("Refresh");
        Button back = new Button("Back");
        statMenuLeft.getChildren().addAll(toStats, toTopTen, back);
        statMenu.setBottom(statMenuLeft);

        VBox statMenuCenter = new VBox();
        statMenuCenter.setSpacing(8);
        statMenuCenter.setPadding(new Insets(10));
        Text username = new Text();
        Text userExerc = new Text("Fish caught: 0");
        Text userPoints = new Text("Total points: " + " 0 pts");
        statMenuCenter.getChildren().addAll(username, userExerc, userPoints);
        statMenu.setTop(statMenuCenter);

        //----
        
        BorderPane topTenMenu = new BorderPane();                               //leaderboard components
        VBox topMenuLeft = new VBox();
        topMenuLeft.setSpacing(10);
        topMenuLeft.setPadding(new Insets(10));
        Button toTopTen1 = new Button("Refresh");
        Button back1 = new Button("Back");
        Button toStats1 = new Button("To personal stats");
        topMenuLeft.getChildren().addAll(toTopTen1, toStats1, back1);
        VBox topMenuCenter = new VBox();
        topMenuCenter.setSpacing(10);
        topMenuCenter.setPadding(new Insets(10));

        topTenMenu.setBottom(topMenuLeft);
        topTenMenu.setTop(topMenuCenter);

        Scene statScene = new Scene(statMenu, 400, 250);
        Scene topTenScene = new Scene(topTenMenu, 400, 400);

        //----
        
        loginBtn.setOnAction((ActionEvent push) -> {
            stage.setScene(menuScene);
            stage.show();
        });

        createUserLink.setOnAction((ActionEvent push) -> {
            regNotificationName.setText("");
            regNotificationUsername.setText("");
            regBtn.setOnAction((ActionEvent e) -> {
                boolean typeError = false;
                nameTextField.setText("");
                regTextField.setText("");
            });

            backToLogin.setOnAction((ActionEvent e) -> {
                logNotification.setText("");
                nameTextField.clear();
                stage.setScene(loginScene);
                stage.show();
            });

            stage.setScene(regScene);
            stage.show();

        });
        
        //-----
        
        addCatch.setOnAction((ActionEvent catchAdd) -> {
            stage.setScene(catchScene);
            stage.show();
        });

        back2main.setOnAction((ActionEvent back2menu) -> {
            stage.setScene(menuScene);
            stage.show();
        });

        //----
        
        stats.setOnAction((ActionEvent stat) -> {
            stage.setScene(statScene);
            stage.show();
        });
        leaderboard.setOnAction((ActionEvent leader) -> {
            stage.setScene(topTenScene);
            stage.show();
        });

        back.setOnAction((ActionEvent statsBackBtn) -> {
            stage.setScene(menuScene);
            stage.show();
        });

        back1.setOnAction((ActionEvent statsBackBtn1) -> {
            stage.setScene(menuScene);
            stage.show();
        });
        
        //----

        logout.setOnAction((ActionEvent back2Login) -> {
            stage.setScene(loginScene);
            stage.show();
        });

        quit.setOnAction((ActionEvent stop) -> {
            System.out.println("Application shutting down.");
            stop();
        });

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
