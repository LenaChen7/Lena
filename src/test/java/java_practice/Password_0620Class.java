package java_practice;

import java.util.Iterator;
import java.util.Scanner;

public class Password_0620Class {

	public static void main(String[] args) {

//		Ask users to create a 6 digit password, if the password does not meet the required length, 
//      then give them 2 more times to try, on the third try if the password is still invalid, give them an error message. otherwise print successful
//		==> loop
//		==> if
//		==> scanner
//		==> .length()
//		==> .trim()
//		==> Asking for the password 1 time only
//		==> Challenge: 3 tries
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a 6 digit password.");
		System.out.println("password can be numbers, letters or special Characters");

		for (int tries = 0; tries <= 3; tries++) {
			String password = scan.nextLine().trim();
			if (password.length() == 6) {
				System.out.println("good password");
				break;
			} else {
				if (tries == 3) {
					System.out.println("f$@%$#$!");
				} else {
					System.out.println("please try it again: ");
				}
			}
		}

		scan.close();

	}

}
