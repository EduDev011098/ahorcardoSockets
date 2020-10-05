package Controller;

import Model.Letras;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class GameController implements Initializable {

    private Letras letras;

    @FXML
    private Circle head;

    @FXML
    private Label eyes;

    @FXML
    private Label vidas;

    @FXML
    private Label boca;

    @FXML
    private Line torso;

    @FXML
    private Line manoIzquierda;

    @FXML
    private Line manoDerecha;

    @FXML
    private Line pieIzquierdo;

    @FXML
    private Line pieDerecho;

    @FXML
    private Button btnCheck;

    @FXML
    private TextField txtPalabra;

    @FXML
    private Label lblMuestraLetras;

    @FXML
    void verificaLetra(MouseEvent event) {
        try {
            if(txtPalabra.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Vacio");
                alert.setHeaderText(null);
                alert.setContentText("Debes introducir una letra " );
                alert.showAndWait();

            }

            if(letras.buscarLetra(txtPalabra.getText().charAt(0))) {
                lblMuestraLetras.setText(letras.getMascara());
                System.out.println(letras.getMascara());
                if(letras.verificarPalabra()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Congratulations");
                    alert.setHeaderText(null);
                    alert.setContentText("Has ganado!!! ");
                    alert.showAndWait();
                }
            }
            else {
                vidas.setText("Vidas: " + letras.setVida(txtPalabra.getText().charAt(0)));
                if (letras.getVida() == 5) {
                    head.setVisible(true);
                    eyes.setVisible(true);
                    boca.setVisible(true);
                }
                if (letras.getVida() == 4) {
                    torso.setVisible(true);
                }
                if (letras.getVida() == 3) {
                    manoIzquierda.setVisible(true);
                }
                if (letras.getVida() == 2) {
                    manoDerecha.setVisible(true);
                }
                if (letras.getVida() == 1) {
                    pieIzquierdo.setVisible(true);

                }
                if (letras.getVida() == 0) {
                    pieDerecho.setVisible(true);
                    if (letras.verificarError()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("F");
                        alert.setHeaderText(null);
                        alert.setContentText("Lo siento se acabaron los intentos, la palabra era: " + letras.getPalabra());
                        alert.showAndWait();
                        Stage stage = (Stage) btnCheck.getScene().getWindow();
                        stage.close();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("holi");
        }




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtPalabra.setStyle("-fx-border-color: whitesmoke;\n" +
                "    -fx-border-width: 0 0 1 0 ;\n" +
                "    -fx-background-color: transparent;\n" +
                "    -fx-prompt-text-fill: #fffd8c; \n" +
                "    -fx-text-fill: white; \n" +
                "    -fx-highlight-fill: #4eb769; ");
        boca.setVisible(false);
        eyes.setVisible(false);
        torso.setVisible(false);
        head.setVisible(false);
        manoDerecha.setVisible(false);
        manoIzquierda.setVisible(false);
        pieDerecho.setVisible(false);
        pieIzquierdo.setVisible(false);
        letras = new Letras();
        letras.setPalabra();
        letras.setMascara();
        lblMuestraLetras.setText(letras.getMascara());
        vidas.setText("vidas: " +letras.getVida());
    }

}
