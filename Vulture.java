// Albert Lin
// 12/1/2018
// CSE 142
// TA: Trey Tamaki
// Assignment #9: Critters
//
// Vulture is a type of bird so it contains the attributes 
// of the bird. It overrides the bird's eat. The vulture eats, then is full
// until it gets into a fight, then it can eat again. This process repeats.

import java.awt.*;

public class Vulture extends Bird {
   private boolean hungry;

   // Vulture is initially hungry.
   public Vulture() {
      hungry = true;
   }

	// Vulture is the color black. It overrides bird's blue color.
	public Color getColor() {
		return Color.BLACK;
	}
   
   // After eating, the vulture is full and will not eat until it fights.
   public boolean eat() {
      if (hungry) {
         hungry = false;
         return true;
      } else {
         return false;
      }
   }
   
   // When it fights, vulture is once again hungry.
	public Attack fight(String opponent) {
      hungry = true;
      if (opponent.equals("%")) {
		   return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
	}    
}