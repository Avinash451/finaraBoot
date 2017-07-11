package com.finra.boot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class FinraFileUploadControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private FinraFileUploadController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testGetLoadedFiles() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testUploadFile() throws Exception {
		
		ClassLoader classLoader = getClass().getClassLoader();
		File f1 = new File(classLoader.getResource("UploadTestFile.txt").getFile());
		File f2 = new File(classLoader.getResource("UploadTestFile2.txt").getFile());
		FileInputStream fi1 = new FileInputStream(f1);
		FileInputStream fi2 = new FileInputStream(f2);
		MockMultipartFile fstmp = new MockMultipartFile("file", f1.getName(), "multipart/form-data", fi1);
		MockMultipartFile secmp = new MockMultipartFile("file", f2.getName(), "multipart/form-data", fi2);
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/upload").file(fstmp).file(secmp).param("name", "abc")
				.param("email", "abc@gmail.com").param("phone", "1234567890")).andExpect(status().isOk());
	}
}
