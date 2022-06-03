package com.example.guavaDemo;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class AEvictionsTest {
    @Test
    public void whenCacheMiss_thenValueIsComputed() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<>() {
            @Override
            public String load(String s){
                return s.toUpperCase();
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder().build(loader);

        assertEquals(0, cache.size());
        assertEquals("HELLO", cache.getUnchecked("hello"));
        assertEquals(1, cache.size());
    }

    //Evictions
    @Test
    public void whenCacheReachMaxSize_thenEviction() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<>() {
            @Override
            public String load(String s){
                return s.toUpperCase();
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumSize(3).build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("fourth");
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("FOURTH", cache.getIfPresent("fourth"));
    }

    @Test
    public void whenCacheReachMaxWeight_thenEviction() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<>() {
            @Override
            public String load(String s){
                return s.toUpperCase();
            }
        };

        Weigher<String, String> weighByLength;
        weighByLength = new Weigher<>() {
            @Override
            public int weigh(String key, String value) {
                return value.length();
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumWeight(16)
                .weigher(weighByLength)
                .build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("LAST", cache.getIfPresent("last"));
    }

    @Test
    public void whenEntryIdle_thenEviction() throws InterruptedException {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<>() {
            @Override
            public String load(String s){
                return s.toUpperCase();
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .expireAfterAccess(2, TimeUnit.MILLISECONDS)
                .build(loader);

        cache.getUnchecked("hello");
        assertEquals(1, cache.size());

        cache.getUnchecked("hello");
        Thread.sleep(300);

        cache.getUnchecked("test");
        assertEquals(1, cache.size());
        assertNull(cache.getIfPresent("hello"));
    }

    @Test
    public void whenEntryLiveTimeExpire_thenEviction() throws InterruptedException {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<>() {
            @Override
            public String load(String s){
                return s.toUpperCase();
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.MILLISECONDS)
                .build(loader);

        cache.getUnchecked("hello");
        assertEquals(1, cache.size());

        Thread.sleep(300);

        cache.getUnchecked("test");
        assertEquals(1, cache.size());
        assertNull(cache.getIfPresent("hello"));
    }

    @Test
    public void whenWeakKeyHasNoRef_thenRemoveFromCache() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<>() {
            @Override
            public String load(String s){
                return s.toUpperCase();
            }
        };


        //CACHE WILL STORE KEYS WITH WEAK REFERENCES, AND
        //THE GARBAGE COLLECTOR WILL COLLECT CACHE KEYS
        //THAT ARE NOT REFERENCED ELSEWHERE
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .weakKeys()
                .build(loader);

        cache.getUnchecked("hello");
        assertEquals(1, cache.size());
        cache.getUnchecked("test");
        assertEquals(2, cache.size());
    }

    @Test
    public void whenNullValue_thenOptional() {
        CacheLoader<String, Optional<String>> loader;
        loader = new CacheLoader<>() {
            @Override
            public Optional<String> load(String key){
                return Optional.fromNullable(getSuffix(key));
            }
        };


        //CACHE WILL STORE KEYS WITH WEAK REFERENCES, AND
        //THE GARBAGE COLLECTOR WILL COLLECT CACHE KEYS
        //THAT ARE NOT REFERENCED ELSEWHERE
        LoadingCache<String, Optional<String>> cache;
        cache = CacheBuilder.newBuilder()
                .build(loader);

        assertEquals("txt", cache.getUnchecked("text.txt").get());
        assertFalse(cache.getUnchecked("hello").isPresent());
    }

    private String getSuffix(final String str) {
        int lastIndex = str.lastIndexOf('.');
        if(lastIndex==-1) return null;
        return str.substring(lastIndex+1);
    }
}