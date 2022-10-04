/*
  Final version of class used to test the Rational class.
*/
public class TestRationalFinal {

    public static void prn(String s) {
	System.out.println(s);
    }
    
    public static void p(String s) {
	System.out.print("\n" + s + "\n==================\n");
    }

    public static void test(String s, Object obj) {
	System.out.println(s + "\t\t" + obj);
    }

    /**
       @param o1 integer to test
       @param o2 integer to test
       Print OK iff two integers are equal.
    */
    public static void assertEquals(int o1, int o2) {
	if (o1 == o2) 
	    System.out.println("OK " + o1 + " equals " + o2);
	else 
	    System.out.println("ERROR " + o1 + " and " + o2 + " differ.");
    }
  
    /**
       @param o1 obj to test
       @param o2 obj to test
       Print OK iff two objects are equal.
    */
    public static void assertEquals(Rational o1,Rational o2) {
	if (o1.equals(o2)) 
	    System.out.println("OK " + o1 + " equals " + o2);
	else 
	    System.out.println("ERROR " + o1 + " and " + o2 + " differ.");
    }

    public static void assertEquals(String o1,String o2) {
	if (o1.equals(o2)) 
	    System.out.println("OK " + o1 + " equals " + o2);
	else 
	    System.out.println("ERROR " + o1 + " and " + o2 + " differ.");
    }


    /**
       Print message dependon on value of test which should
       be true.
    */
    public static void assertTrue(String message, boolean test) {
	if (test) 
	    System.out.println("OK " + message);
	else 
	    System.out.println("ERROR  " + message);
    }

    
    public static void main(String args[]) {
	Rational r = null;
	Rational one = new Rational(1,1);
	Rational r1 = new Rational(36,-24);
	Rational r2 = new Rational(6,8);
	Rational r3 = new Rational(1,-5);
	Rational r4 = new Rational(0,5);
	Rational r5 = new Rational(-3,2);
	Rational r6 = new Rational(-36,-48);
	Rational r7 = new Rational(-7,35);
	Rational r8 = new Rational(-1,135);
	Rational r9 = new Rational(1,5);
	Rational r10 = new Rational(3,2);
	
	// Items to test
	// Rational()
	// Rational(n,d)
	// toString()
	// equals(R)
	// gt(r)
	// lt(r)
	// static add(r1,r2)
	// static subtract(r1,r2)
	// static multiply(r1,r2)
	


	// Rational()
	p("Test Constructors");
	Rational zero = new Rational(0,1);
	Rational z1 = new Rational();
	Rational z2 = new Rational(0,-21);
	try {
	    // try making a bad rational
	    r = new Rational(0,0);
	    prn("0/0 is " + r);
	}
	catch (Exception exp) {
	    prn("OK 0/0 raises exception");
	    System.out.println(exp.toString());
	}
	
	test("Zero rational",z1.toString());
	assertEquals(z1,z2);
	// Rational(n,d)
	assertEquals(r2,r6);
	// tostring
	p("Test toString");
	assertEquals(r1+"","-3/2");
	// equals(R)
	p("Test equals");
	assertEquals(zero,new Rational(0,Integer.MAX_VALUE));
	assertEquals(r7,r3);
	assertEquals(one,new Rational(-9,-9));
	// gt(r) and lt
	p("Tests gt");
	assertTrue(r2 + ">" + r4, r2.gt(r4));
	assertTrue(r4 + ">" + r3, r4.gt(r3));
	assertTrue(r8 + ">" + r3, r4.gt(r3));
	p("Tests lt");
	assertTrue(r4 + "<" + r2, r4.lt(r2));
	assertTrue(r3 + "<" + r4, r3.lt(r4));
	assertTrue(r3 + "<" + r8, r3.lt(r8));
	// static add(r1,r2)
	p("Tests add");
	assertEquals(Rational.add(r3,r9),zero);
	assertEquals(Rational.add(r2,r2),r10);
	assertEquals(Rational.add(r2,r6),r10);
	assertEquals(Rational.add(r2,r6),r10);
	// static subtract(r1,r2)
	p("Tests subtract");
	assertEquals(Rational.subtract(r2,r7),new Rational(19,20));
	// static multiply(r1,r2)
	p("Tests multiply");
	//assertEquals(Rational.multiply(one,r7),r7);
	assertEquals(Rational.multiply(r2,r7),new Rational(-3,20));
	assertEquals(Rational.multiply(zero,r4),zero);
	prn("DONE================");

    }


}
