package com.example.test.springtest.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class ListMock {
	
	List<String> listM = Mockito.mock(List.class);

	@Test
	public void testSize() {
		Mockito.when(listM.size()).thenReturn(3);
		assertEquals(3, listM.size());
	}
	
	@Test
	public void testReturnMultiple() {
		Mockito.when(listM.size()).thenReturn(3).thenReturn(10);
		assertEquals(3, listM.size());
		assertEquals(10, listM.size());
	}
	
	@Test
	public void testParameter() {
		Mockito.when(listM.get(0)).thenReturn("sambit");
		assertEquals("sambit", listM.get(0));
		assertEquals(null, listM.get(2));
	}
	
	@Test
	public void testAnyParameter() {
		Mockito.when(listM.get(Mockito.anyInt())).thenReturn("sambit");
		assertEquals("sambit", listM.get(0));
		assertEquals("sambit", listM.get(2));
	}
	
	@Test
	public void testVerification() {
		Mockito.when(listM.get(0)).thenReturn("sambit");
		assertEquals("sambit",listM.get(0));
		listM.get(1);
		
		//verify
		Mockito.verify(listM).get(0);
		Mockito.verify(listM, Mockito.atLeast(1)).get(Mockito.anyInt());
		Mockito.verify(listM, Mockito.atMost(3)).get(Mockito.anyInt());
		Mockito.verify(listM,Mockito.times(2)).get(Mockito.anyInt());
		Mockito.verify(listM,Mockito.atLeastOnce()).get(1);
		Mockito.verify(listM,Mockito.never()).get(2);
	}
	
	@Test
	public void testArgumentCaptor() {
		//SUT
		listM.add("sambit");
		//verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(listM).add(captor.capture());
		assertEquals("sambit", captor.getValue());
	}
	
	@Test
	public void testMutlipleArgumentCaptor() {
		//SUT
		listM.add("arg1");
		listM.add("arg2");
		// Test
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(listM,Mockito.times(2)).add(captor.capture());
		
		assertEquals("arg1", captor.getAllValues().get(0));
		assertEquals("arg2", captor.getAllValues().get(1));
	}
	
	@Test
	public void testSpyMocking() {
		ArrayList<String> spy = Mockito.spy(ArrayList.class);
		spy.add("Sambit");
		System.out.println(spy.size());
		spy.add("manasi");System.out.println(spy.size());
		Mockito.when(spy.size()).thenReturn(10);
		System.out.println(spy.size());
		spy.add("tutuli");
		System.out.println(spy.size());
	}
	
	@Test
	public void testArgumentMatcher() {
		Mockito.when(listM.get(Mockito.intThat(item -> item>5))).thenReturn("greater than 10");
		assertEquals("greater than 10", listM.get(7));
	}
	
	@Test
	public void testVerificationInOrder() {
		//SUT
		listM.add("saambit");
		listM.get(11);
		listM.isEmpty();
		
		InOrder inorder = Mockito.inOrder(listM);
		inorder.verify(listM).add("saambit");
		inorder.verify(listM).get(11);
		inorder.verify(listM).isEmpty();
		
		//Mockito.verify(listM, Mockito.times(2)).add(Mockito.argThat(string -> string.length() < 5));
	}
	
	@Test
	public void testArgumentMatcher_1() {
		//SUT
		listM.add("sss");
		listM.add("aaa");
		Mockito.when(listM.size()).thenReturn(2);
		Mockito.when(listM.get(Mockito.intThat(i -> i>5))).thenReturn("ccc");
		
		assertEquals(2, listM.size());
		assertEquals("ccc", listM.get(6));
		
		Mockito.verify(listM,Mockito.atLeastOnce()).size();
		Mockito.verify(listM,Mockito.atLeast(1)).get(Mockito.anyInt());
		Mockito.verify(listM, Mockito.times(2)).add(Mockito.argThat(string -> string.length() < 5));
		
	}
}
