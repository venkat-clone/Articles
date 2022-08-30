package com.android.articles

import android.os.Parcel
import android.os.Parcelable
import com.android.articles.retrofit.ArticleEntity

class ArticleParcelable : Parcelable {
    private var url: String
    private var id: Long? = null
    private var source: String
    private var title: String
    private var abstract: String
    private var updated: String
    private var byLine: String


    constructor(parcel: Parcel) {
        url = parcel.readString()!!
        source = parcel.readString()!!
        title = parcel.readString()!!
        abstract = parcel.readString()!!
        updated = parcel.readString()!!
        byLine = parcel.readString()!!
        id = parcel.readLong()
    }

    constructor(articleEntity: ArticleEntity) {
        this.url = articleEntity.url
        this.id = articleEntity.id
        this.source = articleEntity.source
        this.title = articleEntity.title
        this.abstract = articleEntity.abstract
        this.updated = articleEntity.updated
        this.byLine = articleEntity.byline
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(source)
        parcel.writeString(title)
        parcel.writeString(abstract)
        parcel.writeString(updated)
        parcel.writeString(byLine)
        parcel.writeLong(id!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleParcelable> {
        override fun createFromParcel(parcel: Parcel): ArticleParcelable {
            return ArticleParcelable(parcel)
        }

        override fun newArray(size: Int): Array<ArticleParcelable?> {
            return arrayOfNulls(size)
        }

    }

    fun getEntity(): ArticleEntity {
        return ArticleEntity(url, id!!, source, title, abstract, updated, byLine)
    }

}