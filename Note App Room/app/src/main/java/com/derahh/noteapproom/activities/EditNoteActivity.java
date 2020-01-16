package com.derahh.noteapproom.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.derahh.noteapproom.viewModel.EditNoteViewModel;
import com.derahh.noteapproom.database.Note;
import com.derahh.noteapproom.R;

public class EditNoteActivity extends AppCompatActivity {

    public static final String NOTE_ID = "note_id";
    static final String UPDATED_NOTE = "note_text";
    private EditText edtUpdateNote;
    private String noteId;

    EditNoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        edtUpdateNote = findViewById(R.id.edt_upadate_note);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            noteId = bundle.getString("note_id");
        }

        viewModel = ViewModelProviders.of(this).get(EditNoteViewModel.class);
        LiveData<Note> note = viewModel.getNote(noteId);
        note.observe(this, new Observer<Note>() {
            @Override
            public void onChanged(Note note) {
                edtUpdateNote.setText(note.getNote());
            }
        });
    }

    public void updateNote(View view) {
        String updateNote = edtUpdateNote.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra(NOTE_ID, noteId);
        resultIntent.putExtra(UPDATED_NOTE, updateNote);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void UpdateCancel(View view) {
        finish();
    }
}
