import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.util.Random;


public class Controller {
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
   int min = 306;
   int max = 716;
   

double gameSpeed = 5;
double birdFallSpeed = 4;
double tubeSpace = 1070;


   public void jump() 
   {
if (bird.getLayoutY()>100)
{
        bird.setLayoutY(bird.getLayoutY() - 150);
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
    tube.setLayoutY(randomNum.nextInt(max - min + 1) + min);
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
     tube3.setLayoutY(randomNum.nextInt(max - min + 1) + min);
     
   }
 




 }


 

 public void moveFon()
 {
  movingFon.setLayoutX(movingFon.getLayoutX() - gameSpeed);
  if (movingFon.getLayoutX()==-1280)
  {
    movingFon.setLayoutX(1280);
   
  }
 }



 public void moveFon2()
 {
  movingFon2.setLayoutX(movingFon2.getLayoutX() - gameSpeed);
  if (movingFon2.getLayoutX()==-1280)
  {
    movingFon2.setLayoutX(1280);
  }
 }




 public void moveGround()
 {
  ground.setLayoutX(ground.getLayoutX() - gameSpeed);
  if (ground.getLayoutX()==-1280)
  {
    ground.setLayoutX(1280);
   
  }
 }





 public void moveGround2()
 {
  ground2.setLayoutX(ground2.getLayoutX() - gameSpeed);
  if (ground2.getLayoutX()==-1280)
  {
    ground2.setLayoutX(1280);
  }
 }

public void gamestatus()
{
  if (bird.getBoundsInParent().intersects(ground.getBoundsInParent())||bird.getBoundsInParent().intersects(ground2.getBoundsInParent())||bird.getBoundsInParent().intersects(tube.getBoundsInParent())
  ||bird.getBoundsInParent().intersects(tube2.getBoundsInParent())||bird.getBoundsInParent().intersects(tube3.getBoundsInParent())||bird.getBoundsInParent().intersects(tube4.getBoundsInParent())) {
   // Platform.exit();
    System.exit(1);
  }

}





}
