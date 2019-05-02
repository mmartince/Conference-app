package hr.tvz.martincevic.tests;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest
{
	private MockMvc mockMvc;
	
	@Autowired
	PredavanjeRepository predavanjeRepository;

	@Autowired
	MainControllerTest(MockMvc mockMvc)
	{
		this.mockMvc = mockMvc;
	}

	@Test
	public void testPrikaziSvaPredavanja() throws Exception
	{
		this.mockMvc.perform(get("/predavanja/list").with(user("test").password("testpass").roles("USER", "ADMIN")))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("datas"))
				.andExpect(view().name("list"));
	}
	
	@Test
	public void testInvalidPredavanjeSubmit() throws Exception
	{
		this.mockMvc.perform(post("/predavanja/novoPredavanje")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.with(csrf())
				.with(user("test").password("testpass").roles("USER","ADMIN")).sessionAttr("listaPredavanja", ""))
				.andExpect(status().isOk())
				.andExpect(view().name("novoPredavanje"));
		
	}
}