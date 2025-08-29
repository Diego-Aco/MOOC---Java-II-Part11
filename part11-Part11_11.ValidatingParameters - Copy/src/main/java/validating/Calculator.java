package validating;

public class Calculator {

    public int factorial(int num) {
        if (num<0) {
            throw new IllegalArgumentException("Argument must be non-negative.");
        }
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        //Note: the suggested solution has three different if statements and error messages
        //for each of these conditions
        if (setSize <0 || subsetSize <0 || subsetSize>setSize) {
            throw new IllegalArgumentException("Arguments must be non-neg and setSize must be >=subsetSize");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
