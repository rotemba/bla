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
    public String runModify="";
    private class RunTester implements Runnable{

        RunTester(){
            //empty constructor
        }


        public void run(){
            runModify="running";
            //throw new UnsupportedOperationException("Not running anything");
        }
    }
    /*
        Create an instance of the class.
        The class must have a public default constructor.
        For each method that fits: @Test public void _____ () { … }
        Run a method with the tag @Before (e.g., setUp()) - preparing the conditions for the test.
        Run the method _____ ()
        Display test results
        Run a method with the tag @After (e.g., tearDown()) - returning the system to normal functionality.

     */

    /*
    @Test(expected=IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
    ArrayList emptyList = new ArrayList();
    Object o = emptyList.get(0);
}
     */

    @Test(expected = IllegalStateException.class)
    public void get() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);

                int y = deffered.get();
        }

    @Test
    public void getAfterResolved() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);
        deffered.resolve(7);
        int y = deffered.get();
        assertEquals(x,y);
            }

    @Test
    public void isNotResolved() throws Exception {
        int x = 7;
        boolean excpected=false;
        Deferred<Integer> deffered= new Deferred<Integer>(x);

                boolean checkIfFinieshed=deffered.isResolved();
                assertFalse(checkIfFinieshed);
    }
    @Test
    public void isResolved() throws Exception {
        int x = 7;
        boolean excpected=true;
        Deferred<Integer> deffered= new Deferred<Integer>(x);
        deffered.resolve(7);
        boolean checkIfFinieshed=deffered.isResolved();
        assertTrue(checkIfFinieshed);
    }

    @Test
    public void resolve() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);
        deffered.resolve(8);
        boolean checkIfFinished=deffered.isResolved();
        assertTrue(checkIfFinished);
    }
    @Test (expected = IllegalStateException.class )
    public void resolveTwice() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);
        deffered.resolve(8);
        deffered.resolve(8);
    }

    @Test
    public void whenResolved() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);
        RunTester toRun= new RunTester();
        deffered.resolve(7);
        deffered.whenResolved(toRun);
        String res="running";
        assertEquals(res,runModify);


    }

    @Test (expected = IllegalStateException.class)
    public void whenResolvedTwice() throws Exception {
        int x = 7;
        Deferred<Integer> deffered= new Deferred<Integer>(x);
        RunTester toRun= new RunTester();
        deffered.resolve(7);
        deffered.whenResolved(toRun);
        deffered.whenResolved(toRun);

    }

}