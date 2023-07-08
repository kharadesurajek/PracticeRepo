package baseTest;

import org.testng.annotations.Test;

import utils.FileAndEnv;

public class BaseTest {

	@Test
	public void utilsTest() {
		
		System.out.println(FileAndEnv.envAndFile());
		
		
	}
	
}
