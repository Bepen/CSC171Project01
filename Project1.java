/* Bepen Neupane
 * NetID: bneupane
 * Project 1
 * TR 11:05 - 12:20
 * TA Patrick Ferner
 * I did not collaborate with anyone on this assignment.
 */

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Project1 {

	public static void main(String[] args) {

			Scanner scan = new Scanner(System.in); //initializing scanner
			Random random = new Random(); //initializing random
			double height; //the height will be random
			double distance; //the distance will be random
			int points = 0; //the user starts off with 0 points and it changes depending on the success of the launch
			double launch; //this is where the formula will be calculated
			double angle; //this will be the user input for angle
			double mps; //this will be the user input for meters per second
			double rAngle; //this converts the angle to radians
			int endStatement; //the end statement is assigned a random number which then picks a random switch statement
			String playAgain = "yes"; //in order to start off the program, I set playAgain to yes but the user can type in no which will stop the program
			System.out.println("Hello, welcome to TTY Projectiles."); //introducing the game
		while(playAgain.equals("yes") || playAgain.equals("Yes")) { //while the user responds yes or Yes to the scanner on line 36, this while loop will continue
			height = random.nextInt(95) + 5; //the height of the wall will be a random number from 5-100.
			distance = random.nextInt(95) + 5; ////the height of the wall will be a random number from 5-100.
				System.out.println("The wall is " + height + " meters high and it is " + distance + " meters away from the catapult."); //this lets the user know how tall the wall is and how far it is from the catapult
				System.out.print("What angle would you like the catapult to be? ");
			angle = scan.nextDouble(); //user inputs angle for the catapult
				System.out.print("In meters per second, how fast do you want the projectile to go? ");
				mps = scan.nextDouble(); //user inputs the speed at which the projectile to launch
				rAngle = Math.toRadians(angle); //the angle that the user inputs will be converted to radians in order to allow line 30 to properly function
				launch = (distance * Math.tan(rAngle)) - ((9.8 * distance * distance) / (2 * (mps * Math.cos(rAngle)) * (mps * Math.cos(rAngle)))); //this is the formula for the launch
		
				if (launch >= (height + 4)) { //if the user cleared the wall by 4 or more, this if statement will run
					System.out.println("You made it with plently of room!");
						points += 2; //user gains two points
						System.out.print("You have " + points + " points. Would you like to play again? (yes or no) ");
						playAgain = scan.next(); //if the user types yes, the while loop from line 20 will run again, if not then the code will start running from line 58
				}
				else if(launch >= height) { //if the user cleared the wall by three or less, this statement will run
					System.out.println("You barely made it over the wall... but you still made it!");
					points += 4; //user gains four points
						System.out.print("You have " + points + " points. Would you like to play again? (yes or no) ");
						playAgain = scan.next(); //if the user types yes, the while loop from line 20 will run again, if not then the code will start running from line 58
				}
				else if(launch + 3 >= height) { //if the user did not clear the wall but was close by three or less, this statement will run
					System.out.println("You did not quite make it over. You were close, you should try again.");
					points -= 1 ; //user loses one point
						System.out.print("You have " + points + " points. Would you like to play again? (yes or no) ");
						playAgain = scan.next(); //if the user types yes, the while loop from line 20 will run again, if not then the code will start running from line 58
				}
				else { //if the user did not clear the wall by more than three, this statement will run
					System.out.println("Oh boy, that wasn't even close. You definitely have to redeem yourself next round. ");
					points -= 3 ; //user loses three points
						System.out.print("You have " + points + " points. Would you like to play again? (yes or no) ");
						playAgain = scan.next(); //if the user types yes, the while loop from line 20 will run again, if not then the code will start running from line 58
				}
		
			}
			endStatement = random.nextInt(3) + 1; //this generates a random number and depending on the number,
			switch(endStatement) {				  //it will choose a random case in the switch statement which means that a random string will print
			case 1: 
				System.out.println("You ended the game with " + points + " points.");
				break; //ends the program after displaying the points the user had in total
			case 2: 
				System.out.println("Sad to see you leave. You ended with " + points + " points.");
				break; //ends the program after displaying the points the user had in total
			case 3: 
				System.out.println("I'm happy you're done playing. I can't take it anymore! You got " + points + " points.");
				break; //ends the program after displaying the points the user had in total
			case 4: 
				System.out.println("Game has ended. Points: " + points);
				break; //ends the program after displaying the points the user had in total
			}
		scan.close(); //closes scanner
			
		}

}