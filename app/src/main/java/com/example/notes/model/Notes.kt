package com.example.notes.model

import android.icu.text.CaseMap
import android.os.Parcelable
import android.webkit.WebSettings
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id : Int?=null,
    var title: String,
    var subtitle : String,
    var notes : String,
    var date  : String,
    var priority: String

):  Parcelable {

}