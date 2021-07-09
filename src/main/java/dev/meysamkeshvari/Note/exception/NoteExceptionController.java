package dev.meysamkeshvari.Note.exception;

import dev.meysamkeshvari.Note.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoteExceptionController {
    @ExceptionHandler(value = NoteNotFoundException.class)
    public ResponseEntity<Object> exception(NoteNotFoundException exception){
        return new ResponseEntity<>(new Result("Note Not Founding"), HttpStatus.NOT_FOUND);
    }
}
