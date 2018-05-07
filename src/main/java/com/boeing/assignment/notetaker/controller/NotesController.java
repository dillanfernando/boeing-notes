package com.boeing.assignment.notetaker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boeing.assignment.notetaker.model.Note;

@RestController
@RequestMapping("/services/notes")
public class NotesController {
	
	private List<Note> notesList = new ArrayList<>();

	@PostMapping(value = "/add", consumes = "application/json", produces="application/json")
	public ResponseEntity<Note> addNote(@RequestBody Note note){
		notesList.add(note);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/get", produces="application/json")
	public ResponseEntity<List<Note>> getNotes() {
		return new ResponseEntity<List<Note>>(notesList,HttpStatus.CREATED);
	}


	public final List<Note> getNotesList() {
		return notesList;
	}


	public final void setNotesList(List<Note> notesList) {
		this.notesList = notesList;
	}
	

}
