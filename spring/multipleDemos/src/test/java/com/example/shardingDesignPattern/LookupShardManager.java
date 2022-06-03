package com.example.shardingDesignPattern;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LookupShardManager extends ShardManager{
    private final Map<Integer, Integer> lookupMap = new HashMap<>();

    @Override
    public int storeData(Data data) {
        int shardId = allocateShard(data);
        lookupMap.put(data.getKey(), shardId);
        Shard shard = shardMap.get(shardId);
        shard.storeData(data);
        System.out.format("%s is stored in Shard %d\n" , data.toString(), shardId);
        return shardId;
    }

    @Override
    protected int allocateShard(Data data) {
        int key = data.getKey();
        if(lookupMap.containsKey(key)) {
            return lookupMap.get(key);
        } else {
            int shardCount = shardMap.size();
            return new SecureRandom().nextInt(shardCount - 1) + 1;
        }
    }
}
