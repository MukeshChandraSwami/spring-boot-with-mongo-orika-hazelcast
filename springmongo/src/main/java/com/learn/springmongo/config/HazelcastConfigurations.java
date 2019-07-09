package com.learn.springmongo.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import com.learn.springmongo.constants.GenericConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mongojava")
public class HazelcastConfigurations {

    @Bean
    public Config hazelcastCacheConfig(){

        Config conf = new Config();
        conf.setInstanceName(GenericConstants.SPRING_BOOT_WITH_MONGODB_AND_HAZELCAST_CASE);

        // Cache for all authors
        MapConfig allAuthorConfig = new MapConfig(GenericConstants.AUTHOR_CACHE_ALL);
        allAuthorConfig.setTimeToLiveSeconds(3600);
        allAuthorConfig.setEvictionPolicy(EvictionPolicy.LRU);
        conf.getMapConfigs().put(GenericConstants.AUTHOR_CACHE_ALL,allAuthorConfig);

        // Cache for getting author by ID
        MapConfig authorByIdCache = new MapConfig(GenericConstants.AUTHOR_BY_ID_CACHE);
        authorByIdCache.setTimeToLiveSeconds(3600);
        authorByIdCache.setEvictionPolicy(EvictionPolicy.LRU);
        conf.getMapConfigs().put(GenericConstants.AUTHOR_BY_ID_CACHE,authorByIdCache);

        // Cache for getting author by list of IDs
        MapConfig authorByIdListCache = new MapConfig(GenericConstants.AUTHOR_BY_ID_LIST_CACHE);
        authorByIdListCache.setTimeToLiveSeconds(3600);
        authorByIdListCache.setEvictionPolicy(EvictionPolicy.LRU);
        conf.getMapConfigs().put(GenericConstants.AUTHOR_BY_ID_LIST_CACHE,authorByIdListCache);

        return conf;
    }

    @Bean
    public HazelcastInstance createHazelcastInstance(){
        return Hazelcast.newHazelcastInstance(hazelcastCacheConfig());
    }

    @Bean (name = "hazelcast-cache-manager")
    public HazelcastCacheManager cacheManager(){
        return new HazelcastCacheManager(createHazelcastInstance());
    }


}
