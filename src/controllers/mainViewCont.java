package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import logic.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class mainViewCont {

    @FXML
    private Button btnRc;

    @FXML
    private TreeView themeTree;

    @FXML
    private ComboBox cmbCurso;

    @FXML
    private ComboBox<String> cmbCourse;

    @FXML
    private ComboBox<String> cmbTema;

    @FXML
    private CheckBox chkX;

    @FXML
    private TextField txtBxA;

    @FXML
    private TextField txtBxB;

    @FXML
    private TextField txtBxC;

    @FXML
    private TextField txtBxD;

    @FXML
    private TextArea txtPreg;

    @FXML
    private TextArea txtResp;

    @FXML
    private TextArea txtCom;

    @FXML
    private Button btnGp;

    @FXML
    private ComboBox<String> cbxGrado;

    @FXML
    private ComboBox<String> cbxTipo;

    @FXML
    private CheckBox chkQ;

    @FXML
    private CheckBox chkE;

    @FXML
    private CheckBox chkResp;

    @FXML
    private ComboBox<String> cmbUni;

    @FXML
    private ComboBox<String> cmbAreaA;

    @FXML
    private ComboBox<String> cmbEscuela;

    @FXML
    private TextField txtSemestre;






    public mainViewCont(){};

    @FXML
    private void initialize() throws ParserConfigurationException, SAXException, IOException {
        TreeItem<String> rootNode = new TreeItem<>("Temas a Evaluar");
        rootNode.setExpanded(true);
        if(Globals.getThemesEv().size() == 0){
            themeTree.setRoot(rootNode);
        }

        List<Curso> cursos;

        List<Universidad> universidades = new LinkedList<>();

        List<String> grado = new LinkedList<>();

        grado.add("Quiz");

        grado.add("Examen");

        List<String> tipo = new LinkedList<>();

        tipo.add("Respuesta Corta");

        tipo.add("Desarrollo");

        cursos = XMLizer.getXMLCursos("Cursos", "Curso");

        for(Curso cursoAux : cursos){
            Globals.getCursos().add(cursoAux);
        }

        List<String> cursosNom = new LinkedList<>();
        for(Curso curso: Globals.getCursos()){
            cursosNom.add(curso.getNombre());
        }

        ObservableList<String> comboCurso = FXCollections.observableArrayList(cursosNom);

        cmbCurso.setItems(comboCurso);

        cmbCourse.setItems(comboCurso);

        ObservableList<String> comboGrado = FXCollections.observableArrayList(grado);

        cbxGrado.setItems(comboGrado);

        ObservableList<String> comboTipo = FXCollections.observableArrayList(tipo);

        cbxTipo.setItems(comboTipo);

        universidades = XMLizer.getXmlUni("Universidades", "Universidad");

        List<String> unisAux = new LinkedList<>();

        for(Universidad uni : universidades){
            unisAux.add(uni.getNombre());
        }

        ObservableList<String> unisAuxC = FXCollections.observableArrayList(unisAux);

        cmbUni.setItems(unisAuxC);

        Globals.setUnis(universidades);

    }

    @FXML
    /**
     * Funcion encargada de crear en pantalla la ventana para agregar preguntras de marque con X
     */
    private void markX() throws IOException {

        if(cmbCurso.getValue() == null){
            return;
        }

        Globals.setSelectedCourse(cmbCurso.getValue().toString());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/markXview.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Seleccionar Marque con X");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    /**
     * Funcion encargada de crear en pantalla la ventana para agregar preguntras de respuesta corta
     */
    private void respC() throws IOException {

        if(cmbCurso.getValue() == null){
            return;
        }

        Globals.setSelectedCourse(cmbCurso.getValue().toString());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/respCview.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Seleccionar Marque con X");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    /**
     * Funcion encargada de crear en pantalla la ventana para agregar preguntras de desarrollo
     */
    private void dess() throws IOException {

        if(cmbCurso.getValue() == null){
            return;
        }

        Globals.setSelectedCourse(cmbCurso.getValue().toString());

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/dessView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Seleccionar Marque con X");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    /**
     * Funcion encargada de refrescar el arbol con los temas que se desean agregar a la prueba.
     */
    private void refreshTree(){
        TreeItem<String> rootNode = new TreeItem<>("Temas a Evaluar");
        rootNode.setExpanded(true);
        if(Globals.getThemesEv().size() == 0){
            themeTree.setRoot(rootNode);
        }
        else{
            for(Themes theme : Globals.getThemesEv()){
                TreeItem<String> tema = new TreeItem<>(theme.getName());
                TreeItem<String> marqueX = new TreeItem<>("Marque con X: " + theme.getMxQuest().toString());
                TreeItem<String> respCorta = new TreeItem<>("Respuesta Corta: " + theme.getRespCor().toString());
                TreeItem<String> dessarollo = new TreeItem<>("Desarrollo : " + theme.getDess().toString());

                tema.getChildren().addAll(marqueX, respCorta, dessarollo);

                rootNode.getChildren().add(tema);
            }
        }
        themeTree.setRoot(rootNode);
    }

    @FXML
    /**
     * Funcion encargada verificar si los otros checkbox se encuentran marcados para asi no seleccionar 2 del mismo tipo
     */
    private void ActivateCheckBox(){
        if(chkX.isSelected()){
            txtBxA.setDisable(false);

            txtBxB.setDisable(false);

            txtBxC.setDisable(false);

            txtBxD.setDisable(false);

            txtResp.setDisable(true);

        }else{
            txtBxA.setDisable(true);

            txtBxB.setDisable(true);

            txtBxC.setDisable(true);

            txtBxD.setDisable(true);

            txtResp.setDisable(false);
        }
    }

    @FXML
    /**
     * Funcion encargada de refrescar los contenidos del combo Box de temas dependiendo del curso seleccionado.
     */
    private void refreshCbx(){
        System.out.println(cmbCourse.getValue());
        if(cmbCourse.getValue().equals("")){
            return;
        }else{

            List<String> temas = null;

            for(Curso cursoAux : Globals.getCursos()){
                if(cursoAux.getNombre().equals(cmbCourse.getValue())){
                    temas = cursoAux.getTemas();
                }
            }

            if(temas != null){
                ObservableList<String> comboTema = FXCollections.observableArrayList(temas);

                cmbTema.setItems(comboTema);

            }
        }
    }

    @FXML
    /**
     * Funcion encargada de generar y enviar el xml de una nueva pregunta al servidor
     */
    public void genPreg() throws JAXBException {
        if(chkX.isSelected()){

            List<String> resp = new LinkedList<>();

            resp.add(txtBxA.getText());
            resp.add(txtBxB.getText());
            resp.add(txtBxC.getText());
            MargueX preg = new MargueX(txtPreg.getText(), txtCom.getText(), cbxGrado.getValue(), "X", cmbTema.getValue(),
                    cmbCourse.getValue(), resp, txtBxD.getText());

            Globals.setPreguntaGen(preg);

            XMLizer.marshallPreguntaX(preg);
        }else{
            Pregunta pregunta = new Pregunta(txtPreg.getText(), txtCom.getText(), txtResp.getText(), cbxGrado.getValue(),
                    cbxTipo.getValue(), cmbTema.getValue(), cmbCourse.getValue());
            Globals.setPreguntaGen(pregunta);
            XMLizer.marshallPregunta(pregunta);
        }
    }

    @FXML
    /**
     * Funcion encargada de rellenar los items del comboBox dependiendo de las escuelas y areas academicas de cada universidad.
     */
    private void fillCmb(){
        if(!cmbUni.getValue().equals("")){
            Universidad uniAux = null;
            for(Universidad uni : Globals.getUnis()){
                if(uni.getNombre().equals(cmbUni.getValue())){
                    uniAux =  uni;
                }
            }

            if(uniAux != null){
                ObservableList<String> escuelas = FXCollections.observableArrayList(uniAux.getEscuelas());
                cmbEscuela.setItems(escuelas);

                ObservableList<String> areaA = FXCollections.observableArrayList(uniAux.getAreasA());

                cmbAreaA.setItems(areaA);

                ObservableList<String> cursos = FXCollections.observableArrayList(uniAux.getCursos());

            }
        }
    }
}
