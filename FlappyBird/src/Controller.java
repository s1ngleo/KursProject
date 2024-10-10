import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;

public class Controller {
   @FXML
   ImageView birdPNG;

  
  public void jump()
 {

   birdPNG.setLayoutY(birdPNG.getLayoutY()-50);
    
 }
 public void falling()
 {
  
   birdPNG.setLayoutY(birdPNG.getLayoutY()+1);


    
 }




}
