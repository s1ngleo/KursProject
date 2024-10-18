import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
public class Controller {
  private FlappyBird gameLoop;
   @FXML
   private Button button;

   @FXML
   Text text;

   @FXML
   ImageView bird;

   @FXML
   ImageView tube;

   @FXML
   ImageView tube2;

   @FXML
   ImageView tube3;

   @FXML
   ImageView tube4;

   @FXML
   ImageView movingFon;
   
   @FXML
   ImageView movingFon2;
   
   @FXML
   ImageView ground;

   @FXML
   ImageView ground2;

    Random randomNum = new Random();
    int scores = 0;
   
   int minRandNum = 306;
   int maxRandNum = 716;
   int jumpItterator = 1;
   double gameSpeed = 8;
   double birdFallSpeed = 8;
   double tubeSpace = 1080;
   double jumpHeight = 28;
   boolean jumpAnimWorks = false;

   
   public void setGameLoop(FlappyBird gameloop)
   {
    this.gameLoop=gameloop;
   }

public void setBird()
{
  bird.setLayoutX(211);
  bird.setLayoutY(300);
}

public void setTubes()
{
  tube.setLayoutX(1294);
  tube3.setLayoutX(2020);
}

public void birdCord() //just for understanding bird actual position in console
{
  System.out.println(bird.getLayoutY()+"     " + bird.getLayoutX());
}

public void jump() {
 
    if (bird.getLayoutY() > 100) {
      jumpAnimWorks = true;

    }
}

public void jumpTimer()
{ 
  
  if (jumpAnimWorks==true)
  {
    jumpItterator+=1;

    bird.setLayoutY(bird.getLayoutY()-jumpHeight);

    if(jumpItterator>7)

    {
      jumpAnimWorks = false;
      jumpItterator=1;
    }

}
}


 public void birdFalling()
 {
   bird.setLayoutY(bird.getLayoutY()+birdFallSpeed);
 }




 public void moveTube()
  {
  tube.setLayoutX(tube.getLayoutX() - gameSpeed);  
  tube2.setLayoutX(tube.getLayoutX());
  tube2.setLayoutY(tube.getLayoutY()-tubeSpace);
  if (tube.getLayoutX()<-162)
    {
    tube.setLayoutX(1272);
    tube.setLayoutY(randomNum.nextInt(maxRandNum - minRandNum + 1) + minRandNum);
    }
  }

  public void moveTube2()
  {
   tube3.setLayoutX(tube3.getLayoutX() - gameSpeed);  
   tube4.setLayoutX(tube3.getLayoutX());
   tube4.setLayoutY(tube3.getLayoutY()-tubeSpace);
   if (tube3.getLayoutX()<-162)
    {
     tube3.setLayoutX(1272);
     tube3.setLayoutY(randomNum.nextInt(maxRandNum - minRandNum + 1) + minRandNum);
     
    }
  }


 

 public void moveFon()
 {
  movingFon.setLayoutX(movingFon.getLayoutX() - gameSpeed);
  if (movingFon.getLayoutX()<-1280)
   {
    movingFon.setLayoutX(1280);
   }
 }



 public void moveFon2()
 {
  movingFon2.setLayoutX(movingFon2.getLayoutX() - gameSpeed);
  if (movingFon2.getLayoutX()<-1280)
   {
    movingFon2.setLayoutX(1280);
   }
 }



 public void moveGround()
 {
  ground.setLayoutX(ground.getLayoutX() - gameSpeed);
  if (ground.getLayoutX()<-1280)
  {
    ground.setLayoutX(1280); 
  }
 }



 public void moveGround2()
 {
  ground2.setLayoutX(ground2.getLayoutX() - gameSpeed);
  if (ground2.getLayoutX()<-1280)
   {
    ground2.setLayoutX(1280);
   }
 }


public void stopGame()
{
  if (bird.getBoundsInParent().intersects(ground.getBoundsInParent())||bird.getBoundsInParent().intersects(ground2.getBoundsInParent())||bird.getBoundsInParent().intersects(tube.getBoundsInParent())
  ||bird.getBoundsInParent().intersects(tube2.getBoundsInParent())||bird.getBoundsInParent().intersects(tube3.getBoundsInParent())||bird.getBoundsInParent().intersects(tube4.getBoundsInParent())) {
   button.setVisible(true);
   gameLoop.stopGame(); 
   
  }

}
public void startGame()
{
  setBird();
  setTubes();
  gameLoop.startGame(); 
  scores=0;
button.setVisible(false);
}

public void scores()  
{
  String score = Integer.toString(scores);
  text.setText(score);
  if(bird.getLayoutX()>tube.getLayoutX()-(gameSpeed/2)&&bird.getLayoutX()<tube.getLayoutX()+(gameSpeed/2)
  ||bird.getLayoutX()>tube3.getLayoutX()-(gameSpeed/2)&&bird.getLayoutX()<tube3.getLayoutX()+(gameSpeed/2))
  {
scores++;
  }


}


}