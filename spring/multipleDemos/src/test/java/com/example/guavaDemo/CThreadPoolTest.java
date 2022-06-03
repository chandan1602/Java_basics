package com.example.guavaDemo;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//support for adding success/failure callbacks
//

class CThreadPoolTest {
    @Test
    public void directExecutor() {
        Executor executor = MoreExecutors.directExecutor();
        AtomicBoolean executed = new AtomicBoolean();
        executor.execute(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executed.set(true);
        });
        assertTrue(executed.get());
    }

//    @Test
//    public void exitJVMInTime() {
//        ThreadPoolExecutor executor =
//                (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
//        ExecutorService executorService = MoreExecutors.getExitingExecutorService(executor,
//                100, TimeUnit.MILLISECONDS);
//        executorService.submit(() -> {
//            while (true) {
//                System.out.println("Infinite Loop");
//            }
//        });
//    }

    @Test
    public void usingCombineMultipleFutures() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<String> future1 = listeningExecutorService.submit(() -> "Hello");
        ListenableFuture<String> future2 = listeningExecutorService.submit(() -> "World");
        String greeting = Futures.allAsList(future1, future2).get()
                .stream()
                .collect(Collectors.joining(" "));
        assertEquals("Hello World", greeting);
    }
}