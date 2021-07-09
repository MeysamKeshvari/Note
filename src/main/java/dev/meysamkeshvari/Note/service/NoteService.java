package dev.meysamkeshvari.Note.service;

import dev.meysamkeshvari.Note.model.Note;
import java.util.List;
import java.util.Optional;

public interface NoteService {

    void createNote(Note note);
    void updateNote(String id,Note note);
    void deleteNote(String id);
    Optional<Note> getNoteById(String id);
    List<Note> getNotes();
}
