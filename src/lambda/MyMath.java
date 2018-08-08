package lambda;

public class MyMath {
	
	public static Integer factorial(Integer number) {
		if (number == 0 || number == 1) {
			return 1;
		}
		return number * factorial(number - 1);
	}
	

	public static boolean isPrime(Integer n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 3; i < Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
