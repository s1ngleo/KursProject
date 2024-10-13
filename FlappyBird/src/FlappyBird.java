import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class FlappyBird extends Application {
    private Controller controller;
    
    public static void main(String[] args)  
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FlappyBird.fxml"));
        Parent root = loader.load();
        
        
        controller = loader.getController();
        Scene FlappyBirdScene = new Scene(root, 800, 600);


        primaryStage.setTitle("Flappy Bird");
        primaryStage.setScene(FlappyBirdScene);
        primaryStage.show();
    //    controller.falling();

        
 Timer gameTime = new Timer();
 
TimerTask task = new TimerTask() 
        {
        public void run()
        {
            controller.falling();
        }
       };
gameTime.schedule(task,0,3);  

FlappyBirdScene.setOnKeyPressed(new EventHandler<KeyEvent>() 
{
   public void handle(KeyEvent event) 
   {
        if (event.getCode() == KeyCode.SPACE) 
        {
            controller.jump();
        }
    }
});

//controller.jump(event);
 

        
      
        
    }
}
