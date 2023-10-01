package com.example.data.mappers

import com.example.data.entities.PictureEntity
import com.example.domain.entities.VolumePicture
import com.example.domain.entities.VolumePictureInfo

class PictureEntityMapper {

    fun toPictureEntity(volume: VolumePicture): PictureEntity {
        return PictureEntity(
            title = volume.volumeInfo.title,
            idPic = volume.id,
            description = volume.volumeInfo.description,
            icon = volume.volumeInfo.icon,
            dateCity = volume.volumeInfo.dateCity
        )
    }

    fun toVolume(pictureEntity: PictureEntity): VolumePicture {
        return VolumePicture(
            pictureEntity.idPic,
            VolumePictureInfo(
                title = pictureEntity.title,
                description = pictureEntity.description,
                icon = pictureEntity.icon,
                dateCity = pictureEntity.dateCity)
        )
    }
}