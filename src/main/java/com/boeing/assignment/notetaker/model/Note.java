package com.boeing.assignment.notetaker.model;


/**
 * A POJO which represents one NOTE.
 * @author dilla
 *
 */

public class Note {

	String noteId;
	String user;
	String subject;
	String note;

	
	public final String getUser() {
		return user;
	}
	public final void setUser(String user) {
		this.user = user;
	}
	public final String getNoteId() {
		return noteId;
	}
	public final void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	
	public final String getSubject() {
		return subject;
	}
	public final void setSubject(String subject) {
		this.subject = subject;
	}
	public final String getNote() {
		return note;
	}
	public final void setNote(String note) {
		this.note = note;
	}
	
	
}
