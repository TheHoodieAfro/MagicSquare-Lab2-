package model;

import static org.junit.jupiter.api.Assertions.*;
import model.*;
import customExceptions.*;
import org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class MagicSquareTest {

	private MagicSquare ms;
	
	private void setupScenary1() {
		
		ms = new MagicSquare();
		
	}
	
	// *********calculateMagicNumber()*********
	
	@Test
	public void testCalculateMagicNumber() { //Just a normal input
		
		setupScenary1();
		
		int rep = ms.calculateMagicNumber(3);
		assertTrue(15 == rep);
		
	}
	
	// *********setTrack()*********
	
	@Test
	public void testSetTrack0() { //Just a normal input
		
		
		try {
			setupScenary1();
			String rep = ms.setTrack("nw");
			assertTrue(rep.equalsIgnoreCase("nw"));
		} catch (IllegalArgumentException | NonValidTrackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSetTrack1() { //An input not supported
		
		try {
			
			setupScenary1();
			String rep = ms.setTrack("epa");
			fail("se esperaba la excepcion NonValidTrackException");
			
		}catch(NonValidTrackException nonValidTrack) {}
		
	}
	
	@Test
	public void testSetTrack2() { //An special character input
		
		try {
			
			setupScenary1();
			String rep = ms.setTrack("&");
			fail("se esperaba la excepcion IlegalArgumentException");
			
		}catch(IllegalArgumentException | NonValidTrackException IllegalArgument) {}
		
	}
	
	// *********SelectLevel()*********
	
	@Test
	public void testSelectLevel0() { //Just a normal input
		
		try {
			
			setupScenary1();
			int rep = ms.selectLevel("3");
			assertTrue(3 == rep);
					
		}catch(NonOddLevelException nonOdd) {}
		
	}
	
	@Test
	public void testSelectLevel1() { //An even number input
		
		try {
			
			setupScenary1();
			int rep = ms.selectLevel("2");
			fail("se esperaba la excepcion NonOddLevelException");
					
		}catch(NonOddLevelException nonOdd) {}
		
	}
	
	@Test
	public void testSelectLevel2() { //Decimal odd input
		
		try {
			
			setupScenary1();
			int rep = ms.selectLevel("3.5");
			fail("se esperaba un IllegalArgumentException");
					
		}catch(NonOddLevelException nonOdd) {
			
		}catch(IllegalArgumentException ilegalArg) {}
		
	}
	
	@Test
	public void testSelectLevel3() { //Decimal even input
		
		try {
			
			setupScenary1();
			int rep = ms.selectLevel("2.5");
			fail("se esperaba la excepcion IllegalArgumentException");
					
		}catch(IllegalArgumentException fukidoki) {}
		
	}
	
	@Test
	public void testSelectLevel4() { //Negative input
		
		try {
			
			setupScenary1();
			int rep = ms.selectLevel("-5");
			fail("se esperaba la excepcion IllegalArgumentException");
					
		}catch(IllegalArgumentException illegalArg) {}
		
	}
	
	@Test
	public void testSelectLevel5() { //special character input
		
		try {
			
			setupScenary1();
			int rep = ms.selectLevel("&");
			fail("se esperaba la excepcion IllegalArgumentException");
					
		}catch(IllegalArgumentException illegalArg) {}
		
	}
	
	// *********calcRow()*********
	
	@Test
	public void testCalcRow0() { //Supported input up
		
		setupScenary1();
		int rep = ms.calcRow("up", 3);
		assertTrue(rep == 0);
		
	}
	
	@Test
	public void testCalcRow1() { //Supported input down
		
		setupScenary1();
		int rep = ms.calcRow("down", 3);
		assertTrue(rep == 2);
		
	}
	
	@Test
	public void testCalcRow2() { //Supported input left
		
		setupScenary1();
		int rep = ms.calcRow("left", 3);
		assertTrue(rep == 1);
		
	}
	
	@Test
	public void testCalcRow3() { //Supported input right
		
		setupScenary1();
		int rep = ms.calcRow("right", 3);
		assertTrue(rep == 1);
		
	}
	
	@Test
	public void testCalcRow4() { //Unsupported input
		
		try {
			
			setupScenary1();
			int rep = ms.calcRow("epa", 3);
			fail("se esperaba un IllegalArgumentException");
			
		}catch(IllegalArgumentException illegalArg) {}
		
	}
	
	// *********calcColumn()*********
	
	@Test
	public void testCalcColumn0() { //Supported input up
		
		setupScenary1();
		int rep = ms.calcColumn("up", 3);
		assertTrue(rep == 1);
		
	}
	
	@Test
	public void testCalcColumn1() { //Supported input down
		
		setupScenary1();
		int rep = ms.calcColumn("down", 3);
		assertTrue(rep == 1);
		
	}
	
	@Test
	public void testCalcColumn2() { //Supported input left
		
		setupScenary1();
		int rep = ms.calcColumn("left", 3);
		assertTrue(rep == 0);
		
	}
	
	@Test
	public void testCalcColumn3() { //Supported input right
		
		setupScenary1();
		int rep = ms.calcColumn("right", 3);
		assertTrue(rep == 2);
		
	}
	
	@Test
	public void testCalcColumn4() { //Unsupported input
		
		try {
			
			setupScenary1();
			int rep = ms.calcColumn("epa", 3);
			fail("se esperaba un IllegalArgumentException");
			
		}catch(IllegalArgumentException illegalArg) {}
		
	}
	
	// *********calcMagic()*********
	
	@Test
	public void testCalcMagic0() { //A magic square with correct level magic number
		
		setupScenary1();
		int[][] mm = new int[3][3];
		mm[0][0] = 9;
		mm[0][1] = 2;
		mm[0][2] = 4;
		mm[1][0] = 1;
		mm[1][1] = 6;
		mm[1][2] = 8;
		mm[2][0] = 5;
		mm[2][1] = 7;
		mm[2][2] = 3;
		boolean rep = ms.calcMagic(mm, 15);
		assertTrue(rep);
		
	}
	
	@Test
	public void testCalcMagic1() { //A magic square with incorrect level magic number
		
		setupScenary1();
		int[][] mm = new int[3][3];
		mm[0][0] = 9;
		mm[0][1] = 2;
		mm[0][2] = 4;
		mm[1][0] = 1;
		mm[1][1] = 6;
		mm[1][2] = 8;
		mm[2][0] = 5;
		mm[2][1] = 7;
		mm[2][2] = 3;
		boolean rep = ms.calcMagic(mm, 10);
		assertTrue(!rep);
		
	}
	
	@Test
	public void testCalcMagic2() { //A non magic square with correct level magic number
		
		setupScenary1();
		int[][] mm = new int[3][3];
		mm[0][0] = 9;
		mm[0][1] = 2;
		mm[0][2] = 8;
		mm[1][0] = 1;
		mm[1][1] = 6;
		mm[1][2] = 4;
		mm[2][0] = 5;
		mm[2][1] = 7;
		mm[2][2] = 3;
		boolean rep = ms.calcMagic(mm, 15);
		assertTrue(!rep);
		
	}
	
}
