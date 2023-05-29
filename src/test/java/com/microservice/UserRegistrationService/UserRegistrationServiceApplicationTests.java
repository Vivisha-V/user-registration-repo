package com.microservice.UserRegistrationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserRegistrationServiceApplicationTests
{
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateNewUser() throws Exception {
		String requestBody = "{\"firstname\":\"test\", \"lastname\":\"test1\" , \"age\":\"20\" , \"contact\":\"test@gmai.com\"}";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/User/newUser")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void testGetAllUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/User/allUser"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray());
	}

	@Test
	void contextLoads() {
	}

}
