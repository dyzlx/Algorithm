package com.dyz.algorithm.leetcode;


import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * n整数，n个线程
 * 第x个线程打印x
 * 按顺序打印:1，2，3，...，x，n
 *
 */
public class MultiThreadsSequentialPrinting {

    public static void main(String[] args) {
        //method1(8);
        method2(18);
        //method3(19);
    }

    /**
     * 第一种方法：使用join函数，使前一个线程先与当前线程执行
     * @param n
     */
    public static void method1(int n) {
        System.out.println("==========method1==========");
        Thread previousThread = Thread.currentThread();
        for (int i = 1 ; i <= n ; i++) {
            Thread currentThread = new MyJoinThread(i, previousThread);
            currentThread.start();
            previousThread = currentThread;
        }
    }

    /**
     * 第二种方法：
     * 使用LockSupport的park和unpark方法
     * 先park放入链表，然后开始输出再unpark下一个节点
     * @param n
     */
    public static void method2(int n) {
        System.out.println("==========method2==========");
        MyLockSupportThread head = new MyLockSupportThread(-1);
        MyLockSupportThread previous = head;
        for (int i = 1 ; i <= n ; i++) {
            MyLockSupportThread newThread = new MyLockSupportThread(i);
            newThread.start();
            previous.setNext(newThread);
            previous = newThread;
        }
        LockSupport.unpark(head.next);
    }

    /**
     * 第三种方法：使用CountDownLatch
     * @param n
     */
    public static void method3(int n) {
        System.out.println("==========method1==========");
        CountDownLatch preCDL = null;
        MyCountDownLatchThread first = null;
        for (int i = n ; i > 0 ; i--) {
            CountDownLatch curCDL = new CountDownLatch(1);
            first = new MyCountDownLatchThread(i, curCDL, preCDL);
            first.start();
            preCDL = curCDL;
        }
        if(Objects.nonNull(first)) {
            first.countDownMy();
        }
    }

    public static class MyThread extends Thread {
        private int seq;
        public MyThread(int seq) {
            this.seq = seq;
        }
        @Override
        public void run() {
            System.out.print(seq + " ");
        }
    }

    public static class MyCountDownLatchThread extends MyThread {
        private CountDownLatch myCountDownLatch;
        private CountDownLatch nextCountDownLatch;
        public MyCountDownLatchThread(int seq, CountDownLatch myCDL,CountDownLatch nextCDL) {
            super(seq);
            this.myCountDownLatch = myCDL;
            this.nextCountDownLatch = nextCDL;
        }
        public void countDownMy() {
            if(Objects.nonNull(myCountDownLatch)) {
                myCountDownLatch.countDown();
            }
        }
        @Override
        public void run() {
            try {
                if(Objects.nonNull(myCountDownLatch)) {
                    myCountDownLatch.await();
                }
                super.run();
                if(Objects.nonNull(nextCountDownLatch)) {
                    nextCountDownLatch.countDown();
                }
            } catch (InterruptedException e) {
                System.out.println("error " + e.getMessage());
            }
        }
    }

    public static class MyLockSupportThread extends MyThread {
        private MyLockSupportThread next;
        public MyLockSupportThread(int seq) {
            super(seq);
        }
        public void setNext(MyLockSupportThread next) {
            this.next = next;
        }
        @Override
        public void run() {
            LockSupport.park();
            if(Thread.currentThread().isInterrupted()) {
                return ;
            }
            super.run();
            if(Objects.nonNull(next)) {
                LockSupport.unpark(next);
            }
        }
    }

    public static class MyJoinThread extends MyThread {
        private Thread previousStep;
        public MyJoinThread(int seq, Thread previousStep) {
            super(seq);
            this.previousStep = previousStep;
        }
        @Override
        public void run() {
            try {
                if(Objects.nonNull(previousStep)) {
                    previousStep.join();
                }
                super.run();
            } catch (InterruptedException e) {
                System.out.println("error " + e.getMessage());
            }
        }
    }
}
