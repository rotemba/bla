package bgu.spl.a2;

import java.util.concurrent.LinkedBlockingDeque;

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
        queues= new LinkedBlockingDeque<Task>[numberOfThreads];
        int[] x= new int[5];
    }

    private boolean stealTasksFromOther (int stealer){
        int next=(i+1)%numberOfThreads;
        int victim=chooseVictim(stealer,next);
    }

    private int chooseVictim (int stealer,int toCheck){
        if (toCheck==stealer)
            return (-1);
        if (queues[toCheck].size()>1)
            return toCheck;
        int next=(toCheck+1)%numberOfThreads;
        return chooseVictim(stealer,next);
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
        //TODO: replace method body with real implementation
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }

    /**
     * start the threads belongs to this thread pool
     */
    public void start() {
        //TODO: replace method body with real implementation
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }

}
