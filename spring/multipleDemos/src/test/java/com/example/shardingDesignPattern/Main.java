package com.example.shardingDesignPattern;

public class Main {
    public static void main(String[] args) {
        Data data1 = new Data(1, "data1", Data.DataType.TYPE_1);
        Data data2 = new Data(2, "data2", Data.DataType.TYPE_2);
        Data data3 = new Data(3, "data3", Data.DataType.TYPE_3);
        Data data4 = new Data(4, "data4", Data.DataType.TYPE_1);

        Shard shard1 = new Shard(1);
        Shard shard2 = new Shard(2);
        Shard shard3 = new Shard(3);

        LookupShardManager manager = new LookupShardManager();
        manager.addNewShard(shard1);
        manager.addNewShard(shard2);
        manager.addNewShard(shard3);
        manager.storeData(data1);
        manager.storeData(data2);
        manager.storeData(data3);
        manager.storeData(data4);

        shard1.clearData();
        shard2.clearData();
        shard3.clearData();

        RangeShardManager rangeShardManager = new RangeShardManager();
        rangeShardManager.addNewShard(shard1);
        rangeShardManager.addNewShard(shard2);
        rangeShardManager.addNewShard(shard3);
        rangeShardManager.storeData(data1);
        rangeShardManager.storeData(data2);
        rangeShardManager.storeData(data3);
        rangeShardManager.storeData(data4);

        shard1.clearData();
        shard2.clearData();
        shard3.clearData();


        HashShardManager hashShardManager = new HashShardManager();
        hashShardManager.addNewShard(shard1);
        hashShardManager.addNewShard(shard2);
        hashShardManager.addNewShard(shard3);
        hashShardManager.storeData(data1);
        hashShardManager.storeData(data2);
        hashShardManager.storeData(data3);
        hashShardManager.storeData(data4);

        shard1.clearData();
        shard2.clearData();
        shard3.clearData();

    }
}

