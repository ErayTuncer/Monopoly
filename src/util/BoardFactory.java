package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import element.*;

public class BoardFactory {
	
	private static final String LAND_START = "Start";
	private static final String LAND_GOJAIL = "GoJail";
	private static final String LAND_JAIL = "Jail";
	private static final String LAND_FREEPARKING = "FreeParking";
	private static final String LAND_PAYTAX = "PayTax";
	private static final String LAND_CHANCE = "Chance";
	private static final String LAND_COMMUNITYCHEST = "CommunityChest";

	public static Board readBoard(File file) {
		Board board = new Board();
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String landData = scanner.nextLine();
				if (!landData.isEmpty()) {
					addLand(board, landData);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File : " + file.getAbsolutePath() + " NOT FOUND!");
		}
		
		
		return board;
	}

	private static void addLand(Board board, String landData) {
		String landType = getLandType(landData);
		
		if (landType.equals(LAND_START)) {
			board.lands.add(new Start());
		} else if (landType.equals(LAND_GOJAIL)) {
			board.lands.add(new GoJail());
		} else if (landType.equals(LAND_JAIL)) {
			board.lands.add(new Jail());
		} else if (landType.equals(LAND_FREEPARKING)) {
			board.lands.add(new FreeParking());
		} else if (landType.equals(LAND_PAYTAX)) {
			board.lands.add(new PayTax());
		} else if (landType.equals(LAND_CHANCE)) {
			board.lands.add(new Chance());
		} else if (landType.equals(LAND_COMMUNITYCHEST)) {
			board.lands.add(new CommunityChest());
		} else {
			throw new RuntimeException("There is no land type named : " + landType);
		}
		
	}

	private static String getLandType(String landData) {
		return getValueAt(landData, 1);
	}
	
	// Modified (http://stackoverflow.com/questions/14584018/how-can-i-get-inside-parentheses-value-in-a-string)
	private static String getValueAt(String landData, int index) {
		return landData.split("[\\<\\>]")[index];
	}

}
