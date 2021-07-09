package dev.meysamkeshvari.Note.mapper;

import dev.meysamkeshvari.Note.model.Note;
import dev.meysamkeshvari.Note.payload.CreateNoteDto;

public interface NoteMapper {
    Note toNote(CreateNoteDto noteDto);
}
