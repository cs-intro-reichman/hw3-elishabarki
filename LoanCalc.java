public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCounter; 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]) / 100 + 1;
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, double n, double epsilon) {
        double balance = loan;
        double g = loan/n;
        while (balance > 0) {      
            balance = loan;
            for (int i = 0; i < n; i++) {
                balance = (balance - g)*rate;          
            }             
            g += epsilon;
            iterationCounter++;
        }       
        System.out.println(g);
        return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, double n, double epsilon) {
        double balance = loan;
        double hi = loan;
        double lo = loan/n;  
        double g = (lo+hi)/2;
        while ((hi-lo) > epsilon) {      
            balance = loan;
            for (int i = 0; i < n; i++) {
                balance = (balance - g)*rate;          
            }   
            if (balance > 0) { 
                lo = g;
                g = (lo+hi)/2;
                
            } else { 
                hi = g;
                g = (lo+hi)/2;
            }               
            iterationCounter ++;
        }            
        System.out.println(g);
        return g;
    }
}
