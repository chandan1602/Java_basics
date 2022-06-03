package com.example.shardingDesignPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HashShardManager extends ShardManager{
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
        int shardCount = shardMap.size();
        int hash = data.getKey()%shardCount;
        return hash==0 ? hash + shardCount : hash;
    }
}
