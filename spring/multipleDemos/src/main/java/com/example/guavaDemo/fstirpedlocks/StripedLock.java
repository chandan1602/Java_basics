package com.example.guavaDemo.fstirpedlocks;

import com.google.common.util.concurrent.Striped;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.function.Supplier;

public class StripedLock extends AbstractFuture {
    Striped stripedLock;

    public StripedLock(int buckets) {
        stripedLock = Striped.lock(buckets);
    }

    @Override
    protected Supplier<?> putSupplier(Map<String, String> map, int key) {
        return (() -> {
            int bucket = key%stripedLock.size();
            Lock lock = (Lock) stripedLock.get(bucket);
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
            int bucket = key%stripedLock.size();
            Lock lock = (Lock) stripedLock.get(bucket);
            lock.lock();
            try {
                return map.get("key"+key);
            } finally {
                lock.unlock();
            }
        });
    }
}
