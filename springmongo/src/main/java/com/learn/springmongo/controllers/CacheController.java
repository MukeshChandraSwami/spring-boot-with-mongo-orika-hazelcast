package com.learn.springmongo.controllers;

import com.hazelcast.map.impl.proxy.MapProxyImpl;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

   @Autowired
    private HazelcastCacheManager cacheManager;

    @GetMapping("/all/names")
    public List<String> getCacheDetails(){

        List<String> allCacheNames = new ArrayList<>();
        Collection<String> cacheNames = cacheManager.getCacheNames();

        cacheNames.stream().forEach(c -> {
            Cache cache = cacheManager.getCache(c);
            Object nativeCache = cache.getNativeCache();
            System.out.println("Name of class :- " + nativeCache.getClass());
            allCacheNames.add(c);
        });
        return allCacheNames;
    }

    @GetMapping("/all/name-and-value")
    public Map<Object, MapProxyImpl<Object,Object>> getCacheAndValueMapping(){

        Map<Object, MapProxyImpl<Object,Object>> cacheMap = new HashMap<>();
        Collection<String> cacheNames = cacheManager.getCacheNames();

        cacheNames.stream().forEach(c -> {
            Cache cache = cacheManager.getCache(c);
            MapProxyImpl nativeCache = (MapProxyImpl)cache.getNativeCache();
            cacheMap.put(c,nativeCache);
        });

        return cacheMap;
    }
}
