import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;

public class FlappyBird extends Application {
    public static void main(String[] args)  {


Bird bird = new Bird();
Timer gameTime = new Timer();
TimerTask task = new TimerTask() 

    {
        public void run()
        {
            bird.falling();
        }
       };
      
gameTime.schedule(task,2000,500);

// bird.jump(2);   кнопка
launch(args);
gameTime.cancel();

        {
            System.out.println(bird.height);
        }
   

    
    
    
    




   



    }

    @Override
    public void start(Stage primaryStage)  {
        StackPane root = new StackPane();
        primaryStage.setTitle("Flappy Bird");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
