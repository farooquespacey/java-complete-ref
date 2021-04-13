package com.farooque.lam;

class LambdaExceptionDemo {
	private int c = 1;

	public static void main(String args[]) throws EmptyArrayException {
		double[] values = { 1.0, 2.0, 3.0, 4.0 };
		// This block lambda computes the average of an array of doubles.
		LambdaExceptionDemo l = new LambdaExceptionDemo();
		DoubleNumericArrayFunc average = l.getAvgFun();
		System.out.println(l.c);
		System.out.println("The average is " + average.func(values));
		System.out.println(l.c);
		// This causes an exception to be thrown.
		// System.out.println("The average is " + average.func(new double[0]));
	}

	private DoubleNumericArrayFunc getAvgFun() {
		return (n) -> {
			double sum = 0;
			if (n.length == 0)
				throw new EmptyArrayException();
			for (int i = 0; i < n.length; i++)
				sum += n[i];
			System.out.println((this.c = this.c + 1));
			return sum / n.length;
		};
	}
}