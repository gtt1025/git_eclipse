package com.opensource;
import org.junit.Before;
import org.junit.Test;
public class JUnit {
    @Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		String name1="whx";
		name1.equals(jmeter.name);
	}

	@Test
	public void testGetFriend() {
		String friend1="xxx";
		friend1.equals(jmeter.friend);
	
	}
}
