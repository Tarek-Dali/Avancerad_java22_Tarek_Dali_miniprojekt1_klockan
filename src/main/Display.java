package main;


import java.util.Scanner;

import dateTime.Date;
import dateTime.Time;
import interfaces.InterfaceDisplay;

public class Display implements InterfaceDisplay{
	
	STATE current_state = STATE.ShowTime;
	
	Time time = new Time();
	Date date = new Date();
	
	
	enum STATE{
		ShowTime,
		ShowDate,
		ChangeTime,
		ChangeDate
	}
	
	
	
	@Override
	public void showTime() {
		if (current_state == STATE.ShowDate || current_state == STATE.ChangeTime) {
			current_state = STATE.ShowTime;
			System.out.println("You are now in " + current_state);
			System.out.println(time.getTime());
		} else {
			System.out.println("Navigation: ChangeTime<-->ShowTime<-->ShowDate<-->ChangeDate");
			System.out.println("You are now in " + current_state);
		}
		
	}

	@Override
	public void showDate() {
		if (current_state == STATE.ShowTime || current_state == STATE.ChangeDate) {
			current_state = STATE.ShowDate;
			System.out.println("You are now in " + current_state);
			System.out.println(date.getDate());
		} else {
			System.out.println("Navigation: ChangeTime<-->ShowTime<-->ShowDate<-->ChangeDate");
			System.out.println("You are now in " + current_state);
		}
	}
	

	@Override
	public void changeTime() {
		if (current_state == STATE.ShowTime) {
			current_state = STATE.ChangeTime;
			System.out.println("You are now in " + current_state);
			time.setTime();
		} else {
			System.out.println("Navigation: ChangeTime<-->ShowTime<-->ShowDate<-->ChangeDate");
			System.out.println("You are now in " + current_state);
		}
		
	}

	@Override
	public void changeDate() {
		if (current_state == STATE.ShowDate) {
			current_state = STATE.ChangeDate;
			System.out.println("You are now in " + current_state);
			date.setDate();
		} else {
			System.out.println("Navigation: ChangeTime<-->ShowTime<-->ShowDate<-->ChangeDate");
			System.out.println("You are now in " + current_state);
		}
		
	}
	
	
	public void mainLoop() {
		Scanner scan = new Scanner(System.in);
		String userInput = "";
		
		System.out.println("You are now in ShowTime ");
		System.out.println(time.getTime());
		while(!userInput.equals("q")) {
			System.out.println("\n1. ShowTime"
					+ "\n2. ShowDate"
					+ "\n3. ChangeTime"
					+ "\n4. ChangeDate"
					+ "\nq. Exit");
			
			userInput = scan.nextLine().trim();
			
			switch(userInput){
			case "1":
					showTime();
				break;
				
			case "2":
				showDate();
				break;
				
			case "3":
				changeTime();
				break;
				
			case "4":
				changeDate();
				break;
			}
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		
		Display method = new Display();
		method.mainLoop();
		
	}

}
