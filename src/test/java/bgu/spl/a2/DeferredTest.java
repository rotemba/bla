package bgu.spl.a2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DeferredTest {
   Deferred<Integer> deffered;
    public String runModify="";

    private class RunTester implements Runnable{
        RunTester(){
            //empty constructor
        }
        public void run(){
            runModify="running";
        }
    }

    @Before
    public void setUp(){
        int x = 7;
        deffered= new Deferred<Integer>(x);
    }

    @Test(expected = IllegalStateException.class)
    public void get() throws Exception {
                  int y = deffered.get();
        }

    @Test
    public void getAfterResolved() throws Exception {
        int x=7;
        deffered.resolve(7);
        int y = deffered.get();
        assertEquals(x,y);
            }

    @Test
    public void isNotResolved() throws Exception {
        boolean excpected=false;

                boolean checkIfFinieshed=deffered.isResolved();
                assertFalse(checkIfFinieshed);
    }
    @Test
    public void isResolved() throws Exception {
        boolean excpected=true;
        deffered.resolve(7);
        boolean checkIfFinieshed=deffered.isResolved();
        assertTrue(checkIfFinieshed);
    }

    @Test
    public void resolve() throws Exception {
        deffered.resolve(8);
        boolean checkIfFinished=deffered.isResolved();
        assertTrue(checkIfFinished);
    }
    @Test (expected = IllegalStateException.class )
    public void resolveTwice() throws Exception {
        deffered.resolve(8);
        deffered.resolve(8);
    }

    @Test
    public void whenResolved() throws Exception {
        RunTester toRun= new RunTester();
        deffered.resolve(7);
        deffered.whenResolved(toRun);
        String res="running";
        assertEquals(res,runModify);


    }

    @Test (expected = IllegalStateException.class)
    public void whenResolvedTwice() throws Exception {
        RunTester toRun= new RunTester();
        deffered.resolve(7);
        deffered.whenResolved(toRun);
        deffered.whenResolved(toRun);

    }

}