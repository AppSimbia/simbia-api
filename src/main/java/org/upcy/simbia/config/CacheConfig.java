package org.upcy.simbia.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    String[] cachesNames = {
            "posts",
            "postsId",
            "categories",
            "solicitations",
            "plans",
            "planId",
            "types",
            "industryId",
            "industryCnpj"
    };

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = new ArrayList<>();

        for (String cacheName : cachesNames) {
            CaffeineCache cache = new CaffeineCache(cacheName,
                    Caffeine.newBuilder()
                            .maximumSize(15)
                            .expireAfterWrite(3, TimeUnit.MINUTES)
                            .build());
            caches.add(cache);
        }

        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
