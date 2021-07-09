package dev.meysamkeshvari.Note.service;

import dev.meysamkeshvari.Note.exception.NoteNotFoundException;
import dev.meysamkeshvari.Note.model.Note;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NoteServiceImpl implements NoteService {

    private Map<String, Note> noteRepo = new HashMap<>();

    AtomicInteger atomicInteger = new AtomicInteger();

    public NoteServiceImpl() {

        Note note1 = new Note();
        note1.setId(atomicInteger.incrementAndGet() + "");
        note1.setTitle("go to shopping");
        note1.setDescription("materials of cake");
        noteRepo.put(note1.getId(), note1);

        Note note2 = new Note();
        note2.setId(atomicInteger.incrementAndGet() + "");
        note2.setTitle("dish washer");
        note2.setDescription("washing dishes");
        noteRepo.put(note2.getId(), note2);
    }

    @Override
    public void createNote(Note note) {
        note.setId(atomicInteger.incrementAndGet() + "");
        noteRepo.put(note.getId(), note);
    }

    @Override
    public void updateNote(String id, Note note) {
        if (!noteRepo.containsKey(id))
            throw new NoteNotFoundException();
        noteRepo.remove(id);
        note.setId(id);
        noteRepo.put(id, note);
    }

    @Override
    public void deleteNote(String id) {
        if (!noteRepo.containsKey(id))
            throw new NoteNotFoundException();
        noteRepo.remove(id);
    }

    @Override
    public Optional<Note> getNoteById(String id) {
        if (!noteRepo.containsKey(id))
            throw new NoteNotFoundException();
        return Optional.of(noteRepo.get(id));
    }

    @Override
    public List<Note> getNotes() {
        return new ArrayList<>(noteRepo.values());
    }
}
