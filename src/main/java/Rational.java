public class Rational {
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }
    
    // This method takes two Rationals, add them up,
    // and returns a Rational equal to the sum
    // You will need to:
    // 1) Calculate the value of the new numerator
    // 2) Calculate the value of the new denominator
    // 3) Create a new Rational variable with the two above values
    // 4) Return your new Rational variable
    // (When you write the simplify method later on, you should
    // also call it in this method to return the simplified result)
    public static Rational add(Rational r, Rational s) {
        int a = r.numerator;
        int b = r.denominator;
        int c = s.numerator;
        int d = s.denominator;
        int top = (a*d) + (b*c);
        int bottom = b*d;
        Rational jake = new Rational(top,bottom);
        return simplify(jake);
    }

    // This method takes two Rationals, subtracts thems up, 
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int a = r.numerator;
        int b = r.denominator;
        int c = s.numerator;
        int d = s.denominator;
        int top = (a*d) - (b*c);
        int bottom = b*d;
        Rational jake = new Rational(top,bottom);
        return simplify(jake);
    }
    
    public static Rational multiply(Rational r, Rational s) {
        return(simplify(new Rational(r.numerator * s.numerator, r.denominator*s.denominator)));
    }
    
    public static Rational divide(Rational r, Rational s) {
        return(simplify(multiply( r, new Rational(r.denominator, r.numerator))));
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int a, int b){
        int x = Math.max(a,b);
        int y=x;
        int ans = 0;
        while (y>0){
            if (a%y==0 && b%y==0){
                ans=y;
                y=0;
            }else{
                y=y-1;
            }
        }return(ans);
    }

    // This method is given a rational, and returns a simplified version
    // ofm the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        int x = greatestCommonFactor(r.numerator, r.denominator);
        return new Rational(r.numerator/x, r.denominator/x);
    }

    // This following method is NOT static, we'll talk about it next class!
    // This returns a string representation of a Rational (e.g. "1/2")
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}













