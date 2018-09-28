import Server.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("views/mainView.fxml"));
        primaryStage.setTitle("EvaluaTec");
        primaryStage.setScene(new Scene(root, 768, 358));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Server server = new Server();
        Thread myThread = new Thread(server);
        myThread.start();
        launch(args);
    }
}
