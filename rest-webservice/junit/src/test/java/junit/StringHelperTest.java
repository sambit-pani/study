package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test
	public void testTruncateA() {
		StringHelper helper = new StringHelper();
		String value = helper.truncateA("sAmbit");
		assertEquals("smbit", value);
		
	}
	
	

}
