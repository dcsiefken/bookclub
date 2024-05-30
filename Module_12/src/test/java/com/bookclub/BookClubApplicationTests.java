/*
    Clay Siefken (2024) CIS 530 Server-Side Development. Bellevue Univ.
*/

package com.bookclub;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookClubApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnLoginScreen() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Book Club Login")));
	}

	@Test
	@WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
	void shouldReturnUsername() throws Exception {
		this.mockMvc.perform(get("/wishlist")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("My Wishlist")));
	}

}
