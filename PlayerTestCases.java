import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;
import org.junit.Before;


public class PlayerTestCases {
	Player p;
	
	@Before
	public void setUp() {
		p = new Player("Rupaul");
	}

	@Test
	public void testGetandSetName() {
		assertEquals("Rupaul", p.getName());
		
		p.setName("Michelle Visage");
		assertEquals("Michelle Visage", p.getName());
	}
	
	@Test
	public void testPreferenceMethods() {
		List<String> l;
		
		p.addPreference("Campy");
		p.addPreference("LA");
		p.addPreference("Pageant");
		
		l = p.getPreferences();
		
		assertEquals(true, l.contains("LA"));
		assertEquals(true, l.contains("Campy"));
		assertEquals(false, l.contains("Fishy"));
	}

}
