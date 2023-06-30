package com.mf.invoice.cache.entity

import java.time.LocalDateTime
import javax.persistence.Basic
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "invoice_classifications", schema = "invoice")
class InvoiceClassification {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    var id: Int? = null

    var name: String? = null
    @Basic(fetch = FetchType.LAZY)
    var classification_type: Int? = null
    var create_user: String? = null
    var create_datetime: LocalDateTime? = null
    var update_user: String? = null
    var update_datetime: LocalDateTime? = null

}