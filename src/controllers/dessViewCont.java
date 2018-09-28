package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import logic.Curso;
import logic.Globals;
import logic.Themes;

import javax.swing.plaf.metal.MetalBorders;
import javax.xml.soap.Text;
import java.util.List;

public class dessViewCont {

    /**
     * Variable para modificar el slider
     */
    @FXML
    private Spinner<Integer> sliderNum;

    /**
     * Variable para hacer referencia al comboBox de temas
     */
    @FXML
    private ComboBox<String> cmbTheme;

    @FXML
    private void initialize(){

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, 0);

        valueFactory.setValue(0);

        sliderNum.setValueFactory(valueFactory);

        List<String> temas = null;

        for(Curso cursoAux : Globals.getCursos()){
            if(cursoAux.getNombre().equals(Globals.getSelectedCourse())){
                temas = cursoAux.getTemas();
            }
        }

        if(temas != null){
            ObservableList<String> comboTema = FXCollections.observableArrayList(temas);

            cmbTheme.setItems(comboTema);

        }

    }



    @FXML
    /**
     * Funcion encargada de generar xml de pregunta y enviarlo al servidor para crear una pregunta nueva
     */
    private void addQuest(){

        Themes themes = null;

        for(Themes tema : Globals.getThemesEv()){
            if(tema.getName().equals(cmbTheme.getValue())){
                themes = tema;
            }
        }

        if(themes != null) {
            themes.setDess(themes.getDess() + sliderNum.getValue());
        }else{
            Themes temaN = new Themes(cmbTheme.getValue(),  0, 0, sliderNum.getValue());
            Globals.getThemesEv().add(temaN);
        }

        Stage stage = (Stage) cmbTheme.getScene().getWindow();

        stage.close();
    }

}
