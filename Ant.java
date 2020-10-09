// Albert Lin
// 12/1/2018
// CSE 142
// TA: Trey Tamaki
// Assignment #9: Critters
//
// Ant contains all the code that was in the Critter java file. 
// The ant is a basic animal. It always eats, always attacks with scratch, is red,
// and moves in either a northeast direction or southeast direction.

import java.awt.*;

public class Ant extends Critter {
   private int zigZag;
   private boolean walkSouth;
   
   // Ant always eats.
   public boolean eat() {
      return true;
   }
   
	// Ant always scratches.
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}

	// Ant is the color red.
	public Color getColor() {
		return Color.RED;
	}

	// Ant is represented by "%"
	public String toString() {
		return "%";
	}
   
   // If walkSouth is true, then the ant moves in a southeast direction, 
   // otherwise, a northeast direction.
   public Ant(boolean walkSouth) {
      this.walkSouth = walkSouth;
   }
   
   // Ant will alternate between north/south and east when it moves.
   public Direction getMove() {
      zigZag++;
      if (walkSouth == true) {
         if (zigZag % 2 == 0) {
            return Direction.EAST;
         } else {
            return Direction.SOUTH;
         }
      } else {
         if (zigZag % 2 == 0) {
            return Direction.EAST;
         } else {
            return Direction.NORTH;
         }
      }
   }
}