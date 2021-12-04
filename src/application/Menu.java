package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DragonDao;
import entity.Dragon;

public class Menu {
	
	private DragonDao dragonDao = new DragonDao();
	private Scanner userInput = new Scanner(System.in);
	private List<String> menuOptions = Arrays.asList("Show all dragons", "Search for a dragon","Add a dragon", "Update a dragon", "Remove a dragon");
	
	private void printMenu() {
		System.out.println("Select an Option:\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\nEnter 'exit' to quit");
		for (int i = 0; i < menuOptions.size(); i++) {
			System.out.println((i+1) + ") " + menuOptions.get(i));
		}
	}
		
	public void start() throws SQLException {
		String userSelection = "";
		
		do {
			printMenu();
			userSelection = userInput.nextLine();
			
			if (userSelection.equals("1")) {
				displayAll();
			}else if (userSelection.equals("2")) {
				displayDragon();
			}else if (userSelection.equals("3")) {
				addDragon();
			}else if (userSelection.equals("4")) {
				System.out.println("Enter a dragon to update:\n");
				String inputName = userInput.nextLine();
				System.out.println("\nNow editing " + inputName + ". Please input data below. \nTo leave a value unchange, press Enter when prompted to skip updating.");
				
				//Editing Name
				System.out.println("Enter a new name for " + inputName + ":");
				String newName = userInput.nextLine();
				if (!newName.isEmpty()) {
					updateDragonName(inputName, newName);
					System.out.println(inputName + " will now be known as " + newName + ".");
				}else {
					System.out.println(inputName + "'s name will not be changed.");
				}
				
				//Editing Color
				System.out.println("Enter a new color for " + inputName + ":");
				String newColor = userInput.nextLine();
				if (!newColor.isEmpty()) {
					updateDragonColor(inputName, newColor);
					System.out.println(inputName + " will now be known as a " + newColor + " dragon.");
				}else {
					System.out.println(inputName + "'s color will not be changed.");
				}
				
				//Editing Size
				System.out.println("Enter a new size for " + inputName + ":");
				String newSize = userInput.nextLine();
				if (!newSize.isEmpty()) {
					updateDragonSize(inputName, newSize);
					System.out.println(inputName + " will now be known as a " + newSize + " dragon.");
				}else {
					System.out.println(inputName + "'s size will not be changed.");
				}
				
				//Editing Age
				System.out.println("Enter a new age for " + inputName + ":");
				String capture = userInput.nextLine();
				//int newAge = Integer.parseInt(userInput.nextLine());
				//String check = Integer.toString(newAge);
				if (!capture.isEmpty()) {
					int newAge = Integer.parseInt(capture);
					updateDragonAge(inputName, newAge);
					System.out.println(inputName + " will now be know to be " + newAge + " years old.");
				}else {
					System.out.println(inputName + "'s age will not be changed.");
				}
			}else if (userSelection.equals("5")) {
				removeDragon();
			}
			System.out.println("Press Enter to Continue");
			userInput.nextLine();
		}while (!userSelection.equals("exit"));
	}
	
	private void displayAll() throws SQLException{
		List<Dragon> allDragons = dragonDao.displayAll();
		
		for (Dragon dragon : allDragons) {
			System.out.println(dragon.getName() + ", a " + dragon.getColor() + " colored dragon of " + dragon.getSize() + " size. Age: " + dragon.getAge());
		}
	}
	
	private void displayDragon() throws SQLException {
		System.out.println("Enter a name to search for: ");
		String name = userInput.nextLine();
		Dragon result = dragonDao.displayDragon(name);
		System.out.println(result.getName() + " is a " + result.getColor() + " colored dragon. Its size is " + result.getSize() + ". It is " + result.getAge() + " years old.");
	}

	private void addDragon() throws SQLException {
		System.out.print("Enter Dragon Name: ");
		String name = userInput.nextLine();
		System.out.print("Enter Dragon Color: ");
		String color = userInput.nextLine();
		System.out.print("Enter Dragon Size: ");
		String size = userInput.nextLine();
		System.out.print("Enter Dragon Age: ");
		int age = Integer.parseInt(userInput.nextLine());
		dragonDao.addDragon(name, color, size, age);
	}
	
	private void removeDragon() throws SQLException {
		System.out.println("Enter the name of a dragon to remove: ");
		String name = userInput.nextLine();
		dragonDao.removeDragon(name);
	}
	
	
	private void updateDragonName(String inputName, String updateName) throws SQLException {
		dragonDao.updateDragonName(inputName, updateName);
	}
	
	private void updateDragonColor(String inputName, String updateColor) throws SQLException {
		dragonDao.updateDragonColor(inputName, updateColor);
	}
	
	private void updateDragonSize(String inputName, String updateSize) throws SQLException {
		dragonDao.updateDragonSize(inputName, updateSize);
	}
	
	private void updateDragonAge(String inputName, int updateAge) throws SQLException {
		dragonDao.updateDragonAge(inputName, updateAge);
	}

}