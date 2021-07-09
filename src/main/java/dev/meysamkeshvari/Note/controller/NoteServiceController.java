package dev.meysamkeshvari.Note.controller;

import dev.meysamkeshvari.Note.mapper.NoteMapper;
import dev.meysamkeshvari.Note.model.Note;
import dev.meysamkeshvari.Note.model.Result;
import dev.meysamkeshvari.Note.payload.CreateNoteDto;
import dev.meysamkeshvari.Note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/notes")
public class NoteServiceController {

    NoteMapper noteMapper;
    NoteService noteService;

    @Autowired
    public NoteServiceController(NoteService noteService, NoteMapper noteMapper) {
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getNotes() {
        return new ResponseEntity<>(noteService.getNotes(), HttpStatus.OK);
    }

    @PostMapping(value = "/createNote",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createNote(@RequestBody CreateNoteDto note) {
        noteService.createNote(noteMapper.toNote(note));
        //return new ResponseEntity<>("Note is Created Successful", HttpStatus.CREATED);
        return new ResponseEntity<>(new Result("Note is Created Successful"), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateNote(@PathVariable("id") String id, @RequestBody CreateNoteDto note) {
        noteService.updateNote(id, noteMapper.toNote(note));
        return new ResponseEntity<>(new Result("Note is Updated Successful"), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteNote(@PathVariable("id") String id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(new Result("Note is Deleted Successful"), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getNoteById(@PathVariable("id") String id) {
        Optional<Note> noteById = noteService.getNoteById(id);
        if (noteById.isPresent()) {
            return new ResponseEntity<>(noteById.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
