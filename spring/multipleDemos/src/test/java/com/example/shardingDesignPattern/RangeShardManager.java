package com.example.shardingDesignPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RangeShardManager extends ShardManager{

    @Override
    public int storeData(Data data) {
        int shardId = allocateShard(data);
        Shard shard = shardMap.get(shardId);
        shard.storeData(data);
        System.out.format("%s is stored in Shard %d\n" , data.toString(), shardId);
        return shardId;
    }

    @Override
    protected int allocateShard(Data data) {
        Data.DataType type = data.getType();
        switch (type) {
            case TYPE_1:
                return 1;
            case TYPE_2:
                return 2;
            case TYPE_3:
                return 3;
            default:
                return -1;
        }
    }
}
