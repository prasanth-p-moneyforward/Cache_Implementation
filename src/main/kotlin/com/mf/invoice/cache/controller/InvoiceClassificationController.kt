package com.mf.invoice.cache.controller

import com.mf.invoice.cache.entity.InvoiceClassification
import com.mf.invoice.cache.service.InvoiceClassificationService
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoiceClassification")
@EnableCaching
class InvoiceClassificationController(private val invoiceClassificationService: InvoiceClassificationService) {

    @GetMapping("/{id}")
    fun getInvoiceClassificationById(@PathVariable id: Int): InvoiceClassification {
        return invoiceClassificationService.getInvoiceClassificationById(id)
    }

    @PostMapping
    fun createInvoiceClassification(@RequestBody invoiceClassification: InvoiceClassification): InvoiceClassification {
        return invoiceClassificationService.createInvoiceClassification(invoiceClassification)
    }

    @PutMapping("/{id}")
    fun updateInvoiceClassification(@PathVariable id: Int, @RequestBody invoiceClassification: InvoiceClassification): InvoiceClassification {
        invoiceClassification.id = id
        return invoiceClassificationService.updateInvoiceClassification(invoiceClassification)
    }

    @DeleteMapping("/{id}")
    fun deleteInvoiceClassification(@PathVariable id: Int) {
        invoiceClassificationService.deleteInvoiceClassification(id)
    }
}
