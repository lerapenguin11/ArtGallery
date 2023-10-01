package com.example.artgallery

import com.example.domain.entities.VolumePicture
import com.example.domain.entities.VolumePictureInfo

object Constants {

    fun getMeditationVeryGoodData() : MutableList<VolumePicture>{
        var meditationList = mutableListOf<VolumePicture>()

        val med1 = VolumePicture(0, VolumePictureInfo(R.string.all, R.string.app_name, "https://artinvestment.ru/temp/cache/20150515_wool_record.jpg",
        R.string.all))

        meditationList.add(med1)

        val med2 = VolumePicture(1, VolumePictureInfo(R.string.get_started, R.string.app_name, "https://artinvestment.ru/temp/cache/20170526_Peter-Doig-rating.jpg",
            R.string.all))

        meditationList.add(med2)

        return meditationList
    }

}