// Albert Lin
// 12/1/2018
// CSE 142
// TA: Trey Tamaki
// Assignment #9: Critters
//
// Bird contains all the code that was in the Critter java file. 
// The eat method for Bird is the default in Critter. Bird will move 
// in a square path, going 3 steps in one direction and rotating clockwise
// and repeating the steps. Bird will roar when it encounters a '%'.
// Otherwise, it pounces.

import java.awt.*;

public class Bird extends Critter {
   private int direction;
   private int steps;
   public boolean firstMove;

   // The direction and steps in each direction 
   // are initalized at 0. The first move will always be North.
   public Bird() {
      direction = 0;
      steps = 0;
      firstMove = true;
   }
   
	// If the animal looks like an Ant, then Bird will roar. Otherwise, Bird will pounce.
	public Attack fight(String opponent) {
      if (opponent.equals("%")) {
		   return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
	}

	// Bird is the color blue.
	public Color getColor() {
		return Color.BLUE;
	}

	// Bird will "face" the direction it is going. For example, if 
   // Bird is moving upwards, the arrow is pointed up ^.
	public String toString() {
      if (direction == 0) {
		   return "^";
      } else if (direction == 1) {
         return ">";
      } else if (direction == 2) {
         return "V";
      } 
      return "<";
	}
   
   // Bird will take 3 steps in the same direction, then it will 
   // rotate clockwise and move 3 steps again in the next direction.
   // This will continuously happen.
   public Direction getMove() {
      if (firstMove) {
         firstMove = false;
         return Direction.NORTH;
      }
      Direction dir = Direction.NORTH;
      steps++;      
      if (steps % 3 == 0) {
         steps = 0;
         direction++;
      }

      if (direction == 0) {
         dir = Direction.NORTH;
      } else if (direction == 1) {
         dir = Direction.EAST;
      } else if (direction == 2) {
         dir = Direction.SOUTH;
      } else if (direction == 3) {
         dir = Direction.WEST;
      }
      
      if (direction == 4) {
         direction = 0;  
      }
      return dir;
   }
}