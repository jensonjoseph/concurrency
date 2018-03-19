package com.jensonjo;

public class Worker implements Runnable {

    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        TransactionManager.startTransaction();
        System.out.println("name after start - "+TransactionManager.getTransactionID());
        SubWorker subWorker = new SubWorker("sub" + name);
        Thread subWorkerThread = new Thread(subWorker);
        subWorkerThread.start();
        try {
            subWorkerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        TransactionManager.endtransaction();
        System.out.println("name after end - " + TransactionManager.getTransactionID());
    }
}
