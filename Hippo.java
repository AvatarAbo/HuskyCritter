// Albert Lin
// 12/1/2018
// CSE 142
// TA: Trey Tamaki
// Assignment #9: Critters
//
// Hippo contains all the code that was in the Critter java file.
// Hippo will move 5 spaces in a random direction and repeat this cycle.
// Hippo takes a hunger parameter, and Hippo will appear as the number 
// that was given as the value of hunger. Hippo's hunger will decrement 
// by 1 every time Hippo eats. Once hunger reaches 0, hippo will turn from gray to white
// and will attack with pounce instead of scratch.

import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
   private int hunger;
   private Random rand;
   private int direction;
   private int count;
   
   // If hunger is greater than 0, hippo will eat if prompted. Every time
   // hippo eats, hunger decrements by 1. When hunger is 0, hippo will 
   // no longer eat.
   public boolean eat() {
      if (hunger > 0) {
         hunger--;
         return true;
      }
      return false;
   }
   
   // The hunger parameter is saved to the hunger variable.
   public Hippo(int hunger) {
      this.hunger = hunger;
      rand = new Random();      
      count = 0;
   } 
   
	// When hippo is hungry, it will scratch. Otherwise, hippo will pounce.
	public Attack fight(String opponent) {
      if (hunger > 0) {
		   return Attack.SCRATCH;
      }
      return Attack.POUNCE;
	}

	// When hippo is hungry, it will be gray. Otherwise, it will be white.
	public Color getColor() {
      if (hunger > 0) {
		   return Color.GRAY;
      }
      return Color.WHITE;
	}

	// Hippo will be represented by the number of the hungry parameter.
	public String toString() {
		return "" + hunger;
	}
      
   // Hippo will move 5 spaces in a random direction, then repeats.
   public Direction getMove() {
      Direction dir = null;
      if (count == 5) {
         count = 0;
         direction = rand.nextInt(4);
      }
      
      count++;
      if (direction == 0) {
         dir = Direction.NORTH;
      } else if (direction == 1) {
         dir = Direction.EAST;
      } else if (direction == 2) {
         dir = Direction.SOUTH;
      } else if (direction == 3) {
         dir = Direction.WEST;
      }
      return dir;
   }
}