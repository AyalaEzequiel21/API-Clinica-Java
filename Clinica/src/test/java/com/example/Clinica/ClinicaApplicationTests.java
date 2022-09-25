package com.example.Clinica;


import com.example.Clinica.Model.DTO.OdontologoDto;
import com.example.Clinica.Service.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClinicaApplicationTests {

	@Autowired
	OdontologoService odontologoService;
	@Autowired
	private MockMvc mvc;

	@Test
	void crearOdontologo() throws Exception{
		OdontologoDto odontologoDto = new OdontologoDto();
		odontologoDto.setMatricula("mo250");
		odontologoDto.setApellido("Ayala");
		odontologoDto.setNombre("Ezequiel");

		String responseApi = "OK";

		ObjectWriter writer = new ObjectMapper()
				.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
				.writer();

		String payloadJson = writer.writeValueAsString(odontologoDto);
		String responseJson = writer.writeValueAsString(responseApi);

		MvcResult response = this.mvc.perform(MockMvcRequestBuilders.post("/odontologos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payloadJson))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn();


		Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
	}

}
