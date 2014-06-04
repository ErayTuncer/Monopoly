package test;

import static org.junit.Assert.*;

import org.junit.Test;

import element.Chance;
import element.ColoredLand;
import element.CommunityChest;
import element.FreeParking;
import element.GoJail;
import element.InfrastructureLand;
import element.Jail;
import element.Land;
import element.PayTax;
import element.Start;
import element.TransportationLand;

public class TestConstructionAllowance {

	@Test
	public void testAllowanceForChance() {
		Land chanceLand = new Chance();
		assertFalse(chanceLand.isConstructionAllowed());
	}

/*	@Test
	public void testAllowanceForColoredLand() {
		Land coloredLand = new ColoredLand();
		assertTrue(coloredLand.isConstructionAllowed());
	}
*/
	@Test
	public void testAllowanceForCommunityChest() {
		Land communityLand = new CommunityChest();
		assertFalse(communityLand.isConstructionAllowed());
	}

	@Test
	public void testAllowanceForFreeParking() {
		Land parkingLand = new FreeParking();
		assertFalse(parkingLand.isConstructionAllowed());
	}

	@Test
	public void testAllowanceForGoJail() {
		Land goJailLand = new GoJail();
		assertFalse(goJailLand.isConstructionAllowed());
	}

/*	@Test
	public void testAllowanceForInfrastructureLand() {
		Land infrastructureLand = new InfrastructureLand();
		assertFalse(infrastructureLand.isConstructionAllowed());
	}*/

	@Test
	public void testAllowanceForJail() {
		Land jailLand = new Jail();
		assertFalse(jailLand.isConstructionAllowed());
	}

	@Test
	public void testAllowanceForPaytax() {
		Land payTaxLand = new PayTax(2000);
		assertFalse(payTaxLand.isConstructionAllowed());
	}

	@Test
	public void testAllowanceForStart() {
		Land startLand = new Start();
		assertFalse(startLand.isConstructionAllowed());
	}
/*	
	@Test
	public void testAllowanceForTransportationLand() {
		Land transportationLand = new TransportationLand();
		assertFalse(transportationLand.isConstructionAllowed());
	}*/
	
}
