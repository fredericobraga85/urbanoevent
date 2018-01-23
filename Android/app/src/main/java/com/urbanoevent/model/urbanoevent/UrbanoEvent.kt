package com.urbanoevent.model.urbanoevent

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey



/**
 * Created by cinq on 23/01/18.
 */
@Entity(tableName = "urbano_events")
class UrbanoEvent {
        @PrimaryKey
        private val uid: Long = 0

        @ColumnInfo(name = "title")
        private val title: String? = null

        @ColumnInfo(name = "desc")
        private val desc: String? = null


}