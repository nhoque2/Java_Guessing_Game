package ExtraCredit;

import java.util.Scanner;

public class NumberGuessingGame {
	public static void main(String[] args) {		
		System.out.println("Welcome to the number Guessing Game!");
			System.out.println("I can guess any random number between 1 and 100 in 7 tries or less");//max number of tries is calculated by log2(100) which rounds up to 7
			Scanner input=new Scanner(System.in);
			System.out.print("Enter a number between 1 and 100: ");
			int n = input.nextInt();
			incorrectInput(n, input);
			binarySearch();
			
		}
		public static void incorrectInput(int n, Scanner input) {
			if(n>100 || n<1) {	
				System.out.print("You have picked an invalid number, please choose again: ");
				n=input.nextInt();
				incorrectInput(n, input); //recursion is used to re-check if entered number is valid 
			}
		}
		public static void incorrectInput1(String s, Scanner input1) { 
			if(!s.equals("b") && !s.equals("s") && !s.equals("e")) {
				System.out.print("Please enter 's','b', or 'e': "); 
				s=input1.next(); 
				incorrectInput1(s, input1); //recursion is used to re-check if entered input is valid
				} 
			}
		
		public static void binarySearch() {//modified version of binary search that searches #'s from 1-100
			int low=1;
			int high=100;
			boolean stopGame=false;
			int finalNum=0;
			int tries=0;
			System.out.println("I will ask you if your number is smaller, bigger, or equal to a certain number");
			System.out.println("Enter 'b' for bigger, 's' for smaller, or 'e' for equal");
			while(stopGame==false) {//loop will stop when user enters equal
				Scanner input1=new Scanner(System.in);
				int mid=(low+high)/2;
				System.out.println("Is your number smaller, bigger, or equal to "+mid+"?");
				String s=input1.next();
				incorrectInput1(s, input1);
				if(s.equals("b")) {
					low=mid+1;
				}
				else if(s.equals("s")) {
					high=mid-1;
				}
				else if(s.equals("e")) {
					stopGame=true;
				}

				finalNum=mid;
				tries++;
			}
			System.out.println("You number is: "+finalNum+"!");
			System.out.println("Number of tries: "+tries);
			
		}

}
