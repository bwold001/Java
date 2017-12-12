/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Beza
 */
public class MethodsTest {
    
    public MethodsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of max method, of class Methods.
     */
    @Test
    public void testMax() {
        System.out.println("max");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Methods.max(a, b);
        assertEquals(expResult, result);
        assertEquals(45, Methods.max(45, 30));
        assertEquals(100, Methods.max(100,100));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of min method, of class Methods.
     */
    @Test
    public void testMin() {
        System.out.println("min");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Methods.min(a, b);
        assertEquals(expResult, result);
        assertEquals(30, Methods.min(45, 30));
        assertEquals(100, Methods.min(100,100));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of average method, of class Methods.
     */
    @Test
    public void testAverage() {
        System.out.println("average");
        int a = 0;
        int b = 0;
        int c = 0;
        double expResult = 0.0;
        double result = Methods.average(a, b, c);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of power method, of class Methods.
     */
    @Test
    public void testPower() {
        System.out.println("power");
        int a = 0;
        int b = 0;
        double expResult = 0.0;
        double result = Methods.power(a, b);
        assertEquals(expResult, result, 0.0);        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of odd method, of class Methods.
     */
    @Test
    public void testOdd() {
        System.out.println("odd");
        int a = 0;
        boolean expResult = false;
        boolean result = Methods.odd(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of even method, of class Methods.
     */
    @Test
    public void testEven() {
        System.out.println("even");
        int a = 0;
        boolean expResult = false;
        boolean result = Methods.even(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of positive method, of class Methods.
     */
    @Test
    public void testPositive() {
        System.out.println("positive");
        int a = 0;
        boolean expResult = false;
        boolean result = Methods.positive(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of negative method, of class Methods.
     */
    @Test
    public void testNegative() {
        System.out.println("negative");
        int a = 0;
        boolean expResult = false;
        boolean result = Methods.negative(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    
}
