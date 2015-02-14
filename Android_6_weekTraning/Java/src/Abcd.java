
public class Abcd {
   private final String noise;
   protected Abcd(String noise) {
      this.noise = noise;
   }

   public void makeNoise() {
      System.out.println(noise);
   }
}

class Pig extends Abcd {
    public Pig() {
       super("Oink");
    }
}