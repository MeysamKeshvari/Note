package dev.meysamkeshvari.Note.mapper;

import dev.meysamkeshvari.Note.model.Note;
import dev.meysamkeshvari.Note.payload.CreateNoteDto;
import org.springframework.stereotype.Service;

@Service
public class NoteMapperImp implements NoteMapper  {

    @Override
    public Note toNote(CreateNoteDto noteDto) {
        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setDescription(noteDto.getDescription());
        return note;
    }
}
