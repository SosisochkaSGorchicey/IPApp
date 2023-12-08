package com.example.ipapp.data.datasource.model

import com.google.gson.annotations.SerializedName

data class IPDataModel(
    @SerializedName("continent")
    val continent: Continent? = Continent(),

    @SerializedName("country")
    val country: Country? = Country(),

    @SerializedName("city")
    val city: City? = City(),

    @SerializedName("location")
    val location: Location? = Location(),

    @SerializedName("isp")
    val isp: Isp? = Isp(),

    @SerializedName("message")
    val message: String? = null
)

data class Continent(
    @SerializedName("name")
    val name: String? = null
)

data class Country(
    @SerializedName("isoCode")
    val isoCode: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("flagUrls")
    val flagUrls: FlagUrls? = FlagUrls()
)

data class City(
    @SerializedName("name")
    val name: String? = null
)

data class Location(
    @SerializedName("latitude")
    val latitude: Double? = null,

    @SerializedName("longitude")
    val longitude: Double? = null
)

data class Isp(
    @SerializedName("asn")
    val asn: Int? = null,

    @SerializedName("asn_organization")
    val asnOrganization: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("organization")
    val organization: String? = null,

    @SerializedName("connection_type")
    val connectionType: String? = null
)


data class FlagUrls(
    @SerializedName("24")
    val imageUrl: String? = null
)