package bgu.spl.a2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * represents a work stealing thread pool - to understand what this class does
 * please refer to your assignment.
 *
 * Note for implementors: you may add methods and synchronize any of the
 * existing methods in this class *BUT* you must be able to explain why the
 * synchronization is needed. In addition, the methods you add can only be
 * private, protected or package protected - in other words, no new public
 * methods
 */
public class WorkStealingThreadPool {
private LinkedBlockingDeque<Task>[] queues;
private int numberOfThreads;
private ScheduledThreadPoolExecutor poolExecutor;
    /**
     * creates a {@link WorkStealingThreadPool} which has nthreads
     * {@link Processor}s. Note, threads should not get started until calling to
     * the {@link #start()} method.
     *
     * Implementors note: you may not add other constructors to this class nor
     * you allowed to add any other parameter to this constructor - changing
     * this may cause automatic tests to fail..
     *
     * @param nthreads the number of threads that should be started by this
     * thread pool
     */
    public WorkStealingThreadPool(int nthreads) {
        numberOfThreads=nthreads;
        queues= new LinkedBlockingDeque[numberOfThreads];
        poolExecutor= new ScheduledThreadPoolExecutor(numberOfThreads);



    }


    /**
     * submits a task to be executed by a processor belongs to this thread pool
     *
     * @param task the task to execute
     */
    public void submit(Task<?> task) {
        //TODO: replace method body with real implementation
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }

    /**
     * closes the thread pool - this method interrupts all the threads and wait
     * for them to stop - it is returns *only* when there are no live threads in
     * the queue.
     *
     * after calling this method - one should not use the queue anymore.
     *
     * @throws InterruptedException if the thread that shut down the threads is
     * interrupted
     * @throws UnsupportedOperationException if the thread that attempts to
     * shutdown the queue is itself a processor of this queue
     */
    public void shutdown() throws InterruptedException {
        poolExecutor.shutdown();
        //throw new UnsupportedOperationException("Not Implemented Yet.");
    }

    /**
     * start the threads belongs to this thread pool
     */
    public void start() {
        //TODO: replace method body with real implementation
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }

    //make a stealing action for thread stealer
    //reutrn true if done successfully, false if failed.
    private boolean stealTasksFromOther (int stealer){
        int next=(stealer+1)%numberOfThreads;
        int victim=chooseVictim(stealer,next);
        if (victim==-1)
            return (false);
        else{
            steal(stealer,victim);
            return true;
        }
    }
    //find a Thread which got more then 1 task in the turn
    //return -1 if not found.
    private int chooseVictim (int stealer,int toCheck){
        if (toCheck==stealer)
            return (-1);
        if (queues[toCheck].size()>1)
            return toCheck;
        int next=(toCheck+1)%numberOfThreads;
        return chooseVictim(stealer,next);
    }
    //steals half of the task from Victim to Stealer, allready checked he got 'free' tasks.
    private void steal (int stealer, int victim){
        //TODO: replace method body with real implementation

    }


}
