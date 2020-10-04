//package Controller;
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Line;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class ControllerAhorcado implements Initializable {
//
//    @FXML
//    private Button btnPlay;
//
//    @FXML
//    private Circle head;
//
//    @FXML
//    private Label eyes;
//
//    @FXML
//    private Label boca;
//
//    @FXML
//    private Line torso;
//
//    @FXML
//    private Line manoIzquierda;
//
//    @FXML
//    private Line manoDerecha;
//
//    @FXML
//    private Line pieIzquierdo;
//
//    @FXML
//    private Line pieDerecho;
//
//    @FXML
//    private Label titleGame;
//
//
//    @FXML
//    void startGame(MouseEvent event) {
//        Stage stage = (Stage) btnPlay.getScene().getWindow();
//        stage.close();
//        nextVentana(stage);
//    }
//
//    public void nextVentana(Stage primaryStage){
//        try {
//            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("/Views/gameView.fxml"));
//            stage = new Stage(StageStyle.DECORATED);
//            stage.setTitle("Ahorcado");
//            stage.setScene(new Scene(root,670,540));
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        head.setVisible(false);
//        torso.setVisible(false);
//        manoDerecha.setVisible(false);
//        manoIzquierda.setVisible(false);
//        pieDerecho.setVisible(false);
//        pieIzquierdo.setVisible(false);
//        eyes.setVisible(false);
//        boca.setVisible(false);
//    }
//}
package Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerAhorcado {

    @FXML
    private Button btnPlay;

    @FXML
    private Label titleGame;

    @FXML
    private Button btnExit;

    @FXML
    void Exit(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void nextView(MouseEvent event) {
        Stage stage = (Stage) btnPlay.getScene().getWindow();
        stage.close();
        closStage(stage);

    }

    public void closStage(Stage secondStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Views/gameView.fxml"));
            secondStage = new Stage(StageStyle.DECORATED);
            secondStage.setTitle("Ahorcado");
            secondStage.setScene(new Scene(root,670,540));
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
