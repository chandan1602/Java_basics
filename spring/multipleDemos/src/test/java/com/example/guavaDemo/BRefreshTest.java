package com.example.guavaDemo;

import com.google.common.cache.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

//Refresh Automatically after 1 minute
class BRefreshTest {
    @Test
    public void whenLiveTimeEnd_thenRefresh() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return s.toUpperCase();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .build(loader);
    }

    @Test
    public void whenPreloadCache_thenUsePutAll() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return s.toUpperCase();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .build(loader);
        Map<String, String> map = new HashMap<>();
        map.put("first", "FIRST");
        map.put("second", "SECOND");
        cache.putAll(map);
        assertEquals(2, cache.size());
    }

    @Test
    public void whenEntryRemovedFromCache_thenNotify() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return s.toUpperCase();
            }
        };

        RemovalListener<String, String> listener;
        listener = new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> removalNotification) {
                if(removalNotification.wasEvicted()) {
                    String cause = removalNotification.getCause().name();
                    assertEquals(RemovalCause.SIZE.toString(), cause);
                }
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build(loader);
        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");
        assertEquals(3, cache.size());
    }
}