import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SoundClassUnitTesting {

	
	Sound sd = new Sound();

	@BeforeEach
	void setUp() throws Exception 
	{
		sd.setValue(1100, 7.2);
	}

	@Test
	void test() {
		sd.printValue();
		//fail("Not yet implemented");
	}

}
