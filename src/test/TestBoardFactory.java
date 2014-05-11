package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.File;

import org.junit.Test;

import element.*;
import util.BoardFactory;

public class TestBoardFactory {

	@Test
	public void testSpecialLands() {
		Board board = BoardFactory.readBoard(new File("assets/test/testBoard1.txt"));
		
		assertTrue(board.getLands().get(0) instanceof Start);
		assertTrue(board.getLands().get(0).getName().equals("Start"));
		assertTrue(board.getLands().get(1) instanceof GoJail);
		assertTrue(board.getLands().get(1).getName().equals("GoJail"));
		assertTrue(board.getLands().get(2) instanceof Jail);
		assertTrue(board.getLands().get(2).getName().equals("Jail"));
		assertTrue(board.getLands().get(3) instanceof FreeParking);
		assertTrue(board.getLands().get(3).getName().equals("FreeParking"));
		assertTrue(board.getLands().get(4) instanceof PayTax);
		assertTrue(board.getLands().get(4).getName().equals("PayTax"));
		assertTrue(board.getLands().get(5) instanceof Chance);
		assertTrue(board.getLands().get(5).getName().equals("Chance"));
		assertTrue(board.getLands().get(6) instanceof CommunityChest);
		assertTrue(board.getLands().get(6).getName().equals("CommunityChest"));
	}
	
	@Test
	public void testColoredLand() {
		Board board = BoardFactory.readBoard(new File("assets/test/testBoard2.txt"));
		ColoredLand coloredLand = (ColoredLand) board.getLands().get(0);
		ColoredLandRent rent = (ColoredLandRent) coloredLand.getRentInfo();
		
		assertEquals(Color.decode("#964818"), coloredLand.getColor());
		assertEquals("LIVERPOOL", coloredLand.getName());
		assertEquals(60, coloredLand.getPrice());
		
		assertEquals(2, rent.getBaseRent());
		assertEquals(10, rent.getHouseRent(1));
		assertEquals(30, rent.getHouseRent(2));
		assertEquals(90, rent.getHouseRent(3));
		assertEquals(160, rent.getHouseRent(4));
		assertEquals(250, rent.getHotelRent());
	}

}
