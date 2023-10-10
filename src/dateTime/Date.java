package dateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {
	Scanner scan = new Scanner(System.in);
	String userInput = "";
	boolean checker = false;

	LocalDate date = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public LocalDate getDate() {
		return date;
	}

	public void setDate() {
		checker = false;

		while (!checker) {
			System.out.println("\nEnter the time in format yyyy-MM-dd");
			userInput = scan.nextLine();
			try {
				this.date = LocalDate.parse(userInput, formatter);
				checker = true;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
