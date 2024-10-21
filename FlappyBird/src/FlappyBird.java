import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;




public class FlappyBird extends Application {
    private Controller controller;
    public AnimationTimer gameLoop;


        public void stopGame()
        { if(gameLoop!=null)
            {
            gameLoop.stop();
        }
        }

        public void startGame()
        {if(gameLoop!=null)
            {
            gameLoop.start();
        }
        }



    public static void main(String[] args)  
    {
        
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("flappybird.fxml"));
        Parent root = loader.load();
        
        
        controller = loader.getController();
        controller.setGameLoop(this);
        Scene FlappyBirdScene = new Scene(root, 1280, 900);

        primaryStage.setTitle("Flappy Bird");
        primaryStage.setScene(FlappyBirdScene);
        primaryStage.show();






       gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.birdFalling();
                controller.moveTube();
                controller.moveTube2();
                controller.moveFon();
                controller.moveFon2();
                controller.moveGround();
                controller.moveGround2();
                controller.stopGame();
                controller.stopGame2();
                controller.stopGameSolo();;
                controller.scores(); 
                controller.jumpTimer();
                controller.jumpTimer2();
                
                

            }
        };
        controller.setBird();
        controller.setTubes();

    






        FlappyBirdScene.setOnKeyPressed(new EventHandler<KeyEvent>() 
        {
             public void handle(KeyEvent event) {
   
                 if (event.getCode() == KeyCode.SPACE) 
                {
            controller.jump();
                }
                else if (event.getCode() == KeyCode.ENTER)
                {
                    controller.jump2();
                }
                }
        });



    }
}
