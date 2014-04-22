package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import element.*;
import util.BoardFactory;

public class TestBoardFactory {

	@Test
	public void testSpecialLands() {
		Board board = BoardFactory.readBoard(new File("assets/test/testBoard1.txt"));
		
		assertTrue(board.lands.get(0) instanceof Start);
		assertTrue(board.lands.get(1) instanceof GoJail);
		assertTrue(board.lands.get(2) instanceof Jail);
		assertTrue(board.lands.get(3) instanceof FreeParking);
		assertTrue(board.lands.get(4) instanceof PayTax);
		assertTrue(board.lands.get(5) instanceof Chance);
		assertTrue(board.lands.get(6) instanceof CommunityChest);
	}

}
