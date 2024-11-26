public class LoanCalc {
        public static void main(String[] args) {
            double loan = Integer.parseInt(args[0]);
            double rate = Integer.parseInt(args[1]);
            rate = (rate / 100)+1;
            double n = 10;
            bruteForceSolver(loan, rate, n);
            bisectionSearch(loan, rate, n);
        }
    
        public static double bruteForceSolver(double loan, double rate, double n) {
            double e = 0.1;
            double balance = loan;
            double g = loan/n;
            while (balance > 0) {      
                balance = loan;
                for (int i = 0; i < n; i++) {
                    balance = (balance - g)*rate;          
                }             
                g += e;
            }       
            System.out.println((int) g);
            return g;
        }

        public static double bisectionSearch(double loan, double rate, double n) {
            double e = 0.1;
            double balance = loan;
            double hi = loan;
            double lo = loan/n;  
            double g = (lo+hi)/2;
            while ((hi-lo) > e) {      
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
            }            
            System.out.println((int) g);
            return g;
        }
    }
