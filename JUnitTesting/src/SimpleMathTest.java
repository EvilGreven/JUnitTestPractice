import static org.junit.Assert.*;

import org.junit.Test;


public class SimpleMathTest {
	private SimpleMath sm = new SimpleMath();

	@Test
	public void GetValueTest() {
		assertEquals("Values not equal",0,sm.get());
	}
	
	@Test
	public void SetValueTest() {
		int value=1;
		sm.set(value);
		assertEquals("Values not equal",value,sm.get());
	}

	public void SetValueRangeTest() {
		int value = 2147483647;
		sm.set(value);
		assertEquals("Values not equal",value,sm.get());
		value = -2147483648;
		sm.set(value);
		assertEquals("Values not equal",value,sm.get());
	}

	@Test(expected=java.lang.IllegalArgumentException.class)
	public void DivideByZeroTest() {
		sm.divide(0);
	}

	@Test
	public void DivisionTest() {
		int dividend = 10, divisor = 2;
		sm.set(dividend);
		assertEquals("Values not equal",dividend/divisor,sm.divide(divisor));
	}

	@Test
	public void DivisionPrecisionTest() {
		int dividend = 10, divisor = 3;
		sm.set(dividend);
		assertEquals("Values not equal",dividend/divisor,sm.divide(divisor));
	}
	
	@Test
	public void MultiplicationTest() {
		int multiplicand = 10;
		int multiplier = 5;
		sm.set(multiplicand);
		assertEquals("Values not equal", multiplicand*multiplier, sm.multiply(multiplier));
	}
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void MultiplicationOverflowValuesPositiveTest() {
		int multiplicand = 2147483647;
		int multiplier = 2;
		sm.set(multiplicand);
		sm.multiply(multiplier);
	}
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void MultiplicationOverflowValuesNegativeTest() {
		int multiplicand = -2147483647;
		int multiplier = -2;
		sm.set(multiplicand);
		sm.multiply(multiplier);
	}
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void MultiplicationOverflowValuesMixedTest() {
		int multiplicand = -2147483647;
		int multiplier = 2;
		sm.set(multiplicand);
		sm.multiply(multiplier);
	}
	
	@Test
	public void AdditionTest() {
		int augend = 10;
		int addend = 5;
		sm.set(augend);
		assertEquals("Values not equal",augend+addend,sm.add(5));
	}
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void AdditionOverflowValuesPositiveTest() {
		int augend = 2147483647;
		int addend = 5;
		sm.set(augend);
		sm.add(addend);
	}

	@Test(expected=java.lang.IllegalArgumentException.class)
	public void AdditionOverflowValuesNegativeTest() {
		int augend = -2147483647;
		int addend = -5;
		sm.set(augend);
		sm.add(addend);
	}

	@Test
	public void SubtractionTest() {
		int minuend = 9;
		int subtrahend = 3;
		sm.set(minuend);
		assertEquals("Values not equal", minuend-subtrahend, sm.subtract(subtrahend));
	}

	@Test(expected=java.lang.IllegalArgumentException.class)
	public void SubtractionOverflowMixedValuesTest() {
		int minuend = 2;
		int subtrahend = -2147483647;
		sm.set(minuend);
		sm.subtract(subtrahend);
	}
}
