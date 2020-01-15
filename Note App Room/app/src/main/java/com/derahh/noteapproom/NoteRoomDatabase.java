package com.derahh.noteapproom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static volatile NoteRoomDatabase mInstance;

    static NoteRoomDatabase getDatabase(final Context context) {
        if (mInstance == null) {
            synchronized (NoteRoomDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class, "note_database")
                            .build();
                }
            }
        }
        return mInstance;
    }
}
