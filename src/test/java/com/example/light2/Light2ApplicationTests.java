package com.example.light2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class Light2ApplicationTests {
    private final MockMvc mockMvc;
    @Autowired
    public Light2ApplicationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

//	@Test
//	void adminCreatesEventParticipantSingsInAdminAccepts() {
//		eventService.create(0,"event1", 155);
//		Participant participant = Participant.builder()
//				.username("user1")
//				.age(18)
//				.build();
//		participantRepository.save(participant);
//		eventService.signUp(0,0);
//		assertFalse(eventService.checkAccepted(0, 0));
//		eventService.acceptParticipant(0, 0);
//		assertTrue(eventService.checkAccepted(0, 0));
//	}

    @Test
    public void test1() throws Exception {
        mockMvc.perform(
                        post("/users/admin")
//								.contentType(MediaType.APPLICATION_JSON)
                                .content("admin1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(0));

        mockMvc.perform(
                        get("/users"))
//								.contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("0"));
    }

}
