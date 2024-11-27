public class Algebra {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int sum = plus(a, b);
        System.out.println(sum);
        int sub = minus(a, b);
        System.out.println(sub);
        int mul = times(a, b);
        System.out.println(mul);
        int toThePower = pow(a, b);
        System.out.println(toThePower);
        int divide = div(a, b);
        System.out.println(divide);
        int moduloResult = mod(a, b);
        System.out.println(moduloResult);
        int squareroot = sqrt(a);
        System.out.println(squareroot);
    }

    public static int plus(int a, int b) {
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                a++;
            }
        } else if (b < 0) {
            for (int i = 0; i > b; i--) {
                a--;
            }
        }
        return a;
    }

    public static int minus(int a, int b) {
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                a--;
            }
        } else if (b < 0) {
            for (int i = 0; i > b; i--) {
                a++;
            }
        }
        return a;
    }

    public static int times(int a, int b) {
        int multiplication = 0;
        if (b >= 0) {
            for (int i = 0; i < b; i++) {
                multiplication = plus(multiplication, a);
            }
        }
        else {
            for (int i = b; i < 0; i++) {
                multiplication = minus(multiplication, a);
            }
        }
        return multiplication;
    }

    public static int pow(int a, int b) {
        int power = 1;
        for (int i = 0; i < b; i++) {
            power = times(power, a);
        }
        return power;
    }

    public static int div(int a, int b) {
        int division = 0;
        if (a > 0) {
            while (a >= b) {
                a = minus(a, b);
                division++;
            }
        }
        if (a < 0) {
            while (a != 0) {
                a = plus(a, b);
                division--;
            }
        }
        return division;
    }

    public static int mod(int a, int b) {
        int modulo = minus(a, times(div(a, b), b));
        return modulo;
    }

    public static int sqrt(int a) {
            int root = 0;
            while (times(root, root) <= a) {
                root++;
            }
            return (--root);
        
    //     int root = 1;
    //     int n = 1;
    //     if (root == a) {
    //         n = 2;
    //     }
    //     if (a == 0) {
    //         n = 1;
    //     }
    //     while ((root < a) && (a != 0)){
    //         root = pow(n, 2);
    //         n++;
    //     }
    //     return (--n);
      }
    }
