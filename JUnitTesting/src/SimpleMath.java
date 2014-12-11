
//very basic class for JUnit tests
public class SimpleMath {
	private int value;

	public SimpleMath(int i) {
		set(i);
	}
	public SimpleMath() {
		set(0);
	}
	
	public int divide(int i) {
		if(i==0)
			throw new IllegalArgumentException("Illegal Argument: Divisor is 0");
		return value/i;
	}

	public void set(int i) {
		value = i;
	}

	public int get() {
		return value;
	}
	public int multiply(int multiplier) {
		int r = value*multiplier;
		if((value > 0 && multiplier > 0 && r < 0) ||
				(value < 0 && multiplier < 0 && r < 0) ||
				(value > 0 && multiplier < 0 && r > 0) ||
				(value < 0 && multiplier > 0 && r > 0) )
			throw new IllegalArgumentException("Illegal Argument: Product exceeds max size");
		return r;
	}
	
	public int add(int addend) {
		int r = value+addend;
		if((value > 0 && addend > 0 && r < 0) ||
				(value < 0 && addend < 0 && r > 0) )
			throw new IllegalArgumentException("Illegal Argument: Sum exceeds max size");
		return r;
	}
	
	public int subtract(int subtrahend) {
		int r = value-subtrahend;
		if((value > 0 && subtrahend < 0 && r < value) ||
				(value < 0 && subtrahend > 0 && r > value) )
			throw new IllegalArgumentException("Illegal Argument: Difference exceeds max size");
		return r;
	}
	
}
