package com.example.guavaDemo.fstirpedlocks;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class SingleLock extends AbstractFuture {
    ReentrantLock lock;

    public SingleLock() {
        lock = new ReentrantLock();
    }

    @Override
    protected Supplier<?> putSupplier(Map<String, String> map, int key) {
        return (() -> {
           lock.lock();
           try {
               return map.put("key"+key, "value"+key);
           } finally {
               lock.unlock();
           }
        });
    }

    @Override
    protected Supplier<?> getSupplier(Map<String, String> map, int key) {
        return (() -> {
            lock.lock();
            try {
                return map.get("key"+key);
            } finally {
                lock.unlock();
            }
        });
    }
}
