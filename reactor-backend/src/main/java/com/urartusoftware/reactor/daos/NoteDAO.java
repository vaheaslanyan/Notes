package com.urartusoftware.reactor.daos;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="notes")
public class NoteDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    @UpdateTimestamp
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "noteStatusId")
    private NoteStatusDAO noteStatusId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserDAO userId;

    /* Constructors ------------------------------------------------------------------*/
    public NoteDAO() {
    }

    @Autowired
    public NoteDAO(String title, String content, NoteStatusDAO noteStatusId, UserDAO userId) {
        this.title = title;
        this.content = content;
        this.noteStatusId = noteStatusId;
        this.userId = userId;
    }



    /* toString ----------------------------------------------------------------------*/
    @Override
    public String toString() {
        return "NoteDAO{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tmiestamp=" + timestamp +
                ", noteStatusId=" + noteStatusId +
                ", userId=" + userId +
                '}';
    }


    /* Getters & Setters--------------------------------------------------------------*/
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

    public NoteStatusDAO getNoteStatusId() {
        return noteStatusId;
    }

    public void setNoteStatusId(NoteStatusDAO noteStatusId) {
        this.noteStatusId = noteStatusId;
    }

    public UserDAO getUserId() {
        return userId;
    }

    public void setUserId(UserDAO userId) {
        this.userId = userId;
    }
}
