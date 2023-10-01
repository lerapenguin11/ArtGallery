package com.example.artgallery.mappers

import com.example.artgallery.entities.FavoriteStatus
import com.example.artgallery.entities.PictureWithStatus
import com.example.domain.entities.VolumePicture
import com.example.domain.entities.VolumePictureInfo

class PictureWithStatusMapper {

    fun fromVolumeToPictureWithStatus(
        volumes: List<VolumePicture>,
        bookmarks: List<VolumePicture>
    ): List<PictureWithStatus> {
        val commonElements = volumes.filter { it.id in bookmarks.map { bookmark -> bookmark.id } }
        val booksWithStatus = arrayListOf<PictureWithStatus>()
        for (volume in volumes) {
            if (volume in commonElements) {
                booksWithStatus.add(
                    PictureWithStatus(
                        id = volume.id,
                        title = volume.volumeInfo.title,
                        description = volume.volumeInfo.description,
                        icon = volume.volumeInfo.icon,
                        dateCity = volume.volumeInfo.dateCity,
                        FavoriteStatus.FAVORITE
                    )
                )
            } else {
                booksWithStatus.add(
                    PictureWithStatus(
                        id = volume.id,
                        title = volume.volumeInfo.title,
                        description = volume.volumeInfo.description,
                        icon = volume.volumeInfo.icon,
                        dateCity = volume.volumeInfo.dateCity,
                        FavoriteStatus.UNFAVORITE
                    )
                )
            }
        }
        return booksWithStatus.sortedBy { it.id }
    }

    fun fromPictureWithStatusToVolume(bookWithStatus: PictureWithStatus): VolumePicture {
        return VolumePicture(
            bookWithStatus.id,
            VolumePictureInfo(
                title = bookWithStatus.title,
                description = bookWithStatus.description,
                icon = bookWithStatus.icon,
                dateCity = bookWithStatus.dateCity)
        )
    }
}