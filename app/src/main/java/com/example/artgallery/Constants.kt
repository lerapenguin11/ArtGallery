package com.example.artgallery

import com.example.domain.entities.VolumePicture
import com.example.domain.entities.VolumePictureInfo

object Constants {

    fun getPopularData() : MutableList<VolumePicture>{
        var meditationList = mutableListOf<VolumePicture>()

        val med1 = VolumePicture(0, VolumePictureInfo(R.string.title_popular1, R.string.desc_popular1,
            "https://artinvestment.ru/temp/cache/20190520_Koons-record.jpg",
        R.string.date_1))
        meditationList.add(med1)

        val med2 = VolumePicture(1, VolumePictureInfo(R.string.title_popular2, R.string.desc_popular2,
            "https://artinvestment.ru/content/download/news_2018/20181120_David-Hockney-auction-record.jpg",
            R.string.date_2))
        meditationList.add(med2)

        val med3 = VolumePicture(2, VolumePictureInfo(R.string.title_popular3, R.string.desc_popular3,
            "https://artinvestment.ru/temp/cache/20151006_richter_new_record.jpg",
            R.string.date_3))
        meditationList.add(med3)

        val med4 = VolumePicture(3, VolumePictureInfo(R.string.title_popular4, R.string.desc_popular4,
            "https://artinvestment.ru/content/download/news_2013/20131121_10_Cui_Ruzhuo.jpg",
            R.string.date_4))
        meditationList.add(med4)

        val med5 = VolumePicture(4, VolumePictureInfo(R.string.title_popular5, R.string.desc_popular5,
            "https://artinvestment.ru/content/download/news_2014/20141119_jasper_johns.jpg",
            R.string.date_5))
        meditationList.add(med5)

        val med6 = VolumePicture(5, VolumePictureInfo(R.string.title_popular6, R.string.desc_popular6,
            "https://artinvestment.ru/temp/cache/20141119_ed_ruscha.jpg",
            R.string.date_6))
        meditationList.add(med6)

        val med7 = VolumePicture(6, VolumePictureInfo(R.string.title_popular7, R.string.desc_popular7,
            "https://artinvestment.ru/temp/cache/20150515_wool_record.jpg",
            R.string.date_7))
        meditationList.add(med7)

        val med8 = VolumePicture(7, VolumePictureInfo(R.string.title_popular8, R.string.desc_popular8,
            "https://artinvestment.ru/temp/cache/20170526_Peter-Doig-rating.jpg",
            R.string.date_8))
        meditationList.add(med8)

        return meditationList
    }

    fun getNewestData() : MutableList<VolumePicture>{
        var meditationList = mutableListOf<VolumePicture>()

        val med9 = VolumePicture(8, VolumePictureInfo(R.string.title_newes1, R.string.desc_newes1,
            "https://artinvestment.ru/content/download/news_2019/20190520_Stella-record.jpg",
            R.string.date_1))
        meditationList.add(med9)

        val med10 = VolumePicture(9, VolumePictureInfo(R.string.title_newes2, R.string.desc_newes2,
            "https://artinvestment.ru/temp/cache/20191014_nara_knife.jpg",
            R.string.date_2))
        meditationList.add(med10)

        val med11 = VolumePicture(10, VolumePictureInfo(R.string.title_newes3, R.string.desc_newes3,
            "https://artinvestment.ru/content/download/news_2013/20131121_05_Living_artists_Fanzhi.jpg",
            R.string.date_3))
        meditationList.add(med11)

        val med12 = VolumePicture(11, VolumePictureInfo(R.string.title_newes4, R.string.desc_newes4,
            "https://artinvestment.ru/temp/cache/20150515_ryman_record.jpg",
            R.string.date_4))
        meditationList.add(med12)

        return meditationList
    }

    fun getAllData() : MutableList<VolumePicture>{
        var meditationList = mutableListOf<VolumePicture>()

        val med1 = VolumePicture(0, VolumePictureInfo(R.string.title_popular1, R.string.desc_popular1,
            "https://artinvestment.ru/temp/cache/20190520_Koons-record.jpg",
            R.string.date_1))
        meditationList.add(med1)

        val med2 = VolumePicture(1, VolumePictureInfo(R.string.title_popular2, R.string.desc_popular2,
            "https://artinvestment.ru/content/download/news_2018/20181120_David-Hockney-auction-record.jpg",
            R.string.date_2))
        meditationList.add(med2)

        val med3 = VolumePicture(2, VolumePictureInfo(R.string.title_popular3, R.string.desc_popular3,
            "https://artinvestment.ru/temp/cache/20151006_richter_new_record.jpg",
            R.string.date_3))
        meditationList.add(med3)

        val med4 = VolumePicture(3, VolumePictureInfo(R.string.title_popular4, R.string.desc_popular4,
            "https://artinvestment.ru/content/download/news_2013/20131121_10_Cui_Ruzhuo.jpg",
            R.string.date_4))
        meditationList.add(med4)

        val med5 = VolumePicture(4, VolumePictureInfo(R.string.title_popular5, R.string.desc_popular5,
            "https://artinvestment.ru/content/download/news_2014/20141119_jasper_johns.jpg",
            R.string.date_5))
        meditationList.add(med5)

        val med6 = VolumePicture(5, VolumePictureInfo(R.string.title_popular6, R.string.desc_popular6,
            "https://artinvestment.ru/temp/cache/20141119_ed_ruscha.jpg",
            R.string.date_6))
        meditationList.add(med6)

        val med7 = VolumePicture(6, VolumePictureInfo(R.string.title_popular7, R.string.desc_popular7,
            "https://artinvestment.ru/temp/cache/20150515_wool_record.jpg",
            R.string.date_7))
        meditationList.add(med7)

        val med8 = VolumePicture(7, VolumePictureInfo(R.string.title_popular8, R.string.desc_popular8,
            "https://artinvestment.ru/temp/cache/20170526_Peter-Doig-rating.jpg",
            R.string.date_8))
        meditationList.add(med8)

        val med9 = VolumePicture(8, VolumePictureInfo(R.string.title_newes1, R.string.desc_newes1,
            "https://artinvestment.ru/content/download/news_2019/20190520_Stella-record.jpg",
            R.string.date_1))
        meditationList.add(med9)

        val med10 = VolumePicture(9, VolumePictureInfo(R.string.title_newes2, R.string.desc_newes2,
            "https://artinvestment.ru/temp/cache/20191014_nara_knife.jpg",
            R.string.date_2))
        meditationList.add(med10)

        val med11 = VolumePicture(10, VolumePictureInfo(R.string.title_newes3, R.string.desc_newes3,
            "https://artinvestment.ru/content/download/news_2013/20131121_05_Living_artists_Fanzhi.jpg",
            R.string.date_3))
        meditationList.add(med11)

        val med12 = VolumePicture(11, VolumePictureInfo(R.string.title_newes4, R.string.desc_newes4,
            "https://artinvestment.ru/temp/cache/20150515_ryman_record.jpg",
            R.string.date_4))
        meditationList.add(med12)

        return meditationList
    }

}