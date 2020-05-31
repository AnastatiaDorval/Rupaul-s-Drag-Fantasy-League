import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;


public class QueenTestCases {
	Queen q;
	
	@Before
	public void setUp(){
		q = new Queen("Crystal Methyod", "Campy", "Springfield");
	}

	@Test
	public void testGetName() {
		assertEquals("Crystal Methyod", q.getName());
	}
	
	@Test
	public void testGetType() {
		assertEquals("Campy", q.getType());
	}
	
	@Test
	public void testGetLocal() {
		assertEquals("Springfield", q.getLocal());
	}
	
	@Test
	public void testGetAllInfo() {
		List<String> l = new ArrayList<String>();
		
		l.addAll(q.getAllInfo());
		
		assertEquals(true ,l.contains("Crystal Methyod"));
		assertEquals(true, l.contains("Campy"));
		assertEquals(true, l.contains("Springfield"));
	}
	
	@Test
	public void testMaxiMethods() {
		assertEquals(0, q.getMaxiWins());
		assertEquals(0, q.getScore());
		
		q.addMaxi();
		q.addMaxi();
		
		assertEquals(2, q.getMaxiWins());
		assertEquals(20, q.getScore());
	}
	
	@Test
	public void testMiniMethods() {
		assertEquals(0, q.getMiniWins());
		assertEquals(0, q.getScore());
		
		q.addMini();
		
		assertEquals(1, q.getMiniWins());
		assertEquals(3, q.getScore());
	}
	
	@Test
	public void testBotandLipSyncandTop() {
		assertEquals(0, q.getMiniWins());
		assertEquals(0, q.getScore());
		
		q.Top();
		assertEquals(1, q.getScore());
		
		q.BotWithOutLip();
		assertEquals(0, q.getScore());
		
		q.LipSync();
		assertEquals(-3, q.getScore());
	}

}
