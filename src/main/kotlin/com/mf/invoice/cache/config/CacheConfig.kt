package com.mf.invoice.cache.config

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class CacheConfig {
    @Bean(name = ["cacheManager"])
    fun cacheManager(): CacheManager {
        val caffeineBuilder = Caffeine.newBuilder()
            .initialCapacity(100)
            .maximumSize(500)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .recordStats()
        val caffeineCache = CaffeineCache("caffeineCache", caffeineBuilder.build())
        val simpleCacheManager = SimpleCacheManager()
        simpleCacheManager.setCaches(listOf(caffeineCache))
        return simpleCacheManager
    }
}


