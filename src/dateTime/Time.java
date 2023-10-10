package dateTime;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Time{
	Scanner scan = new Scanner(System.in);
	String userInput = "";
	boolean checker = false;

	LocalTime time = LocalTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

	public LocalTime getTime() {
		return time;
	}

	public void setTime() {
		
		checker = false;
		
		while(!checker) {
			System.out.println("\nEnter the time in format HH:mm");
			userInput = scan.nextLine();
			try {
				this.time = LocalTime.parse(userInput, formatter);
				checker = true;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
}
