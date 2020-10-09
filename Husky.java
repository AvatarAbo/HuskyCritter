// CSE 142 Critters
// Authors: Marty Stepp and Stuart Reges
//
// The husky is the most boundless creature in all the universe-ities.
// My husky will destroy the competition. no cap.

import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   private Random rand;
   private int upDown;
   private int moves;
   private int mainSkin;
   private int specialAttack;
   private final int DELAY;
   private final int LEAP;
   private final int CHANGE_DIRECTION;
   private final int SKIN;
   
   public Husky() {
      DELAY = 75;
      LEAP = 6;
      CHANGE_DIRECTION = 300;
      SKIN = 60;
      mainSkin = 0;
      moves = 0;
      rand = new Random();
   }
   
   public Color getColor() {
      if (mainSkin % 10 < 5) {
         return Color.MAGENTA;
      }
      return Color.YELLOW;
   }
   
   public String toString() {
      mainSkin++;
      if (mainSkin == SKIN) {
         mainSkin = 0;
      }
      
      if ((!getNeighbor(Direction.WEST).equals("%") && !getNeighbor(Direction.EAST).equals("%") &&
      !getNeighbor(Direction.NORTH).equals("%") && !getNeighbor(Direction.SOUTH).equals("%")) && 
      (!getNeighbor(Direction.WEST).equals(" ") || !getNeighbor(Direction.EAST).equals(" ") ||
      !getNeighbor(Direction.NORTH).equals(" ") || !getNeighbor(Direction.SOUTH).equals(" "))) {
         return "%";
      }
      
      if (mainSkin < SKIN / 6) {
         return "They";
      } else if (mainSkin < SKIN / 3) {
         return "Did";
      } else if (mainSkin < SKIN / 2) {
         return "Surgery";
      } else if (mainSkin < SKIN * 2 / 3) {
         return "On";
      } else if (mainSkin < SKIN * 5 / 6) {
         return "A";
      }
      return "Grape";
      
      //return "%";
   }
   
   public boolean eat() {
      if (moves > DELAY) {
         return true;
      }
      return false;
   }

   // Husky always wins.
	public Attack fight(String opponent) {
      specialAttack = rand.nextInt(3);
   
      if (opponent.equals("%")) {
		   return Attack.ROAR;
      } 
      
      if (opponent.equals("V") || (opponent.equals("<")) || (opponent.equals(">")) || (opponent.equals("^"))) {
		  return Attack.POUNCE;
      }
      
      if (opponent.equals("1") || opponent.equals("2") || opponent.equals("3") || opponent.equals("4") ||
      opponent.equals("5") || opponent.equals("6") || opponent.equals("7") || opponent.equals("8") || opponent.equals("9")) {
         return Attack.ROAR;
      }
      
      if (opponent.equals("0")) {
         return Attack.SCRATCH;
      }
      
      if (opponent.equals("S")) {
         return Attack.POUNCE;
      }
      
      if ((!getNeighbor(Direction.WEST).equals("%") && !getNeighbor(Direction.EAST).equals("%") &&
      !getNeighbor(Direction.NORTH).equals("%") && !getNeighbor(Direction.SOUTH).equals("%")) && 
      (!getNeighbor(Direction.WEST).equals(" ") || !getNeighbor(Direction.EAST).equals(" ") ||
      !getNeighbor(Direction.NORTH).equals(" ") || !getNeighbor(Direction.SOUTH).equals(" "))) {
         return Attack.POUNCE;
      }
      //return Attack.POUNCE;
      
      if (specialAttack == 1) {
         return Attack.ROAR;
      } else if (specialAttack == 2) {
         return Attack.SCRATCH;
      }
      
      return Attack.POUNCE;
	}
   
   public Direction getMove() {
      if (moves % CHANGE_DIRECTION == 0) {
         upDown = rand.nextInt(4);
      }
      moves++;
      
      if /*(getNeighbor(Direction.WEST).equals(".") ||*/ (getNeighbor(Direction.WEST).equals("V") || 
      (getNeighbor(Direction.WEST).equals("^")) || (getNeighbor(Direction.WEST).equals("<")) || 
      (getNeighbor(Direction.WEST).equals(">")) || (getNeighbor(Direction.WEST).equals("S")) ||
      /*(getNeighbor(Direction.WEST).equals("%")) ||*/ (getNeighbor(Direction.WEST).equals("0")) ||
      (getNeighbor(Direction.WEST).equals("1")) || (getNeighbor(Direction.WEST).equals("2")) || 
      (getNeighbor(Direction.WEST).equals("3")) || (getNeighbor(Direction.WEST).equals("4")) || 
      (getNeighbor(Direction.WEST).equals("5")) || (getNeighbor(Direction.WEST).equals("6")) ||
      (getNeighbor(Direction.WEST).equals("7")) || (getNeighbor(Direction.WEST).equals("8")) ||
      (getNeighbor(Direction.WEST).equals("9"))) {
         return Direction.WEST;
      } else if /*(getNeighbor(Direction.EAST).equals(".") ||*/ (getNeighbor(Direction.EAST).equals("V") || 
      (getNeighbor(Direction.EAST).equals("^")) || (getNeighbor(Direction.EAST).equals("<")) || 
      (getNeighbor(Direction.EAST).equals(">")) || (getNeighbor(Direction.EAST).equals("S")) ||
      /*(getNeighbor(Direction.EAST).equals("%")) ||*/ (getNeighbor(Direction.EAST).equals("0")) ||
      (getNeighbor(Direction.EAST).equals("1")) || (getNeighbor(Direction.EAST).equals("2")) || 
      (getNeighbor(Direction.EAST).equals("3")) || (getNeighbor(Direction.EAST).equals("4")) || 
      (getNeighbor(Direction.EAST).equals("5")) || (getNeighbor(Direction.EAST).equals("6")) ||
      (getNeighbor(Direction.EAST).equals("7")) || (getNeighbor(Direction.EAST).equals("8")) ||
      (getNeighbor(Direction.EAST).equals("9")) //||
      // (getNeighbor(Direction.EAST).equals("They")) || (getNeighbor(Direction.EAST).equals("Did")) || 
      // (getNeighbor(Direction.EAST).equals("Surgery")) || (getNeighbor(Direction.EAST).equals("On")) ||
      // (getNeighbor(Direction.EAST).equals("A")) || (getNeighbor(Direction.EAST).equals("Grape"))
       ) {
         return Direction.EAST;
      } else if /*(getNeighbor(Direction.NORTH).equals(".") ||*/ (getNeighbor(Direction.NORTH).equals("V") || 
      (getNeighbor(Direction.NORTH).equals("^")) || (getNeighbor(Direction.NORTH).equals("<")) || 
      (getNeighbor(Direction.NORTH).equals(">")) || (getNeighbor(Direction.NORTH).equals("S")) ||
      /*(getNeighbor(Direction.NORTH).equals("%")) ||*/ (getNeighbor(Direction.NORTH).equals("0")) ||
      (getNeighbor(Direction.NORTH).equals("1")) || (getNeighbor(Direction.NORTH).equals("2")) || 
      (getNeighbor(Direction.NORTH).equals("3")) || (getNeighbor(Direction.NORTH).equals("4")) || 
      (getNeighbor(Direction.NORTH).equals("5")) || (getNeighbor(Direction.NORTH).equals("6")) ||
      (getNeighbor(Direction.NORTH).equals("7")) || (getNeighbor(Direction.NORTH).equals("8")) ||
      (getNeighbor(Direction.NORTH).equals("9")) //||
      // (getNeighbor(Direction.NORTH).equals("They")) || (getNeighbor(Direction.NORTH).equals("Did")) || 
      // (getNeighbor(Direction.NORTH).equals("Surgery")) || (getNeighbor(Direction.NORTH).equals("On")) ||
      // (getNeighbor(Direction.NORTH).equals("A")) || (getNeighbor(Direction.NORTH).equals("Grape"))
      ) {
         return Direction.NORTH;
      } else if /*(getNeighbor(Direction.SOUTH).equals(".") ||*/ (getNeighbor(Direction.SOUTH).equals("V") || 
      (getNeighbor(Direction.SOUTH).equals("^")) || (getNeighbor(Direction.SOUTH).equals("<")) || 
      (getNeighbor(Direction.SOUTH).equals(">")) || (getNeighbor(Direction.SOUTH).equals("S")) ||
      /*(getNeighbor(Direction.SOUTH).equals("%")) ||*/ (getNeighbor(Direction.SOUTH).equals("0")) ||
      (getNeighbor(Direction.SOUTH).equals("1")) || (getNeighbor(Direction.SOUTH).equals("2")) || 
      (getNeighbor(Direction.SOUTH).equals("3")) || (getNeighbor(Direction.SOUTH).equals("4")) || 
      (getNeighbor(Direction.SOUTH).equals("5")) || (getNeighbor(Direction.SOUTH).equals("6")) ||
      (getNeighbor(Direction.SOUTH).equals("7")) || (getNeighbor(Direction.SOUTH).equals("8")) ||
      (getNeighbor(Direction.SOUTH).equals("9")) //||
      // (getNeighbor(Direction.SOUTH).equals("They")) || (getNeighbor(Direction.SOUTH).equals("Did")) || 
      // (getNeighbor(Direction.SOUTH).equals("Surgery")) || (getNeighbor(Direction.SOUTH).equals("On")) ||
      // (getNeighbor(Direction.SOUTH).equals("A")) || (getNeighbor(Direction.SOUTH).equals("Grape"))
      ) {
         return Direction.SOUTH;
      }
      
      if (getNeighbor(Direction.WEST).equals(".") && moves > DELAY) {
         return Direction.WEST;
      } else if (getNeighbor(Direction.EAST).equals(".") && moves > DELAY) {
         return Direction.EAST;
      } else if (getNeighbor(Direction.NORTH).equals(".") && moves > DELAY) {
         return Direction.NORTH;
      } else if (getNeighbor(Direction.SOUTH).equals(".") && moves > DELAY) {
         return Direction.SOUTH;
      } 
      
      // main moving strategy.
      if (upDown == 0) {
         if (moves % CHANGE_DIRECTION != 0) {
            if (moves % LEAP > (LEAP / 2) - 1) {
               return Direction.NORTH;
            } else {
               return Direction.WEST;
            }
         }
      } else if (upDown == 1) {
         if (moves % CHANGE_DIRECTION != 0) {
            if (moves % LEAP > (LEAP / 2) - 1) {
               return Direction.SOUTH;
            } else {
               return Direction.EAST;
            }
         }
      } else if (upDown == 2) {
         if (moves % CHANGE_DIRECTION != 0) {
            if (moves % LEAP > (LEAP / 2) - 1) {
               return Direction.NORTH;
            } else {
               return Direction.EAST;
            }
         }
      }
      if (moves % CHANGE_DIRECTION != 0) {
         if (moves % LEAP > (LEAP / 2) - 1) {
            return Direction.SOUTH;
         } else {
            return Direction.WEST;
         }
      }
    return Direction.NORTH;
      
      
      
      
      // alternate moving strategy.
      // if (moves % 20 == 0) {
//          return Direction.SOUTH;
//       } else {
//          return Direction.WEST;
//       }      
   }
}