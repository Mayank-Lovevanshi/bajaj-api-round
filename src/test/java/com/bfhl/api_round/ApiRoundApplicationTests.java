package com.bfhl.api_round;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiRoundApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetBfhl() throws Exception {
		mockMvc.perform(get("/bfhl"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.operation_code", is(1)));
	}

	@Test
	void testExampleA() throws Exception {
		String requestJson = "{\"data\": [\"a\", \"1\", \"334\", \"4\", \"R\", \"$\"]}";
		mockMvc.perform(post("/bfhl")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.is_success", is(true)))
				.andExpect(jsonPath("$.user_id", is("mayank_lovevanshi_24022005")))
				.andExpect(jsonPath("$.email", is("mayanklovevanshi230420@acropolis.in")))
				.andExpect(jsonPath("$.roll_number", is("0827CS231152")))
				.andExpect(jsonPath("$.odd_numbers", contains("1")))
				.andExpect(jsonPath("$.even_numbers", contains("334", "4")))
				.andExpect(jsonPath("$.alphabets", contains("A", "R")))
				.andExpect(jsonPath("$.special_characters", contains("$")))
				.andExpect(jsonPath("$.sepcial_characters", contains("$")))
				.andExpect(jsonPath("$.sum", is("339")))
				.andExpect(jsonPath("$.concat_string", is("Ra")));
	}

	@Test
	void testExampleB() throws Exception {
		String requestJson = "{\"data\": [\"2\", \"a\", \"y\", \"4\", \"&\", \"-\", \"*\", \"5\", \"92\", \"b\"]}";
		mockMvc.perform(post("/bfhl")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.is_success", is(true)))
				.andExpect(jsonPath("$.odd_numbers", contains("5")))
				.andExpect(jsonPath("$.even_numbers", contains("2", "4", "92")))
				.andExpect(jsonPath("$.alphabets", contains("A", "Y", "B")))
				.andExpect(jsonPath("$.special_characters", contains("&", "-", "*")))
				.andExpect(jsonPath("$.sepcial_characters", contains("&", "-", "*")))
				.andExpect(jsonPath("$.sum", is("103")))
				.andExpect(jsonPath("$.concat_string", is("ByA")));
	}

	@Test
	void testExampleC() throws Exception {
		String requestJson = "{\"data\": [\"A\", \"ABCD\", \"DOE\"]}";
		mockMvc.perform(post("/bfhl")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.is_success", is(true)))
				.andExpect(jsonPath("$.odd_numbers", hasSize(0)))
				.andExpect(jsonPath("$.even_numbers", hasSize(0)))
				.andExpect(jsonPath("$.alphabets", contains("A", "ABCD", "DOE")))
				.andExpect(jsonPath("$.special_characters", hasSize(0)))
				.andExpect(jsonPath("$.sepcial_characters", hasSize(0)))
				.andExpect(jsonPath("$.sum", is("0")))
				.andExpect(jsonPath("$.concat_string", is("EoDdCbAa")));
	}

	@Test
	void testBadRequest() throws Exception {
		String requestJson = "{}"; // null data list
		mockMvc.perform(post("/bfhl")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.is_success", is(false)));
	}
}
