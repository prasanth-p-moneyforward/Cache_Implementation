package com.mf.invoice.cache.repository

import com.mf.invoice.cache.entity.InvoiceClassification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceClassificationRepository : JpaRepository<InvoiceClassification, Int> {
}