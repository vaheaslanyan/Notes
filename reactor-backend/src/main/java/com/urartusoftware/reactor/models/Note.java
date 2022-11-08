package com.urartusoftware.reactor.models;

import java.sql.Timestamp;

public class Note {

    private int noteId;
    private String title;
    private String content;
    private Timestamp timestamp;
    private int userId;

    /* Constructors -----------------------------------------*/
    public Note() {
    }

    public Note(int noteId, String title, String content, Timestamp timestamp, int userId) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    /* toString ---------------------------------------------*/
    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                '}';
    }

    /* Getters & Setters ------------------------------------*/
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
