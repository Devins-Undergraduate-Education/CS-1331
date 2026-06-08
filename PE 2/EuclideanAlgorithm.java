public class EuclideanAlgorithm {
    public static void main (String[] args) {
        
        //Initialization of Variables
        int num1 = 213; 
        int num2 = 157;
        int steps = 0; 
        int dividend = num1; 
        int divisor = num2; 
        int gcd, quotient, remainder;

        //Printing using printf
        System.out.printf("Finding the greatest common divisor of %s and %s.%n", num1, num2);

        //if-else statement(s)
        if (divisor > dividend){
            System.out.println("The inputs would have caused an unnecessary step.");
            //Swaps values of dividend and divisor without using a third variable
            divisor = divisor * dividend; 
            dividend = divisor / dividend; 
            divisor = divisor / dividend; 
        }
        else {
            System.out.println("An extra step was avoided.");
        }

        //do-while loop(S)
        do {
            steps++; 
            quotient = dividend / divisor;
            remainder = dividend % divisor;
            System.out.printf("Step %s: %s = %s * %s + %s%n", steps, dividend, divisor, quotient, remainder);
            gcd = divisor;
            dividend = divisor; 
            divisor = remainder; 
        }
        while(remainder != 0);

        //GCD println statement(s)
        System.out.println("The GDC is " + gcd);

        //switch statement(s)
        switch(steps) {
            case 1: 
                System.out.println("Only one step was needed!");
                break; 
            case 2: 
                System.out.println("Two steps were taken!");
                break; 
            case 3: 
                System.out.println("This process took three steps");
                break; 
            case 4: 
                System.out.println("Wow! Four steps.");
                break; 
            default: 
                System.out.println(steps + " steps is a lot of steps!");
        }

        //ternary printf statement(s)
        System.out.printf((gcd == 1) ? "%s and %s are relatively prime." : "%s and %s are not relatively prime.", num1, num2);
    }
}