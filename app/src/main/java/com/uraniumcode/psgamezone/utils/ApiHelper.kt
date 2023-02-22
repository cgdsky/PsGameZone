package com.uraniumcode.psgamezone.utils

import com.example.example.Images
import com.uraniumcode.psgamezone.models.Screenshots

class ApiHelper {

    fun createImageArray(coverImages: ArrayList<Images>, screenShots: ArrayList<Screenshots>): ArrayList<String> {
         val allImages: ArrayList<String> = arrayListOf()
        allImages.add(coverImages[0].url!!)
        for ( img in screenShots)
        allImages.add(img.url!!)

        return allImages
    }
}