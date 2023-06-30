package com.mf.invoice.cache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class App {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            runApplication<App>(*args)
        }
    }
}