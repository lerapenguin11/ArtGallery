package com.example.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entities.VolumePicture
import com.example.domain.entities.VolumePictureInfo

class PaintingsDataSourceImpl : PaintingsDataSource{
    override suspend fun getPictureData(picture: MutableList<VolumePicture>): MutableList<VolumePicture> {
        val mutableData = mutableListOf<VolumePicture>()
        val list = mutableListOf<VolumePicture>()

        for (i in picture){
            val id = i.id
            val title = i.volumeInfo.title
            val description = i.volumeInfo.description
            val icon = i.volumeInfo.icon
            val dateCity = i.volumeInfo.dateCity

            val listLetterModel = VolumePicture(
                id = id, volumeInfo = VolumePictureInfo(
                    title = title,
                    description = description,
                    icon = icon,
                    dateCity = dateCity)
            )

            list.add(listLetterModel)
        }
        //mutableData.value = list

        return list
    }
}