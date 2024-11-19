import java.nio.file.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class FlappyExplorer {
    public static void main(String[] args) {


 AtomicBoolean spacepressed = new AtomicBoolean(false);
        JFrame frame = new JFrame();
//сцена для кнопки

        frame.setUndecorated(true);
        frame.setOpacity(0f);  
        frame.setSize(1, 1);  
        frame.setLocation(-100, -100); 
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                   spacepressed.set(true);
                }
            }
        });

        Path source = Paths.get("1.png");
        Path tube = Paths.get("2.png");
        Path bird = Paths.get("3.png");
        int birdPos=22;
        int i = 1;

        try {
           //поставити фон
          
           
            for (; i < 161; i++) 
            {
             if(i!=82)
             {
                String newFileName = i + ".png";
                Path destination = Paths.get("Game/" + newFileName);
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
             }
            }

            try 
            {
                Thread.sleep(1000);
            } 
             catch (InterruptedException e) 
            {
                e.printStackTrace();
            }

        for(int f=1;f<10;f++)
        {
            //цикл з 20 позицій труб
            for(int j=20;j>0;j--)
        { 
             i=j;
                //ставимо перший ряд
                 for (; i <= 160; i+=20) 
                {
                    if(i<61||i>120)
                    {
                    String newFileName = i + ".png";
                    Path destination = Paths.get("Game/" + newFileName);
                    Files.copy(tube, destination, StandardCopyOption.REPLACE_EXISTING);
                    }

                }
            
               
                if(birdPos>10&&birdPos<143&&spacepressed.get()==false)
                {
                    Files.copy(bird, Paths.get("Game/" + birdPos+".png"), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(source, Paths.get("Game/" + (birdPos-20)+".png"), StandardCopyOption.REPLACE_EXISTING);
                    birdPos+=20;
                }
               
                if(birdPos>10&&birdPos<125&&spacepressed.get()==true)
                {
                    Files.copy(bird, Paths.get("Game/" + birdPos+".png"), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(source, Paths.get("Game/" + (birdPos+20)+".png"), StandardCopyOption.REPLACE_EXISTING);
                    birdPos-=20;
                }
                if(birdPos>160)
                {
                    
                  System.exit(0);
                }
                

                spacepressed.set(false);



                //чекаємо
             try 
            {
                Thread.sleep(500);
            } 
             catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            //стираємо цей перший ряд, і далі йдемо по циклу
                i=j;
                 for (; i < 161; i+=20) 
                {
                String newFileName = i + ".png";
                Path destination = Paths.get("Game/" + newFileName);
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                }
           
     
    
        }
        }} catch (Exception e) 
        {
            e.printStackTrace();
        }
      }
    }


