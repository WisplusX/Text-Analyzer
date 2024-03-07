package com.example.textanalyzer.controllers;

import com.example.textanalyzer.models.OtherOptions;
import com.example.textanalyzer.models.OtherResponseData;
import com.example.textanalyzer.services.OtherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Тест для класу OtherDataController.
 */
@ExtendWith(MockitoExtension.class)
class OtherDataControllerTest {
    @InjectMocks
    private OtherDataController controller;
    @Mock
    private OtherService service;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    /**
     * Тест методу analyzeOtherData контролера.
     * @throws Exception викидується у випадку помилки під час виконання тесту
     */
    @Test
    public void testAnalyzeOtherData() throws Exception {
        String text = "Test text";
        OtherOptions options = new OtherOptions(true, true, true, true);
        OtherResponseData responseData = new OtherResponseData(3, 6.0, 10, 15);

        when(service.analyzeOtherData(eq(text), eq(options))).thenReturn(responseData);

        mockMvc.perform(post("/api/other")
                        .content("{\"text\":\"Test text\",\"options\":{\"sentenceCount\":true,\"averageSentenceLength\":true,\"averageReadingTime\":true,\"averageSpeakingTime\":true}}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sentenceCount").value(3))
                .andExpect(jsonPath("$.averageSentenceLength").value(6.0))
                .andExpect(jsonPath("$.averageReadingTime").value(10))
                .andExpect(jsonPath("$.averageSpeakingTime").value(15));

        verify(service, times(1)).analyzeOtherData(eq(text), eq(options));
    }
}
