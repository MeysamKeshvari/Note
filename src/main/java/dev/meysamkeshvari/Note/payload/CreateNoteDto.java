package dev.meysamkeshvari.Note.payload;

public class CreateNoteDto {

    private String title;
    private String description;

    public CreateNoteDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
