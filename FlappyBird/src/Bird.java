public class Bird {

    double height;
    double fallSpeed;

   public Bird ()
    {
     this.height = 0 ;
     this.fallSpeed = 1;
    }

    public void jump (double heightChange)
    {
       Bird.this.height = height+=heightChange;
    }
    public void falling ()
    {
       Bird.this.height = height-=fallSpeed;
    }

}

