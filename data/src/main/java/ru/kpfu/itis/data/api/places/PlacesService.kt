package ru.kpfu.itis.data.api.places

import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesService {

    @GET("nearbysearch/json")
    suspend fun nearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radiusInMeters: Int,
        @Query("type") placeType: String
    ): NearbyPlacesResponse
}
