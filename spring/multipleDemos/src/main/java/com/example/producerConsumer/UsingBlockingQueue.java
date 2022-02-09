package com.example.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

        //Producer
        final Runnable producer = () -> {
            while (true) {
                try {
                    queue.put(Item.createItem());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        //Consumer
        final Runnable consumer = () -> {
            while(true) {
                Item i = null;
                try {
                    i = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Item.process(i);
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();
        Thread.sleep(1000);

    }
}

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Item createItem() {
        return new Item("item", 900);
    }

    public static void process(Item item) {
        System.out.println(item.toString());
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
