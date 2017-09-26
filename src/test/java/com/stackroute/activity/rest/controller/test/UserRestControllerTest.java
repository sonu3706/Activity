package com.stackroute.activity.rest.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import com.stackroute.activity.model.User;
import com.stackroute.activity.rest.config.WebConfig;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class UserRestControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Autowired
	private User user;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	private static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
	 
    @Ignore
    @Test
	public void testValidateUser_NoError() throws Exception {
		user.setId("chandan3706");
		user.setPassword("password");
		
		mockMvc.perform(post("http://localhost:8081/ActivityRestService/api/user/autheticate").
				content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
    
    @Ignore
	@Test
	public void testValidateUser_Error() throws Exception {
		user.setId("chandan3706");
		user.setPassword("password");
		
		mockMvc.perform(post("http://localhost:8081/ActivityRestService/api/user/autheticate").
				content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
		
	}
}
