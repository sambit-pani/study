package com.example.test.springtest.json;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssert {

	String response = "{\"id\":1,\"name\":\"apple\",\"price\":12.0,\"quantity\":10}";
	
	@Test
	public void testJsonAssert_Strict_False() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"apple\",\"price\":12.0}";
		JSONAssert.assertEquals(expectedResponse, response, false);
	}
	@Test
	public void testJsonAssert_Strict_True() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"apple\",\"price\":12.0,\"quantity\":10}";
		JSONAssert.assertEquals(expectedResponse, response, true);
	}
	
	@Test
	public void testJsonAssert_Escape_Char() throws JSONException {
		String expectedResponse = "{id:1,name:apple,price:12.0,quantity:10}";
		JSONAssert.assertEquals(expectedResponse, response, true);
	}
}
