package com.example.ipapp.domain.model

data class IPData(
    val continent: String? = null,

    val country: String? = null,

    val city: String? = null,

    val isoCode: String? = null,

    val message: String? = null,

    val flagUrl: String? = null,

    val latitude: Double? = null,

    val longitude: Double? = null,

    val connectionType: String? = null,

    val organization: String? = null,

    val ispName: String? = null,

    val asn: Int? = null,

    val asnOrganization: String? = null
)
