import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;




public class Schronisko  {
    final int ilosc = 3;
    String zwierzak;

    ArrayList<String> listaZwierzat = new ArrayList<String>();
    @FXML
    void odczyt() throws FileNotFoundException {
        Scanner s = new Scanner(new File("ala.txt"));
        while(s.hasNext()){
            listaZwierzat.add(s.next());
        }
        s.close();
    }



    @FXML
    void dodajZwierzaka() {
        System.out.println("Podaj imie zwierzaka");


    }
    @FXML
    void sprawdzStatus() {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
        a1.setTitle("Alert");
        a1.setHeaderText("W schronisku jest " +listaZwierzat.size() + " zwierzat");
        //a1.setContentText();
        a1.showAndWait();
//        System.out.println("W schronsku jest " + listaZwierzat.size() + " zwierzat.");
    }
    @FXML
    private void alarm() throws FileNotFoundException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Alert");
        dialog.setHeaderText("Dodajesz zwierzaka!");
        dialog.setContentText("Podaj imie zwierzaka!");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if (listaZwierzat.size() < ilosc) {

                listaZwierzat.add(result.get());
            } else {
                Alert a2 = new Alert(Alert.AlertType.WARNING);
                a2.setTitle("Alert");
                a2.setHeaderText("W schronisku jest za dużo zwierzat!");
                a2.showAndWait();
            }
            funkcja();
        }


    }
    @FXML
    void wyjscie(){
        System.exit(0);
    }


    void funkcja() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("ala.txt");
        for(int i = 0; i < listaZwierzat.size(); i++){
           zapis.write(listaZwierzat.get(i) + System.lineSeparator());



        }
        zapis.close();
    }

        @FXML
        void newPage() {
        try {

            Parent root2 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }


}
