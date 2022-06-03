package com.example.guavaDemo;

import com.google.common.util.concurrent.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class DListenableFutureTest {
    @Test
    public void creatingListenableFuture() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<Integer> asyncTask = listeningExecutorService.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 5;
        });
    }

    @Test
    public void implementingCallback() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(executor);
        ListenableFuture<Integer> f1 = listeningExecutorService.submit(() -> 1);
        Futures.addCallback(f1, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                System.out.println("Success");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Failure");
            }
        }, executor);
    }

    @Test
    public void fanIn() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<String> task1 = listeningExecutorService.submit(() -> "Config1");
        ListenableFuture<String> task2 = listeningExecutorService.submit(() -> "Config2");
        ListenableFuture<String> task3 = listeningExecutorService.submit(() -> "Config3");
        //If either 1 result fails, whole future fails
        //        Futures.allAsList(task1, task2, task3);
        //Failed are returned as null
        ListenableFuture<List<String>> configTasks =
                Futures.successfulAsList(task1, task2, task3);
        Futures.addCallback(configTasks, new FutureCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> strings) {
                System.out.println("Sucess");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Failure");
            }
        }, executorService);

    }

    @Test
    public void fanInWithCombiners() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ListeningExecutorService service =
                MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<String> cartIdTask = service.submit(() -> "NVWI4YF378HEF83G8");
        ListenableFuture<String> customerNameTask = service.submit(() -> "Chandan Bansal");
        ListenableFuture<List<String>> cartItemsTask =
                service.submit(() -> Arrays.asList("Laptop", "Headphone", "Hard Drive", "RAM"));
        ListenableFuture<CartInfo> cartInfoTask =
                Futures.whenAllSucceed(cartIdTask, customerNameTask, cartItemsTask)
                        .call(() -> {
                            String cartId = Futures.getDone(cartIdTask);
                            String customerName = Futures.getDone(customerNameTask);
                            List<String> cartItems = Futures.getDone(cartItemsTask);
                            return new CartInfo(cartId, customerName, cartItems);
                        }, executorService);

        Futures.addCallback(cartInfoTask, new FutureCallback<CartInfo>() {
            @Override
            public void onSuccess(CartInfo cartInfo) {
                try {
                    System.out.println("Success");
                    System.out.println("INFO : " + cartInfoTask);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Failed");
            }
        }, service);
    }


}

