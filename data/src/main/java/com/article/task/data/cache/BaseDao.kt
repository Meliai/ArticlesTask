package com.article.task.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Delete
import io.reactivex.Completable

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(objects: List<T>): Completable

    @Update
    fun update(obj: T): Completable

    @Update
    fun updateAll(list: List<T>): Completable

    @Delete
    fun delete(obj: T): Completable
}