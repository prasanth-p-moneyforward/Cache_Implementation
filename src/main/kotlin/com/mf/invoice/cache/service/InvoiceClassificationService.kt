package com.mf.invoice.cache.service

import com.mf.invoice.cache.entity.InvoiceClassification
import com.mf.invoice.cache.repository.InvoiceClassificationRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class InvoiceClassificationService(private val invoiceClassificationRepository: InvoiceClassificationRepository) {

    @Cacheable(cacheNames = ["caffeineCache"], cacheManager = "cacheManager")
    fun getInvoiceClassificationById(id: Int): InvoiceClassification {
        return invoiceClassificationRepository.findById(id).orElseThrow { Exception("InvoiceClassification not found") }
    }

    @CachePut(cacheNames = ["caffeineCache"], cacheManager = "cacheManager")
    fun createInvoiceClassification(invoiceClassification: InvoiceClassification): InvoiceClassification {
        return invoiceClassificationRepository.save(invoiceClassification)!!
    }

    @CachePut(cacheNames = ["caffeineCache"], cacheManager = "cacheManager")
    fun updateInvoiceClassification(invoiceClassification: InvoiceClassification): InvoiceClassification {
        return invoiceClassificationRepository.save(invoiceClassification)
    }

    @CacheEvict(cacheNames = ["caffeineCache"], cacheManager = "cacheManager")
    fun deleteInvoiceClassification(id: Int) {
        return invoiceClassificationRepository.deleteById(id)
    }
}