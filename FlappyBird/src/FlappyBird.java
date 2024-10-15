import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
  
import javafx.event.EventHandler;
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
        Scene FlappyBirdScene = new Scene(root, 1280, 900);

        primaryStage.setTitle("Flappy Bird");
        primaryStage.setScene(FlappyBirdScene);
        primaryStage.show();
   
        long birdFallSpeed =  3;
        long tubeMoveSpeed =  2;

Timer gameTime = new Timer();
TimerTask birdFalling = new TimerTask() 

        {
        public void run()
        {
            controller.birdFalling();
        }
       };

       TimerTask tubeMoving = new TimerTask() 

       {
       public void run()
       {
           controller.moveTube();
         
           controller.moveFon();
           controller.moveFon2();
           controller.moveGround();
           controller.moveGround2();
           controller.gamestatus(); 
       }
      };

gameTime.schedule(birdFalling,0,birdFallSpeed);  
gameTime.schedule(tubeMoving,0,tubeMoveSpeed);

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


    }
}
