package com.derahh.noteapproom.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.derahh.noteapproom.database.Note;
import com.derahh.noteapproom.database.NoteDao;
import com.derahh.noteapproom.database.NoteRoomDatabase;

public class EditNoteViewModel extends AndroidViewModel {

    private NoteDao noteDao;

    public EditNoteViewModel(@NonNull Application application) {
        super(application);
        String TAG = this.getClass().getSimpleName();
        Log.i(TAG, "Edit ViewModel");
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        noteDao = db.noteDao();
    }

    public LiveData<Note> getNote(String noteId) {
        return noteDao.getNote(noteId);
    }
}
