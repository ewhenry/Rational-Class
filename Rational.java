/**
   This class provides common arithmetic operations for a rational
   numbers (integer numerator and denominator) ADT.

   All rational numbers are maintained in lowest terms, with a
   denominator that is a positive integer.

   @see java.lang.Object
   @author HENRY WANDOVER
   @date September 2022
*/

public class Rational {
  private int num;
  private int den;
  public final static char SEPARATOR = '/';

  /**
     Default constructor initializes <code>Rational</code> to 0.
  */
  public Rational() {
    this(0,1);
  }

  /**
     <code>Rational</code> constructor
      @param _num the numerator
      @param _den the denominator
      @throws NumberFormatException if den is zero
  */
  public Rational(int _num, int _den) {
    if (_den == 0)
        throw new NumberFormatException("Rational cannot have zero denominator.");
    int gcd = GCD(_num, _den);

    numerator = _num/gcd;
    denominator = _den/gcd;

    if (den < 0) {
        num *= -1;
        den *= -1;
    }
  }

  /** 
private function GCD, not provided to clients
finds the greatest common divisor of M and N
Pre: M and N are defined
Post: returns the GCD of M and N, by Euclid's Algorithm
  */
  private int GCD(int m, int n) {
    int r = Math.abs(m) % Math.abs(n);

    while (r != 0) {
        m = n;
        n = r; 
        r = m % n;
    }
    return n;
  }

  /**
  @param R a rational
  @return true if rational object = R.
  */

  public boolean equals(Rational R) {
    return this.num == R.num && this.den == R.den;
  } 

  /**
  * @param R a rational
  * @return true if rational object > R
  */
  public boolean gt(Rational R) {
    //To compare 2 rationals, you have to make an equal denom through multipliation then numerators can be compared
    return this.num * R.den > R.num * this.den;
  }
  /** 
@param R a rational
@return true if rational object < R.
  */

  public boolean lt(Rational R) {
    return this.num * R.den < R.num * this.den;
  }


  /** 
@param r
@param s
@return Rational corresponding to sum of r + s.
  */
  public static Rational add(Rational r, Rational s) {
    return new Rational(((r.num*s.den)+(s.num*r.den)),
    (r.den*s.den));
  }

  /** 
@param r
@param s
@return Rational corresponding to sum of r - s.
  */

  public static Rational subtract(Rational r, Rational s) {
    return new Rational(((r.num*s.den)-(s.num*r.den)),
    (r.den*s.den));
  }

  /** 
@param r
@param s
@return Rational corresponding to product of r * s.
  */

  public static Rational multiply(Rational r, Rational s) {
    return new Rational((r.num*s.num),
    (r.den*s.den));
  }

  /** 
@param r
@param s
@return Rational corresponding to product of r / s.
  */

  public static Rational divide(Rational r, Rational s) {
    return new Rational((r.num*s.den),
    (r.den*s.num));
  }

  /** 
Convert to String in standard format (i.e., numerator/denominator)
@ return a <code>String</code> representation of
the item.
  */
  public String toString() {
    return num + SEPARATOR + den;
  }
  
}  // end of Rational class