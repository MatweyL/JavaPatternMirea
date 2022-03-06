package ru.mirea.task3;

import java.util.Map;
import java.util.concurrent.Semaphore;

public class TestThreads {
    public static void main(String[] args) {
        SemaphoreMap<String, Integer> sMap = new SemaphoreMap<>();

            for (int i = 0; i < 10; i++) {
                sMap.put("id" + i, i + 100);
                System.out.println("id" + i);
            }
        new Thread(()->{
            for (int i = 0; i < sMap.size(); i++) {
                System.out.println("SMAP: Printed: " + sMap.get("id" + i));
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < sMap.size(); i++) {
                System.out.println("SMAP: Removed: " + sMap.remove("id" + i));
            }
        }).start();

        LockList<Integer> lockList = new LockList<>();
        for (int i = 0; i < 10; i++) {
            lockList.add(i + 1000);
        }
        new Thread(()->{
            for (int i = 0; i < lockList.size(); i++) {
                System.out.println("LLIST Printed: " + lockList.get(i));
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < lockList.size(); i++) {
                System.out.println("LLIST Contains: " + lockList.contains(lockList.get(i)));
            }
        }).start();

    }
}
