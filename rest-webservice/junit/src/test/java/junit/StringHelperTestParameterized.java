package junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperTestParameterized {

	
	private String input;
	private String output;
	
	
	public StringHelperTestParameterized(String input, String output) {
		super();
		this.input = input;
		this.output = output;
	}
	
	@Parameters
	public static Collection<String[]> parameter() {
		String[][] parameter = {{"sAmbi","smbit"},{"Amar","mar"}};
		return Arrays.asList(parameter);
	}

	@Test
	public void testTruncateA() {
		StringHelper helper = new StringHelper();
		String value = helper.truncateA(input);
		assertEquals(output, value);
	}
	
	@Test
	public void testTruncateA_1() {
		StringHelper helper = new StringHelper();
		String value = helper.truncateA(input);
		assertEquals(output, value);
	}
	

}
