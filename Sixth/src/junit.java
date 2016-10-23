import org.junit.Before;
import org.junit.Test;
public class junit {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		String name1="gaotongtong";
		name1.equals(jmeter.name);
	}

	@Test
	public void testGetFriend() {
		String friend1="shangdelong";
		friend1.equals(jmeter.friend);
	
	}
}