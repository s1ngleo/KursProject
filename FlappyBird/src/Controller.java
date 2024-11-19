import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
public class Controller {
  private FlappyBird gameLoop;


   @FXML
   Button startSoloButton;

   @FXML
   Button startDuoButton;

   @FXML
   Button flappyExplorerutton;

   @FXML
   Text text;

   @FXML
   Text twoWon;

   @FXML
   Text oneWon;

   @FXML
   ImageView bird;

   @FXML
   ImageView bird2;

   @FXML
   ImageView birdSolo;

   @FXML
   ImageView mainTube;

   @FXML
   ImageView mainCoTube;

   @FXML
   ImageView mainTube2;

   @FXML
   ImageView mainCoTube2;

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
   int jumpItterator2 = 1;
   int jumpItteratorSolo = 1;
   double gameSpeed = 8;
   double birdFallSpeed = 8;
   double tubeSpace = 1180;
   double jumpHeight = 24;
   boolean jumpAnimWorks = false;
   boolean jumpAnimWorks2 = false;
   boolean jumpAnimWorksSolo = false;
   boolean isSolo;

   
   public void setGameLoop(FlappyBird gameloop)
   {
    this.gameLoop=gameloop;
   }

   public void setGame()
   {
    setBird();
    setTubes();
   }

   public void buttonsVisible(boolean isVisible)
   {
     startDuoButton.setVisible(isVisible);
     startDuoButton.setDisable(!isVisible);
     startSoloButton.setVisible(isVisible);
     startSoloButton.setDisable(!isVisible);
     startSoloButton.setVisible(isVisible);
     startSoloButton.setDisable(!isVisible);
     flappyExplorerutton.setVisible(isVisible);
     flappyExplorerutton.setDisable(!isVisible);

    
   }

public void setBird()
{
  bird.setLayoutX(211);
  bird.setLayoutY(400);
  
  bird2.setLayoutX(211);
  bird2.setLayoutY(200);
  birdSolo.setLayoutX(211);
  birdSolo.setLayoutY(200);
}

public void setTubes()
{
  mainTube.setLayoutX(1294);
  mainTube2.setLayoutX(2020); 
}

public void jump() {
 
    if (bird.getLayoutY() > 100) {
      jumpAnimWorks = true;
    }
    else if (birdSolo.getLayoutY() > 100) {
      jumpAnimWorks = true;
    }
}

public void jump2() {
 
  if (bird2.getLayoutY() > 100) {
    jumpAnimWorks2 = true;
  }
}

public void jumpTimer()
{ 
  
  if (jumpAnimWorks==true)
  {
    jumpItterator+=1;

    bird.setLayoutY(bird.getLayoutY()-jumpHeight);
    birdSolo.setLayoutY(birdSolo.getLayoutY()-jumpHeight);
    if(jumpItterator>7)

    {
      jumpAnimWorks = false;
      jumpItterator=1;
    }

}
}


public void jumpTimer2()
{ 
  
  if (jumpAnimWorks2==true)
  {
    jumpItterator2+=1;

    bird2.setLayoutY(bird2.getLayoutY()-jumpHeight);

    if(jumpItterator2>7)

    {
      jumpAnimWorks2 = false;
      jumpItterator2=1;
    }

}
}



 public void birdFalling()
 {
   bird.setLayoutY(bird.getLayoutY()+birdFallSpeed);
   bird2.setLayoutY(bird2.getLayoutY()+birdFallSpeed);
   birdSolo.setLayoutY(birdSolo.getLayoutY()+birdFallSpeed);
 }




 public void moveTube()
  {
  mainTube.setLayoutX(mainTube.getLayoutX() - gameSpeed);  
  mainCoTube.setLayoutX(mainTube.getLayoutX());
  mainCoTube.setLayoutY(mainTube.getLayoutY()-tubeSpace);
  if (mainTube.getLayoutX()<-162)
    {
    mainTube.setLayoutX(1272);
    mainTube.setLayoutY(randomNum.nextInt(maxRandNum - minRandNum + 1) + minRandNum);
    }
  }

