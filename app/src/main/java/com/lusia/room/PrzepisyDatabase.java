package com.lusia.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = (Wypiek.class), version = 1)
public abstract class PrzepisyDatabase extends RoomDatabase {
    public abstract WypiekiDAO zwrocWypiekiDao();
    private static PrzepisyDatabase instancja;
    public static PrzepisyDatabase zwrocInstancjeBazyDanych(Context context){
        if(instancja == null){
            instancja = Room.databaseBuilder(context, PrzepisyDatabase.class, "przepisyDB")
                    .allowMainThreadQueries()
                    .build();
        }
        // nie powinniśmy tego robić w wątku głównym
        return instancja;
    }
}
