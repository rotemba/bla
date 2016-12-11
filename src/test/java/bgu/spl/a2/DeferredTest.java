package bgu.spl.a2;

//Welcome 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by user on 10/12/2016.
 */
public class DeferredTest {

    /*
        Create an instance of the class.
        The class must have a public default constructor.
        For each method that fits: @Test public void _____ () { … }
        Run a method with the tag @Before (e.g., setUp()) - preparing the conditions for the test.
        Run the method _____ ()
        Display test results
        Run a method with the tag @After (e.g., tearDown()) - returning the system to normal functionality.

     */

    @Test  (excpected = UnsupportedOperationException.class)
    public void get() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);

                int y = deffered.get();
                assertEquals(x,y);

        }

    @Test
    @Before
    public void isResolved() throws Exception {
        int x = 7;
        boolean excpected=false;
        Deferred<Integer> deffered= new Deferred<Integer>(x);

                boolean checkIfFinieshed=deffered.isResolved();
                assertEquals(excpected,checkIfFinieshed);



    }

    @Test
    @After
    public void resolve() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);

        deffered.resolve(8);
        boolean checkIfFinished=deffered.isResolved();

            boolean b=true;
            assertEquals(b,checkIfFinished);

    }

    @Test
    public void whenResolved() throws Exception {

    }

}