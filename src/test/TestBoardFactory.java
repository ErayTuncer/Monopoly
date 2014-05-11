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
		
		assertTrue(board.lands.get(0) instanceof Start);
		assertTrue(board.lands.get(0).getName().equals("Start"));
		assertTrue(board.lands.get(1) instanceof GoJail);
		assertTrue(board.lands.get(1).getName().equals("GoJail"));
		assertTrue(board.lands.get(2) instanceof Jail);
		assertTrue(board.lands.get(2).getName().equals("Jail"));
		assertTrue(board.lands.get(3) instanceof FreeParking);
		assertTrue(board.lands.get(3).getName().equals("FreeParking"));
		assertTrue(board.lands.get(4) instanceof PayTax);
		assertTrue(board.lands.get(4).getName().equals("PayTax"));
		assertTrue(board.lands.get(5) instanceof Chance);
		assertTrue(board.lands.get(5).getName().equals("Chance"));
		assertTrue(board.lands.get(6) instanceof CommunityChest);
		assertTrue(board.lands.get(6).getName().equals("CommunityChest"));
	}
	
	@Test
	public void testColoredLand() {
		Board board = BoardFactory.readBoard(new File("assets/test/testBoard2.txt"));
		ColoredLand coloredLand = (ColoredLand) board.lands.get(0);
		
		assertEquals(Color.decode("#964818"), coloredLand.getColor());
		assertEquals("LIVERPOOL", coloredLand.getName());
		assertEquals(60, coloredLand.getPrice());
		assertEquals(2, coloredLand.getBaseRent());
	}

	@Test
	public void testPayTax() {
		Board board = BoardFactory.readBoard(new File("assets/test/testBoard2.txt"));

		PayTax payTax = (PayTax) board.lands.get(1);
		InfrastructureLand infrastructure = (InfrastructureLand) board.lands.get(2);
		TransportationLand transportation = (TransportationLand) board.lands.get(3);

		
		assertEquals(Color.decode("#964818"), coloredLand.getColor());
		assertEquals("LIVERPOOL", coloredLand.getName());
		assertEquals(60, coloredLand.getPrice());

	}

}
