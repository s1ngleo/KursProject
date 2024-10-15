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
   






   public void jump() 
   {
if (bird.getLayoutY()>100)
{
        bird.setLayoutY(bird.getLayoutY() - 100);
      }   
   }




 public void birdFalling()
 {
  
   bird.setLayoutY(bird.getLayoutY()+0.8);

 }




 public void moveTube()
 {
  tube.setLayoutX(tube.getLayoutX() - 0.5);  
  tube2.setLayoutX(tube.getLayoutX());
  tube2.setLayoutY(tube.getLayoutY()-1100);
  if (tube.getLayoutX()<-162)
  {
    tube.setLayoutX(1272);
    tube.setLayoutY(randomNum.nextInt(max - min + 1) + min);
    
  }




 }


 

 public void moveFon()
 {
  movingFon.setLayoutX(movingFon.getLayoutX() - 0.5);
  if (movingFon.getLayoutX()==-1280)
  {
    movingFon.setLayoutX(1280);
   
  }
 }



 public void moveFon2()
 {
  movingFon2.setLayoutX(movingFon2.getLayoutX() - 0.5);
  if (movingFon2.getLayoutX()==-1280)
  {
    movingFon2.setLayoutX(1280);
  }
 }




 public void moveGround()
 {
  ground.setLayoutX(ground.getLayoutX() - 0.5);
  if (ground.getLayoutX()==-1280)
  {
    ground.setLayoutX(1280);
   
  }
 }





 public void moveGround2()
 {
  ground2.setLayoutX(ground2.getLayoutX() - 0.5);
  if (ground2.getLayoutX()==-1280)
  {
    ground2.setLayoutX(1280);
  }
 }

public void gamestatus()
{
  if (bird.getBoundsInParent().intersects(ground.getBoundsInParent())||bird.getBoundsInParent().intersects(ground2.getBoundsInParent())||bird.getBoundsInParent().intersects(tube.getBoundsInParent())) {
   // Platform.exit();
    System.exit(1);
  }

}





}
