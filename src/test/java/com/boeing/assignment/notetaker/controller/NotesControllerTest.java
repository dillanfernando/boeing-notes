package com.boeing.assignment.notetaker.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.boeing.assignment.notetaker.model.Note;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesControllerTest {


	private MockMvc mockMvc;
	
	
	@InjectMocks
	private NotesController notesController;
	
	List<Note> notesList = new ArrayList<>();
	
	@Spy
	List<Note> spyList = Mockito.spy(notesList);
	
		
	StringBuilder noteToSend;
	
	
	@Before
	public void setUp() {
		 MockitoAnnotations.initMocks(this);
		 notesController.setNotesList(spyList);  
		 mockMvc = MockMvcBuilders
	                .standaloneSetup(notesController)
	                .build();
	        
	       
        
	        noteToSend = new StringBuilder();
	        noteToSend.append("{ \"noteId\" : \"1\",")
	        .append("\"user\":\"dillan\",")
	        .append("\"subject\":\"Subject\",")
	        .append("\"note\":\"New Note\"}");
	        
	}
	
	
	@Test
	public void controllerTest_addNoteViaWebService_ExpectItemAddToList() throws Exception {
		
		 mockMvc.perform(
	                post("/services/notes/add")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(noteToSend.toString())
	                        )
	                .andExpect(status().isOk());
		 assertTrue(spyList.size()==1);
		
	}
	
	@Test
	public void controllerTest_getNotesList_ExpectItemsList() throws Exception {
		
		 mockMvc.perform(
	                post("/services/notes/add")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(noteToSend.toString())
	                        )
	                .andExpect(status().isOk());
		
		 mockMvc.perform(
				 	get("/services/notes/get").accept(MediaType.APPLICATION_JSON)
				 ).andExpect(status().isCreated())
		 		  .andExpect(jsonPath("$.[0].noteId", is("1")));
		 
	}
	
	
	
}
