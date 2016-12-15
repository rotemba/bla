/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu.spl.a2.test;

import bgu.spl.a2.Task;
import bgu.spl.a2.WorkStealingThreadPool;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MergeSort extends Task<int[]> {

    private final int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    @Override
    //We have P - the Handler processor, just need to run the task on it.
    protected void start() {
        boolean needToSpawn=checkIfNeedToSplitTask();
        if (needToSpawn)
            spawn();
        else{
            //need to Actually solve the task.
        }

    }

    public static void main(String[] args) throws InterruptedException {
        WorkStealingThreadPool pool = new WorkStealingThreadPool(4);
        int n = 1000000; //you may check on different number of elements if you like
        int[] array = new Random().ints(n).toArray();
        System.out.println ("size of the array is:"+array.length);
        //System.out.println(Arrays.toString(array));

        MergeSort task = new MergeSort(array);

        CountDownLatch l = new CountDownLatch(1);
 /*
        pool.start();
        pool.submit(task);
        task.getResult().whenResolved(() -> {
           // warning - a large print!! - you can remove this line if you wish
            System.out.println(Arrays.toString(task.getResult().get()));
            l.countDown();
        });

        l.await();
 */
        pool.shutdown();


    }
    private boolean checkIfNeedToSplitTask(){
        //TODO: need to check for a specific task if it can be done or got to split up.
        return true;
    }

    @Override
    protected void splitTask() {

    }
}
