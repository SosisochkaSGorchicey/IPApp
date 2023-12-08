package com.example.ipapp.data

import com.example.ipapp.data.datasource.model.IPDataModel
import com.example.ipapp.domain.model.IPData

fun IPDataModel.toDomain(): IPData {
    return IPData(
        continent = this.continent?.name,
        country = this.country?.name,
        city = this.city?.name,
        latitude = this.location?.latitude,
        longitude = this.location?.longitude,
        isoCode = this.country?.isoCode,
        message = this.message,
        flagUrl = this.country?.flagUrls?.imageUrl,
        connectionType = this.isp?.connectionType,
        organization = this.isp?.organization,
        ispName = this.isp?.name,
        asn = this.isp?.asn,
        asnOrganization = this.isp?.asnOrganization
    )
}