  public void moveTube2()
  {
   mainTube2.setLayoutX(mainTube2.getLayoutX() - gameSpeed);  
   mainCoTube2.setLayoutX(mainTube2.getLayoutX());
   mainCoTube2.setLayoutY(mainTube2.getLayoutY()-tubeSpace);
   if (mainTube2.getLayoutX()<-162)
    {
     mainTube2.setLayoutX(1272);
     mainTube2.setLayoutY(randomNum.nextInt(maxRandNum - minRandNum + 1) + minRandNum);
     
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
{if(!isSolo){
  if (bird.getBoundsInParent().intersects(ground.getBoundsInParent())||
     bird.getBoundsInParent().intersects(ground2.getBoundsInParent())||
    bird.getBoundsInParent().intersects(mainTube.getBoundsInParent())||
  bird.getBoundsInParent().intersects(mainCoTube.getBoundsInParent())||
   bird.getBoundsInParent().intersects(mainTube2.getBoundsInParent())||
   bird.getBoundsInParent().intersects(mainCoTube2.getBoundsInParent())) 
  
   {
    buttonsVisible(true);
    gameLoop.stopGame(); 
    twoWon.setVisible(true);
  }
}
}

public void stopGame2()
{
  if (!isSolo)
  {
  if (bird2.getBoundsInParent().intersects(ground.getBoundsInParent())||
     bird2.getBoundsInParent().intersects(ground2.getBoundsInParent())||
    bird2.getBoundsInParent().intersects(mainTube.getBoundsInParent())||
  bird2.getBoundsInParent().intersects(mainCoTube.getBoundsInParent())||
   bird2.getBoundsInParent().intersects(mainTube2.getBoundsInParent())||
   bird2.getBoundsInParent().intersects(mainCoTube2.getBoundsInParent())&&isSolo==false) 
   {


   buttonsVisible(true);
   gameLoop.stopGame(); 
   oneWon.setVisible(true);
  }
}
}


public void stopGameSolo()
{ if(isSolo)
  {
  if (birdSolo.getBoundsInParent().intersects(ground.getBoundsInParent())||
     birdSolo.getBoundsInParent().intersects(ground2.getBoundsInParent())||
    birdSolo.getBoundsInParent().intersects(mainTube.getBoundsInParent())||
  birdSolo.getBoundsInParent().intersects(mainCoTube.getBoundsInParent())||
   birdSolo.getBoundsInParent().intersects(mainTube2.getBoundsInParent())||
   birdSolo.getBoundsInParent().intersects(mainCoTube2.getBoundsInParent())) 
   {

    buttonsVisible(true);

   gameLoop.stopGame(); 
   
  }
}
}
public void soloVisible()
{
  bird.setVisible(false);
  bird2.setVisible(false);
  birdSolo.setVisible(true);
}

public void startGame()
{
  isSolo=true;
  tubeSpace = 1080;
  oneWon.setVisible(false);
  twoWon.setVisible(false);
  soloVisible();
  gameLoop.startGame();




buttonsVisible(false);
  setBird();

  setTubes();
 
  scores=0;



}



public void startDuoGame()
{
  tubeSpace = 1180;
  oneWon.setVisible(false);
  twoWon.setVisible(false);
  isSolo=false;
  gameLoop.startGame();

bird.setVisible(true);
bird2.setVisible(true);
birdSolo.setVisible(false);
buttonsVisible(false);
setGame();

  
  scores=0;



}

public void scores()  
{
  String score = Integer.toString(scores);
  text.setText(score);
  if(bird.getLayoutX()>mainTube.getLayoutX()-(gameSpeed/2)&&bird.getLayoutX()<mainTube.getLayoutX()+(gameSpeed/2)
  ||bird.getLayoutX()>mainTube2.getLayoutX()-(gameSpeed/2)&&bird.getLayoutX()<mainTube2.getLayoutX()+(gameSpeed/2))
  {
scores++;
  }


}


public void startExp()
{
FlappyExplorer.main(null);
}






}