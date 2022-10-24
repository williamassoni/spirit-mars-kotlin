package com.assoni.mars.objects.location

class Wold {
    object WoldLimit{
        const val MAX_LATITUDE = 5
        const val MAX_LONGITUDE = 5
    }

    fun isValidLatitude(latitude: Long) : Boolean {
        return latitude >= 0 && latitude <= WoldLimit.MAX_LATITUDE
    }

    fun isValidLongitude(longitude: Long) : Boolean {
        return longitude >= 0 && longitude <= WoldLimit.MAX_LONGITUDE
    }
}
