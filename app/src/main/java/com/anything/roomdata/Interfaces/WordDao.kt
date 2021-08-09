package com.anything.roomdata.Interfaces

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anything.roomdata.Database.Word
import kotlinx.coroutines.flow.Flow
import androidx.room.Dao;

@Dao interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}