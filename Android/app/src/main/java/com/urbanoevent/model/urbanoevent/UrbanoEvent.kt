package com.urbanoevent.model.urbanoevent

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey



/**
 * Created by cinq on 23/01/18.
 */
@Entity(tableName = "urbano_events")
data class UrbanoEvent(
        @PrimaryKey  @ColumnInfo(name = "id")
        var id: Long = 0,

        @ColumnInfo(name = "title")
        var title: String? = null,


        @ColumnInfo(name = "desc")
        var desc: String? = null
)


