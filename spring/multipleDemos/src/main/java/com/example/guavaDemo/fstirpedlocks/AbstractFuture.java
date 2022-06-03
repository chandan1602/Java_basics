package com.example.guavaDemo.fstirpedlocks;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public abstract class AbstractFuture {
    public final Map<String, String> doWork(Map<String, String> map, int
                                            threads, int slots) {
        CompletableFuture<?>[] requests = new CompletableFuture<?>
                [threads*slots];
        for(int i=0; i<threads; i++) {
            requests[slots*i + 0] = CompletableFuture.supplyAsync(
                    putSupplier(map, i)
            );
            requests[slots*i + 1] = CompletableFuture.supplyAsync(
                    getSupplier(map, i)
            );
            requests[slots*i + 2] = CompletableFuture.supplyAsync(
                    getSupplier(map, i)
            );
            requests[slots*i + 3] = CompletableFuture.supplyAsync(
                    getSupplier(map, i)
            );
        }
        CompletableFuture.allOf(requests).join();
        return map;
    }

    protected abstract Supplier<?> putSupplier(Map<String, String> map, int key);
    protected abstract Supplier<?> getSupplier(Map<String, String> map, int key);
}
