package hr.tvz.martincevic.tests;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest
{
	private MockMvc mockMvc;
	
	@Autowired
	LoginTest(MockMvc mockMvc)
	{
		this.mockMvc=mockMvc;
	}
	
	@Test
	public void testFormLoginAdmin() throws Exception
	{
		this.mockMvc.perform(formLogin("/login").user("username", "admin").password("password", "adminpass"))
		.andExpect(authenticated());
	}
	
	@Test
	public void testFormLoginFailed() throws Exception
	{
		this.mockMvc.perform(formLogin("/login").user("username", "").password("password", ""))
		.andExpect(unauthenticated());
	}
	
}
