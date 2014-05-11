package util;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import element.*;

public class BoardFactory {
	
	private static final String LAND_START = "Start";
	private static final String LAND_GOJAIL = "GoJail";
	private static final String LAND_JAIL = "Jail";
	private static final String LAND_FREEPARKING = "FreeParking";
	private static final String LAND_PAYTAX = "PayTax";
	private static final String LAND_CHANCE = "Chance";
	private static final String LAND_COMMUNITYCHEST = "CommunityChest";

	private static final String LAND_COLOREDLAND = "ColoredLand";	
	
	public static Board readBoard(File file) {
		Board board = new Board();
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String landInfo = scanner.nextLine();
				if (!landInfo.isEmpty()) {
					addLand(board, generateLandData(landInfo));
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File : " + file.getAbsolutePath() + " NOT FOUND!");
		}
		
		
		return board;
	}

	private static ArrayList<String> generateLandData(String landInfo) {
		StringTokenizer tokenizer = new StringTokenizer(landInfo, ",");
		
		ArrayList<String> landData = new ArrayList<String>();
		while(tokenizer.hasMoreTokens()) {
			landData.add(tokenizer.nextToken());
		}
		return landData;
	}

	private static void addLand(Board board, ArrayList<String> landData) {
		String landType = getLandType(landData);
		
		if (landType.equals(LAND_START)) {
			board.getLands().add(new Start());
		} else if (landType.equals(LAND_GOJAIL)) {
			board.getLands().add(new GoJail());
		} else if (landType.equals(LAND_JAIL)) {
			board.getLands().add(new Jail());
		} else if (landType.equals(LAND_FREEPARKING)) {
			board.getLands().add(new FreeParking());
		} else if (landType.equals(LAND_PAYTAX)) {
			board.getLands().add(new PayTax());
		} else if (landType.equals(LAND_CHANCE)) {
			board.getLands().add(new Chance());
		} else if (landType.equals(LAND_COMMUNITYCHEST)) {
			board.getLands().add(new CommunityChest());
		} else if (landType.equals(LAND_COLOREDLAND)) {
			board.getLands().add(new ColoredLand(getLandName(landData), getLandColor(landData), getLandPrice(landData), getHousePrice(landData), getRentInfo(landData)));
		} else {
			throw new RuntimeException("There is no land type named : " + landType);
		}
		
	}

	private static String getLandName(ArrayList<String> landData) {
		String name = getValueAt(landData, 1);
		return name;
	}

	private static Color getLandColor(ArrayList<String> landData) {
		Color landColor = Color.decode(getValueAt(landData, 4));
		return landColor;
	}

	private static int getLandPrice(ArrayList<String> landData) {
		int landPrice = Integer.parseInt(getValueAt(landData, 2));
		return landPrice;
	}

	private static int getHousePrice(ArrayList<String> landData) {
		int housePrice = Integer.parseInt(getValueAt(landData, 11));
		return housePrice;
	}

	private static RentInfo getRentInfo(ArrayList<String> landData) {
		ColoredLandRent rent = new ColoredLandRent(Integer.parseInt(getValueAt(landData, 3)));
		rent.setHouseRent(1, Integer.parseInt(getValueAt(landData, 5)));
		rent.setHouseRent(2, Integer.parseInt(getValueAt(landData, 6)));
		rent.setHouseRent(3, Integer.parseInt(getValueAt(landData, 7)));
		rent.setHouseRent(4, Integer.parseInt(getValueAt(landData, 8)));
		rent.setHotelRent(Integer.parseInt(getValueAt(landData, 9)));
		return rent;
	}

	private static String getLandType(ArrayList<String> landData) {
		return getValueAt(landData, 0);
	}
	
	private static String getValueAt(ArrayList<String> landData, int index) {
		return landData.get(index);
	}

}
